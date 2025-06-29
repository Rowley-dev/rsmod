package org.rsmod.content.items.jewellery.amulet_of_glory.configs

import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.params
import org.rsmod.api.type.editors.obj.ObjEditor
import org.rsmod.api.type.refs.obj.ObjReferences
import org.rsmod.api.type.refs.seq.SeqReferences
import org.rsmod.api.type.refs.spot.SpotanimReferences
import org.rsmod.api.type.refs.synth.SynthReferences
import org.rsmod.game.type.obj.ObjType
import org.rsmod.game.type.obj.isType

internal typealias amulets_of_glory = AmuletOfGloryObjs
internal typealias amulet_of_glory_spotanims = AmuletOfGlorySpotanims
internal typealias amulet_of_glory_seqs = AmuletOfGlorySeq
internal typealias amulet_of_glory_synths = AmuletOfGlorySynths

object AmuletOfGlorySynths : SynthReferences() {
    val amulet_of_glory_synth = find("teleport_all")
}
object AmuletOfGlorySeq: SeqReferences() {
    val amulet_of_glory_teleport = find("human_castteleport")
}

object AmuletOfGlorySpotanims : SpotanimReferences() {
    val amulet_of_glory_spotanim = find("teleport_casting")
}

object AmuletOfGloryObjs : ObjReferences() {
    val amulet_of_glory_eternal = find("amulet_of_glory_inf")
    val amulet_of_glory_6 = find("amulet_of_glory_6")
    val amulet_of_glory_5 = find("amulet_of_glory_5")
    val amulet_of_glory_4 = find("amulet_of_glory_4")
    val amulet_of_glory_3 = find("amulet_of_glory_3")
    val amulet_of_glory_2 = find("amulet_of_glory_2")
    val amulet_of_glory_1 = find("amulet_of_glory_1")
    val trail_amulet_of_glory_6 = find("trail_amulet_of_glory_6")
    val trail_amulet_of_glory_5 = find("trail_amulet_of_glory_5")
    val trail_amulet_of_glory_4 = find("trail_amulet_of_glory_4")
    val trail_amulet_of_glory_3 = find("trail_amulet_of_glory_3")
    val trail_amulet_of_glory_2 = find("trail_amulet_of_glory_2")
    val trail_amulet_of_glory_1 = find("trail_amulet_of_glory_1")
    val amulet_of_glory_uncharged = find("amulet_of_glory")
    val trail_amulet_of_glory_uncharged = find("trail_amulet_of_glory")
}


internal object AmuletOfGloryObjEdits : ObjEditor() {
    init {
        glory(amulets_of_glory.amulet_of_glory_6)
        glory(amulets_of_glory.amulet_of_glory_5)
        glory(amulets_of_glory.amulet_of_glory_4)
        glory(amulets_of_glory.amulet_of_glory_3)
        glory(amulets_of_glory.amulet_of_glory_2)
        glory(amulets_of_glory.amulet_of_glory_1)
        glory(amulets_of_glory.amulet_of_glory_eternal)

        unchargedGlory(amulets_of_glory.amulet_of_glory_uncharged)
        unchargedGlory(amulets_of_glory.trail_amulet_of_glory_uncharged)

        trimmedGlory(amulets_of_glory.trail_amulet_of_glory_6)
        trimmedGlory(amulets_of_glory.trail_amulet_of_glory_5)
        trimmedGlory(amulets_of_glory.trail_amulet_of_glory_4)
        trimmedGlory(amulets_of_glory.trail_amulet_of_glory_3)
        trimmedGlory(amulets_of_glory.trail_amulet_of_glory_2)
        trimmedGlory(amulets_of_glory.trail_amulet_of_glory_1)
    }

    private fun glory(type: ObjType) {
        edit(type) {
            contentGroup = content.amulet_of_glory
            if (type.isType(amulets_of_glory.amulet_of_glory_6)) {
                param[params.replacement_item_id] = amulets_of_glory.amulet_of_glory_5.id
            } else if (type.isType(amulets_of_glory.amulet_of_glory_5)) {
                param[params.replacement_item_id] = amulets_of_glory.amulet_of_glory_4.id
            } else {
                param[params.replacement_item_id] = type.id - 2
            }
        }
    }

    private fun trimmedGlory(type: ObjType) {
        edit(type) {
            contentGroup = content.amulet_of_glory
            if (type.isType(amulets_of_glory.trail_amulet_of_glory_6)) {
                param[params.replacement_item_id] = amulets_of_glory.trail_amulet_of_glory_5.id
            } else if (type.isType(amulets_of_glory.trail_amulet_of_glory_5)) {
                param[params.replacement_item_id] = amulets_of_glory.trail_amulet_of_glory_4.id
            } else {
                param[params.replacement_item_id] = type.id + 2
            }
        }
    }

    private fun unchargedGlory(type: ObjType) {
        edit(type) {
            contentGroup = content.amulet_of_glory_uncharged
        }
    }
}
