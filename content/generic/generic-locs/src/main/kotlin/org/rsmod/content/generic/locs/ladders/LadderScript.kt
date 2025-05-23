package org.rsmod.content.generic.locs.ladders

import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.params
import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.api.script.onOpLoc1
import org.rsmod.api.script.onOpLoc2
import org.rsmod.api.script.onOpLoc3
import org.rsmod.game.type.loc.UnpackedLocType
import org.rsmod.game.type.seq.SeqType
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class LadderScript : PluginScript() {
    override fun ScriptContext.startup() {
        onOpLoc1(content.ladder_down) {
            arriveDelay()
            climbDown(it.type)
        }
        onOpLoc1(content.ladder_up) {
            arriveDelay()
            climbUp(it.type)
        }
        onOpLoc1(content.ladder_option) {
            arriveDelay()
            climbOption(it.type)
        }
        onOpLoc2(content.ladder_option) {
            arriveDelay()
            climbUp(it.type)
        }
        onOpLoc3(content.ladder_option) {
            arriveDelay()
            climbDown(it.type)
        }
    }

    private suspend fun ProtectedAccess.climbUp(type: UnpackedLocType): Unit = climb(type, 1)

    private suspend fun ProtectedAccess.climbDown(type: UnpackedLocType): Unit = climb(type, -1)

    private suspend fun ProtectedAccess.climb(type: UnpackedLocType, translateLevel: Int) {
        val dest = player.coords.translateLevel(translateLevel)
        anim(type.climbAnim())
        delay(1)
        telejump(dest)
    }

    private suspend fun ProtectedAccess.climbOption(type: UnpackedLocType) = startDialogue {
        val translate =
            choice2("Climb-up", 1, "Climb-down", -1, title = "Climb up or down the ladder?")
        val dest = player.coords.translateLevel(translate)
        anim(type.climbAnim())
        delay(2)
        telejump(dest)
    }

    private fun UnpackedLocType.climbAnim(): SeqType = param(params.climb_anim)
}
