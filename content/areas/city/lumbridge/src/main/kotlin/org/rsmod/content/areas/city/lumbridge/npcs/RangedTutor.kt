package org.rsmod.content.areas.city.lumbridge.npcs

import org.rsmod.api.config.refs.objs
import org.rsmod.api.invtx.invAdd
import org.rsmod.api.player.dialogue.Dialogue
import org.rsmod.api.player.output.mes
import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.api.player.stat.rangedLvl
import org.rsmod.api.script.onOpNpc1
import org.rsmod.api.script.onOpNpc2
import org.rsmod.content.areas.city.lumbridge.configs.lumbridge_npcs
import org.rsmod.game.entity.Npc
import org.rsmod.game.entity.Player
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class RangedTutor : PluginScript() {
    override fun ScriptContext.startup() {
        onOpNpc1(lumbridge_npcs.ranged_tutor) { startDialogue(it.npc) }
        onOpNpc2(lumbridge_npcs.ranged_tutor) { claim(player) }
    }

    private suspend fun ProtectedAccess.startDialogue(npc: Npc): Unit =
        startDialogue(npc) {
            chatNpc(
                happy,
                "Hey there adventurer, I am the Ranged combat tutor. Is there anything you would like to know?",
            )
            mainMenu()
        }

    private suspend fun Dialogue.mainMenu() {
        val choice =
            choice4(
                "How can I train my Ranged?",
                1,
                "How do I create a bow and arrows?",
                2,
                "Let's discuss how my ammo acts when I pick it up.",
                3,
                "Goodbye.",
                4,
            )
        when (choice) {
            1 -> rangedTraining()
            2 -> createBowArrow()
            3 -> discussAmmo()
            4 -> goodbye()
        }
    }

    private suspend fun Dialogue.rangedTraining() {

        chatPlayer(quiz, "How can I train my Ranged?")
        // What is the correct trigger? Change this later.
        if (player.rangedLvl > 35) {
            chatNpc(
                happy,
                "You should know the basics of ranged combat by now, " +
                    "but if you are looking for somewhere to test your skills " +
                    "and make some money, you should try hunting Moss " +
                    "giants in the Varrock sewers.",
            )
            chatNpc(
                happy,
                "If you are lucky you might find a Mossy key, with this " +
                    "key you will be able to enter Bryophyta's lair. Make " +
                    "sure to bring plenty of food, good armour and weapons " +
                    "when you fight her as you will need it.",
            )
            chatNpc(
                shifty,
                "If you are lucky you might snag some goodies that you " +
                    "can sell for a decent profit. ",
            )
        } else {
            chatNpc(
                happy,
                "To start with, you'll need a bow and arrows. You " +
                    "were given a Shortbow and some arrows when you " +
                    "arrived here from Tutorial Island. ",
            )
            chatNpc(
                happy,
                "Alternatively, you can claim a training bow and some " +
                    "arrows from me. " ,
            )
            chatNpc(
                shifty,
                "Mikasi, the Magic Combat tutor and I both give out items " +
                    "every 30 minutes, however you must choose whether you " +
                    "want runes or ranged equipment.",
            )
            chatNpc(
                happy,
                "To claim the Training bow and arrows, right-click on me " +
                    "and choose Claim, to claim runes right-click on the " +
                    "Magic Combat tutor and select Claim.",
            )

        }
        chatNpc(
            happy,
            "If you are ever in the market for a new bow or some " +
                "arrows, you should head on over to Lowe's Archery " +
                "Emporium in Varrock. I can show you where the shop " +
                "is if you like.",
        )
        val choice = choice2("Yes please.", 1, "No thanks.", 2)
        when (choice) {
            1 -> return
            2 -> noThanks()
        }
    }

    private suspend fun Dialogue.createBowArrow() {
        chatPlayer(quiz, "How do I create a bow and arrows?")
        chatNpc(
            happy,
            "Ahh the art of Fletching. Fletching is used to create " + "your own bow and arrows.",
        )
        chatNpc(
            happy,
            "To create your bow and arrows you would need to " +
                "gather some wood, feathers, arrow heads and bow " +
                "string. The wood would be to make arrow shafts which " +
                "can be turned into unstrung bows and arrow shafts.",
        )
        chatNpc(
            happy,
            "You would then use the feathers and arrow heads on " +
                "the arrow shafts to make arrows. The bow string would " +
                "be used on the unstrung bow to make a bow. ",
        )
        chatNpc(happy, "Is there anything else you would like to know?")
        val choice =
            choice3(
                "How can I train my Ranged?",
                1,
                "Let's discuss how my ammo acts when I pick it up.",
                2,
                "Goodbye.",
                3,
            )
        if (choice == 1) {
            rangedTraining()
        } else if (choice == 2) {
            discussAmmo()
        } else if (choice == 3) {
            goodbye()
        }
    }

    private suspend fun Dialogue.discussAmmo() {
        chatPlayer(neutral, "Let's discuss how my ammo acts when I pick it up.")
        chatNpc(
            happy,
            "When you pick up ammo from the ground, if it matches " +
                "what you've got equipped in your quiver, or what's in " +
                "your bolt pouch, I can make the ammo you've picked " +
                "up go straight into there, provided there's space.",
        )
        chatNpc(happy, "Alternatively, you can let it go into your inventory like " + "normal.")
    }

    private suspend fun Dialogue.noThanks() {
        chatPlayer(neutral, "No, thank you.")
        chatNpc(happy, "Is there anything else you would like to know?")
        val choice =
            choice3(
                "How do I create a bow and arrows?",
                1,
                "Let's discuss how my ammo acts when I pick it up.",
                2,
                "Goodbye.",
                3,
            )
        if (choice == 1) {
            createBowArrow()
        } else if (choice == 2) {
            discussAmmo()
        } else if (choice == 3) {
            goodbye()
        }
    }

    private suspend fun Dialogue.goodbye() {
        chatPlayer(neutral, "Goodbye.")
    }

    private fun ProtectedAccess.claim(player: Player) {
        if (player.inv.isFull() || player.inv.size > 25) {
            player.mes("You must have two available inventory slots to claim from this tutor.")
        } else {
            player.invAdd(player.inv, objs.training_bow, 1)
            player.invAdd(player.inv, objs.training_arrow, 30)
        }
    }
}
