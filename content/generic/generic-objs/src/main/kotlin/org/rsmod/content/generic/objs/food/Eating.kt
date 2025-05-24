package org.rsmod.content.generic.objs.food

import org.rsmod.api.config.refs.BaseStats.hitpoints
import org.rsmod.api.script.onOpObj1
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext
import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.seqs
import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.api.player.stat.baseHitpointsLvl
import org.rsmod.api.player.stat.hitpoints
import org.rsmod.api.player.stat.statHeal
import org.rsmod.api.player.stat.statRestore
import org.rsmod.api.script.onOpHeld1
import org.rsmod.game.entity.Player
import org.rsmod.game.type.stat.StatType

class Eating : PluginScript() {
    override fun ScriptContext.startup() {
        onOpHeld1(content.food) { eatFood() }
    }

    private fun ProtectedAccess.eatFood(
        player: Player,
        food: Food,
    ) {
        val delay = if (food.comboFood) COMBO_FOOD_DELAY else FOOD_DELAY
        val anim = seqs.human_eat
        val heal = food.heal
        val overheal = food.overheal

        val oldHp = player.hitpoints
        val stat = hitpoints
        player.statHeal(stat, food.heal, 0)
            }
    }
}
