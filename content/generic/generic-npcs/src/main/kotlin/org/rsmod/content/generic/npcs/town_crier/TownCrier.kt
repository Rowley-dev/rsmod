package org.rsmod.content.generic.npcs.town_crier

import jakarta.inject.Inject
import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.seqs
import org.rsmod.api.config.refs.synths
import org.rsmod.api.random.GameRandom
import org.rsmod.api.repo.world.WorldRepository
import org.rsmod.api.script.onAiTimer
import org.rsmod.game.entity.Npc
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class TownCrier @Inject constructor(private val worldRepo: WorldRepository, val random: GameRandom) : PluginScript() {
    override fun ScriptContext.startup() {
        onAiTimer(content.town_crier) { npc.crierTimer() }
    }

    private fun Npc.crierTimer() {
        val next = random.of(10..28)
        aiTimer(next)

        if (random.randomBoolean(4)) {
            sayFlavourText()
        }
    }


    private fun Npc.sayFlavourText() {

        val shoutOption = listOf(
            "Be careful when fighting wizards! Wearing heavy armour can lower your Magic resistance!",
            "Beware of players trying to lure you into the wilderness. Your items cannot be returned if you lose them!",
            "Did you know having a bank pin can help you secure your valuable items?",
            "Did you know most skills have right click 'Make-X' options to help you train faster?",
            "Did you know that at high levels of Runecrafting you get more than one rune per essence?",
            "Did you know that mithril equipment is very light?",
            "Did you know that you can wear a shield with a crossbow?",
            "Did you know you burn food less often than the range in Lumbridge castle than other ranges?",
            "Did you know? Superheat Item means you never fail to smelt ore!",
            "Did you know? You burn food less often on a range than on a fire!",
            "Don't use your RuneScape password on other sites. Keep your account safe!",
            "Feeling harassed? Don't forget your ignore list can be especially useful if a player seems to be picking on you!",
            "If a player isn't sure of the rules, send them to me! I'll be happy to remind them!",
            "If the chat window is moving too quickly to report a player accurately, run to a quiet spot and review the chat " +
                "at your leisure!",
            "If you see someone breaking the rules, report them!",
            "If you think someone knows your password - change it!",
            "If you're lost have no idea where to go, use the Home Teleport spell for free!",
            "Jagex will never email you asking for your log-in details.",
            "Make your recovery questions and answers hard to guess but easy to remember.",
            "Melee armour actually gives you disadvantages when using magic attacks. It may be better to take off your armour" +
                " entirely!",
            "Never let anyone else use your account.",
            "Never question a penguin.",
            "Never tell your password to anyone, not even your best friend!",
            "Players can not trim armour. Don't fall for this popular scam!",
            "The squirrels! The squirrels are coming! Noooo, get them out of my head!",
            "Take time to check the second trade window carefully. Don't be scammed!"
        )
        val shout = shoutOption.random()
        say(shout)
    }
}
