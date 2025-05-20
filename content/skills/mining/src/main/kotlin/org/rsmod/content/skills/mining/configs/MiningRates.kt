package org.rsmod.content.skills.mining.configs

import org.rsmod.api.config.refs.objs
import org.rsmod.api.type.builders.enums.EnumBuilder
import org.rsmod.api.type.builders.param.ParamBuilder
import org.rsmod.api.type.refs.enums.EnumReferences
import org.rsmod.api.type.refs.param.ParamReferences
import org.rsmod.game.type.enums.EnumType
import org.rsmod.game.type.obj.ObjType

object MiningParams : ParamReferences() {
    val success_rates = find<EnumType<ObjType, Int>>("mining_pickaxe_success_rates")
}

internal object MiningParamBuilder : ParamBuilder() {
    init {
        build<EnumType<ObjType, Int>>("mining_pickaxe_success_rates")
    }
}

internal object MiningEnums : EnumReferences() {
    val copper_rock_pickaxes = find<ObjType, Int>("copper_rock_pickaxes")
    val tin_rock_pickaxes = find<ObjType, Int>("tin_rock_pickaxes")
    val iron_rock_pickaxes = find<ObjType, Int>("iron_rock_pickaxes")
    val coal_rock_pickaxes = find<ObjType, Int>("coal_rock_pickaxes")
    val silver_rock_pickaxes = find<ObjType, Int>("silver_rock_pickaxes")
    val mithril_rock_pickaxes = find<ObjType, Int>("mithril_rock_pickaxes")
    val adamant_rock_pickaxes = find<ObjType, Int>("adamant_rock_pickaxes")
    val rune_rock_pickaxes = find<ObjType, Int>("rune_rock_pickaxes")
}

internal object MiningEnumBuilder : EnumBuilder() {
    init {
        build<ObjType, Int>("copper_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("tin_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("iron_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("coal_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("silver_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("mithril_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("adamant_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }

        build<ObjType, Int>("rune_rock_pickaxes") {
            this[objs.bronze_pickaxe] = rate(64, 200)
            this[objs.iron_pickaxe] = rate(96, 300)
            this[objs.steel_pickaxe] = rate(128, 400)
            this[objs.black_pickaxe] = rate(144, 450)
            this[objs.mithril_pickaxe] = rate(160, 500)
            this[objs.adamant_pickaxe] = rate(192, 600)
            this[objs.rune_pickaxe] = rate(224, 700)
            this[objs.dragon_pickaxe] = rate(240, 750)
            this[objs.dragon_pickaxe_upgraded] = rate(240, 750)
            this[objs.third_age_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe] = rate(240, 750)
            this[objs.infernal_pickaxe_or] = rate(240, 750)
            this[objs.crystal_pickaxe] = rate(250, 800)
        }
    }

    private fun rate(low: Int, high: Int): Int = (low shl 16) or high
}
