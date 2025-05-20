package org.rsmod.content.skills.mining.scripts

import jakarta.inject.Inject
import org.rsmod.api.config.Constants
import org.rsmod.api.config.locParam
import org.rsmod.api.config.locXpParam
import org.rsmod.api.config.objParam
import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.controllers
import org.rsmod.api.config.refs.params
import org.rsmod.api.config.refs.stats
import org.rsmod.api.config.refs.synths
import org.rsmod.api.config.refs.varcons
import org.rsmod.api.controller.vars.intVarCon
import org.rsmod.api.player.output.ClientScripts
import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.api.player.righthand
import org.rsmod.api.player.stat.miningLvl

import org.rsmod.api.random.GameRandom
import org.rsmod.api.repo.controller.ControllerRepository
import org.rsmod.api.repo.loc.LocRepository
import org.rsmod.api.repo.player.PlayerRepository
import org.rsmod.api.script.onAiConTimer
import org.rsmod.api.script.onOpLoc1
import org.rsmod.api.script.onOpLoc2
import org.rsmod.api.script.onOpLoc3
import org.rsmod.api.script.onOpLocU
import org.rsmod.api.stats.levelmod.InvisibleLevels
import org.rsmod.api.stats.xpmod.XpModifiers
import org.rsmod.content.skills.mining.configs.MiningParams
import org.rsmod.events.UnboundEvent
import org.rsmod.game.MapClock
import org.rsmod.game.entity.Controller
import org.rsmod.game.entity.Player
import org.rsmod.game.loc.BoundLocInfo
import org.rsmod.game.obj.InvObj
import org.rsmod.game.type.enums.EnumTypeList
import org.rsmod.game.type.enums.find
import org.rsmod.game.type.loc.LocType
import org.rsmod.game.type.loc.LocTypeList
import org.rsmod.game.type.loc.UnpackedLocType
import org.rsmod.game.type.obj.ObjType
import org.rsmod.game.type.obj.ObjTypeList
import org.rsmod.game.type.obj.UnpackedObjType
import org.rsmod.game.type.seq.SeqType
import org.rsmod.map.zone.ZoneKey
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class Mining
@Inject
constructor(
    private val objTypes: ObjTypeList,
    private val locTypes: LocTypeList,
    private val enumTypes: EnumTypeList,
    private val locRepo: LocRepository,
    private val conRepo: ControllerRepository,
    private val playerRepo: PlayerRepository,
    private val xpMods: XpModifiers,
    private val invisibleLvls: InvisibleLevels,
    private val mapClock: MapClock,
) : PluginScript() {
    override fun ScriptContext.startup() {
        onOpLoc1(content.mining_rock) { attempt(it.loc, it.type) }
        onOpLoc3(content.mining_rock) { mine(it.loc, it.type) }
        onOpLocU(content.mining_rock, content.mining_pickaxe) { mine(it.loc, it.type) }
        onAiConTimer(controllers.mining_rock_duration) { controller.rockDespawnTick() }
        onOpLoc1(content.mining_rock_empty) { noOre(it.loc, it.type) }
        onOpLoc3(content.mining_rock_empty) { noOre(it.loc, it.type) }
        onOpLocU(content.mining_rock_empty, content.mining_pickaxe) { noOre(it.loc, it.type) }
    }

    private fun ProtectedAccess.attempt(rock: BoundLocInfo, type: UnpackedLocType) {
        if (player.miningLvl < type.rockLevelReq) {
            mes("You need a Mining level of ${type.rockLevelReq} to mine this ore.")
        }

        if (inv.isFull()) {
            val product = objTypes[type.rockOre]
            mes("Your inventory is too full to hold any more ${product.name.lowercase()}.")
            soundSynth(synths.pillory_wrong)
            return
        }

        if (actionDelay < mapClock) {
            actionDelay = mapClock + 3
            skillAnimDelay = mapClock + 3
            opLoc1(rock)
        } else {
            mes("-----ATTEMPT-----")
            val pickaxe = findPickaxe(player, objTypes)
            if (pickaxe == null) {
                mes("You need a pickaxe to mine this rock.")
                mes("You do not have a pickaxe which you have the mining level to use.")
                return
            }
            anim(objTypes[pickaxe].pickaxeMiningAnim)
            spam("You swing your axe at the rock.")
            mine(rock, type)
        }
    }
    private fun ProtectedAccess.mine(rock: BoundLocInfo, type: UnpackedLocType) {
            mes("------ENTERED MINE FUNCTION-------")
            val pickaxe = findPickaxe(player, objTypes)
            if (pickaxe == null) {
                mes("You need a pickaxe to mine this rock.")
                mes("You do not have a pickaxe which you have the mining level to use.")
                return
            }

            if (player.miningLvl < type.rockLevelReq) {
                mes("You need a Mining level of ${type.rockLevelReq} to chop down this rock.")
                return
            }

            if (inv.isFull()) {
                val product = objTypes[type.rockOre]
                mes("Your inventory is too full to hold any more ${product.name.lowercase()}.")
                soundSynth(synths.pillory_wrong)
                return
            }

            if (skillAnimDelay <= mapClock) {
                skillAnimDelay = mapClock + 4
                anim(objTypes[pickaxe].pickaxeMiningAnim)
            }

            var mineRocks = false
            val despawn: Boolean

            if (actionDelay < mapClock) {
                actionDelay = mapClock + 3
            } else if (actionDelay == mapClock) {
                val (low, high) = mineSuccessRates(type, pickaxe, enumTypes)
                mineRocks = statRandom(stats.mining, low, high, invisibleLvls)
            }

            if (type.hasDespawnTimer) {
                rockSwingDespawnTick(rock, type)
                despawn = mineRocks && isRockDespawnRequired(rock)
            } else {
                despawn = mineRocks && random.of(1, 255) > type.rockDepleteChance
            }

            if (mineRocks) {
                val product = objTypes[type.rockOre]
                val xp = type.rockXp * xpMods.get(player, stats.mining)
                spam("You get some ${product.name.lowercase()}.")
                statAdvance(stats.mining, xp)
                invAdd(inv, product)
                publish(MineRocks(player, rock, product))
            }

            if (despawn) {
                val respawnTime = type.resolveRespawnTime(random)
                locRepo.change(rock, type.rockEmpty, respawnTime)
                resetAnim()
                soundSynth(synths.mine_ore)
                sendLocalOverlayLoc(rock, type, respawnTime)
            }

            opLoc3(rock)
        }

    private fun Controller.rockDespawnTick() {
        val type = locTypes.getValue(rockLocId)
        val rock = locRepo.findExact(coords, type)
        if (rock == null) {
            // Make sure the controller has lived beyond a single tick. Otherwise, we can make an
            // educated guess that there's an oversight allowing the rock to recreate controllers
            // faster than we'd expect. (1 tick intervals in this case)
            check(mapClock > creationCycle + 1) { "Rock loc deleted faster than expected." }
            conRepo.del(this)
            return
        }

        // If rock is actively being mine down by a player, increment the associated varcon.
        if (rockLastMine == mapClock.cycle - 1) {
            rockActivelyMineTicks++
        } else {
            rockActivelyMineTicks--
        }

        // If the rock has been idle (not mine) for a duration equal to or longer than the time it
        // was actively mine, the controller is no longer needed and can be safely deleted.
        if (rockActivelyMineTicks <= 0) {
            conRepo.del(this)
            return
        }

        // Reset the timer for next tick.
        aiTimer(1)

        // Keep the controller alive.
        resetDuration()
    }

    private fun rockSwingDespawnTick(rock: BoundLocInfo, type: UnpackedLocType) {
        val controller = conRepo.findExact(rock.coords, controllers.mining_rock_duration)
        if (controller != null) {
            check(controller.rockLocId == rock.id) {
                "Controller in coords is not associated with rock: " +
                    "controller=$controller, rockLoc=$rock, rockType=$type"
            }
            controller.rockLastMine = mapClock.cycle
            return
        }

        val spawn = Controller(rock.coords, controllers.mining_rock_duration)
        conRepo.add(spawn, type.rockDespawnTime)

        spawn.rockLocId = rock.id
        spawn.rockLastMine = mapClock.cycle
        spawn.rockActivelyMineTicks = 0
        spawn.aiTimer(1)
    }

    private fun isRockDespawnRequired(rock: BoundLocInfo): Boolean {
        val controller = conRepo.findExact(rock.coords, controllers.mining_rock_duration)
        return controller != null && controller.rockActivelyMineTicks >= controller.durationStart
    }

    private fun sendLocalOverlayLoc(rock: BoundLocInfo, type: UnpackedLocType, respawnTime: Int) {
        val players = playerRepo.findAll(ZoneKey.from(rock.coords), zoneRadius = 3)
        for (player in players) {
            ClientScripts.addOverlayTimerLoc(
                player = player,
                coords = rock.coords,
                loc = type,
                shape = rock.shape,
                timer = Constants.overlay_timer_mining,
                ticks = respawnTime,
                colour = 16765184,
            )
        }
    }

    private fun ProtectedAccess.noOre(rock: BoundLocInfo, type: UnpackedLocType) {
        mes("There is currently no ore available in this rock.")
    }

    data class MineRocks(val player: Player, val rock: BoundLocInfo, val product: ObjType) :
        UnboundEvent

    companion object {
        var Controller.rockActivelyMineTicks: Int by intVarCon(varcons.mining_rock_mine_ticks)
        var Controller.rockLastMine: Int by intVarCon(varcons.mining_rock_last_mine)
        var Controller.rockLocId: Int by intVarCon(varcons.mining_rock_loc)

        val UnpackedObjType.pickaxeMiningReq: Int by objParam(params.levelrequire)
        val UnpackedObjType.pickaxeMiningAnim: SeqType by objParam(params.skill_anim)

        val UnpackedLocType.rockLevelReq: Int by locParam(params.levelrequire)
        val UnpackedLocType.rockOre: ObjType by locParam(params.skill_productitem)
        val UnpackedLocType.rockXp: Double by locXpParam(params.skill_xp)
        val UnpackedLocType.rockEmpty: LocType by locParam(params.next_loc_stage)
        val UnpackedLocType.rockDespawnTime: Int by locParam(params.despawn_time)
        val UnpackedLocType.rockDepleteChance: Int by locParam(params.deplete_chance)
        val UnpackedLocType.rockRespawnTime: Int by locParam(params.respawn_time)
        val UnpackedLocType.rockRespawnTimeLow: Int by locParam(params.respawn_time_low)
        val UnpackedLocType.rockRespawnTimeHigh: Int by locParam(params.respawn_time_high)

        private val UnpackedLocType.hasDespawnTimer: Boolean
            get() = hasParam(params.despawn_time)

        fun findPickaxe(player: Player, objTypes: ObjTypeList): InvObj? {
            val worn = player.wornPickaxe(objTypes)
            val carried = player.carriedPickaxe(objTypes)
            if (worn != null && carried != null) {
                if (objTypes[worn].pickaxeMiningReq >= objTypes[carried].pickaxeMiningReq) {
                    return worn
                }
                return carried
            }
            return worn ?: carried
        }

        private fun Player.wornPickaxe(objTypes: ObjTypeList): InvObj? {
            val righthand = righthand ?: return null
            return righthand.takeIf { objTypes[it].isUsablePickaxe(miningLvl) }
        }

        private fun Player.carriedPickaxe(objTypes: ObjTypeList): InvObj? {
            return inv.filterNotNull { objTypes[it].isUsablePickaxe(miningLvl) }
                .maxByOrNull { objTypes[it].pickaxeMiningReq }
        }

        private fun UnpackedObjType.isUsablePickaxe(miningLevel: Int): Boolean =
            isContentType(content.mining_pickaxe) && miningLevel >= pickaxeMiningReq

        private fun UnpackedLocType.resolveRespawnTime(random: GameRandom): Int {
            val fixed = rockRespawnTime
            if (fixed > 0) {
                return fixed
            }
            return random.of(rockRespawnTimeLow, rockRespawnTimeHigh)
        }

        fun mineSuccessRates(
            rockType: UnpackedLocType,
            pickaxe: InvObj,
            enumTypes: EnumTypeList,
        ): Pair<Int, Int> {
            val pickaxes = rockType.param(MiningParams.success_rates)
            val rates = enumTypes[pickaxes].find(pickaxe)
            val low = rates shr 16
            val high = rates and 0xFFFF
            return low to high
        }
    }
}


