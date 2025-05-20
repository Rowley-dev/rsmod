package org.rsmod.content.skills.mining.configs

import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.objs
import org.rsmod.api.config.refs.params
import org.rsmod.api.config.refs.seqs
import org.rsmod.api.type.editors.obj.ObjEditor

object MiningPickaxes : ObjEditor() {
    init {
        edit(objs.bronze_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_bronze_pickaxe
        }

        edit(objs.iron_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_iron_pickaxe
        }

        edit(objs.steel_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_steel_pickaxe
        }

        edit(objs.black_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_black_pickaxe
        }

        edit(objs.mithril_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_mithril_pickaxe
        }

        edit(objs.adamant_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_adamant_pickaxe
        }


        edit(objs.rune_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_rune_pickaxe
        }

        edit(objs.dragon_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_dragon_pickaxe
        }

        edit(objs.dragon_pickaxe_upgraded) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_dragon_pickaxe_upgraded
        }

        edit(objs.third_age_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_third_age_pickaxe
        }

        edit(objs.infernal_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_infernal_pickaxe
        }

        edit(objs.infernal_pickaxe_or) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_infernal_pickaxe
        }

        edit(objs.crystal_pickaxe) {
            contentGroup = content.mining_pickaxe
            param[params.skill_anim] = seqs.human_mining_crystal_pickaxe
        }
    }
}
