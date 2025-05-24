package org.rsmod.content.generic.npcs.town_crier

import org.rsmod.api.config.refs.content
import org.rsmod.api.type.editors.npc.NpcEditor
import org.rsmod.api.type.refs.npc.NpcReferences
import org.rsmod.game.type.npc.NpcType

internal typealias town_crier_npcs = TownCrierNpcs

object TownCrierNpcs : NpcReferences() {
    val town_crier_varrock = find("pmod_town_crier_varrock")
    val town_crier_draynor = find("pmod_town_crier_draynor")
    val town_crier_falador = find("pmod_town_crier_falador")
    val town_crier_east_ardy = find("pmod_town_crier_east_ardoyne")
    val town_crier_seers = find("pmod_town_crier_seers")
    val town_crier_zeah = find("pmod_town_crier_zeah")
    val town_crier_kingstown = find("pmod_town_crier_kingstown")
    val town_crier_kingstown_vis = find("pmod_town_crier_kingstown_vis")
}

internal object TownCrierEdits: NpcEditor() {
    init {
        crier(town_crier_npcs.town_crier_varrock)
        crier(town_crier_npcs.town_crier_draynor)
        crier(town_crier_npcs.town_crier_falador)
        crier(town_crier_npcs.town_crier_east_ardy)
        crier(town_crier_npcs.town_crier_seers)
        crier(town_crier_npcs.town_crier_zeah)
        crier(town_crier_npcs.town_crier_kingstown)
        crier(town_crier_npcs.town_crier_kingstown_vis)
    }

    private fun crier(type: NpcType) {
        edit(type) {
            contentGroup = content.town_crier
            timer = 1
        }
    }



}
