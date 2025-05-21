package org.rsmod.content.skills.mining.configs

import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.objs
import org.rsmod.api.config.refs.params
import org.rsmod.api.type.editors.loc.LocEditor
import org.rsmod.api.type.refs.loc.LocReferences
import org.rsmod.content.skills.mining.configs.MiningParams.success_rates
import org.rsmod.content.skills.mining.configs.MiningRocks.EmptyRockLocs
import org.rsmod.content.skills.mining.configs.MiningRocks.RockLocs
import org.rsmod.game.stat.PlayerStatMap
import org.rsmod.game.type.loc.LocType
import org.rsmod.game.type.obj.ObjType

internal typealias rocks = RockLocs

private typealias empty_rocks = EmptyRockLocs

private typealias pickaxe_enums = MiningEnums

internal object MiningRocks : LocEditor() {
    init {
        copper_1(rocks.copper_rock_1, empty_rocks.rock_empty_1)
        tin_1(rocks.tin_rock_1, empty_rocks.rock_empty_1)
        iron_1(rocks.iron_rock_1, empty_rocks.rock_empty_1)
        coal_1(rocks.coal_rock_1, empty_rocks.rock_empty_1)
        silver_1(rocks.silver_rock_1, empty_rocks.rock_empty_1)
        gold_1(rocks.gold_rock_1, empty_rocks.rock_empty_1)
        mithril_1(rocks.mithril_rock_1, empty_rocks.rock_empty_1)
        adamant_1(rocks.adamant_rock_1, empty_rocks.rock_empty_1)
        rune_1(rocks.rune_rock_1, empty_rocks.rock_empty_1)
        rock_empty_1(empty_rocks.rock_empty_1)
        copper_2(rocks.copper_rock_2, empty_rocks.rock_empty_2)
        tin_2(rocks.tin_rock_2, empty_rocks.rock_empty_2)
        iron_2(rocks.iron_rock_2, empty_rocks.rock_empty_2)
        coal_2(rocks.coal_rock_2, empty_rocks.rock_empty_2)
        silver_2(rocks.silver_rock_2, empty_rocks.rock_empty_2)
        gold_2(rocks.gold_rock_2, empty_rocks.rock_empty_2)
        mithril_2(rocks.mithril_rock_2, empty_rocks.rock_empty_2)
        adamant_2(rocks.adamant_rock_2, empty_rocks.rock_empty_2)
        rune_2(rocks.rune_rock_2, empty_rocks.rock_empty_2)
        rock_empty_2(empty_rocks.rock_empty_2)
    }

    private fun copper_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.copper_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.copper_rock_pickaxes
        }
    }

    private fun copper_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.copper_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.copper_rock_pickaxes
        }
    }

    private fun tin_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.tin_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.tin_rock_pickaxes
        }
    }

    private fun tin_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.tin_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.tin_rock_pickaxes
        }
    }

    private fun iron_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.iron_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.iron_rock_pickaxes
        }
    }

    private fun iron_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.iron_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.iron_rock_pickaxes
        }
    }

    private fun coal_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.coal_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.coal_rock_pickaxes
        }
    }

    private fun coal_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.coal_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.coal_rock_pickaxes
        }
    }

    private fun silver_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.silver_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.silver_rock_pickaxes
        }
    }

    private fun silver_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.silver_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.silver_rock_pickaxes
        }
    }

    private fun gold_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.gold_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.gold_rock_pickaxes
        }
    }

    private fun gold_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.gold_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.gold_rock_pickaxes
        }
    }

    private fun mithril_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.mithril_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.mithril_rock_pickaxes
        }
    }

    private fun mithril_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.mithril_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.mithril_rock_pickaxes
        }
    }

    private fun adamant_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.adamant_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.adamant_rock_pickaxes
        }
    }

    private fun adamant_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.adamant_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.adamant_rock_pickaxes
        }
    }

    private fun rune_1(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.rune_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.rune_rock_pickaxes
        }
    }

    private fun rune_2(type: LocType, emptyRock: LocType) {
        edit(type) {
            contentGroup = content.mining_rock
            param[params.deplete_chance] = 0
            param[params.respawn_time] = 0
            param[params.respawn_time_low] = 60
            param[params.respawn_time_high] = 100
            param[params.levelrequire] = 1
            param[params.skill_xp] = PlayerStatMap.toFineXP(25.0).toInt()
            param[params.skill_productitem] = objs.rune_ore
            param[params.next_loc_stage] = emptyRock
            param[success_rates] = pickaxe_enums.rune_rock_pickaxes
        }
    }

    private fun rock_empty_1(type: LocType) {
        edit(type){
            contentGroup = content.mining_rock_empty
        }
    }

    private fun rock_empty_2(type: LocType) {
        edit(type){
            contentGroup = content.mining_rock_empty
        }
    }

    internal object RockLocs : LocReferences() {
        val copper_rock_1 = find("copperrock1")
        val tin_rock_1 = find("tinrock1")
        val iron_rock_1 = find("ironrock1")
        val coal_rock_1 = find("coalrock1")
        val silver_rock_1 = find("silverrock1")
        val gold_rock_1 = find("goldrock1")
        val mithril_rock_1 = find("mithrilrock1")
        val adamant_rock_1 = find("adamantiterock1")
        val rune_rock_1 = find("runiterock1")
        val copper_rock_2 = find("copperrock2")
        val tin_rock_2 = find("tinrock2")
        val iron_rock_2 = find("ironrock2")
        val coal_rock_2 = find("coalrock2")
        val silver_rock_2 = find("silverrock2")
        val gold_rock_2 = find("goldrock2")
        val mithril_rock_2 = find("mithrilrock2")
        val adamant_rock_2 = find("adamantiterock2")
        val rune_rock_2 = find("runiterock2")

    }

    internal object EmptyRockLocs : LocReferences() {
        val rock_empty_1 = find("rocks1")
        val rock_empty_2 = find("rocks2")
        val rock_empty_3 = find("rocks3")
    }
}
