package org.rsmod.content.generic.objs.food

import org.rsmod.api.config.objParam
import org.rsmod.api.type.refs.obj.ObjReferences
import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.objs
import org.rsmod.api.config.refs.params
import org.rsmod.api.config.refs.spotanims
import org.rsmod.api.type.editors.obj.ObjEditor
import org.rsmod.game.type.obj.ObjType

enum class Food(
    val food: ObjType,
    val heal: Int = 0,
    val overheal: Boolean = false,
    val replacement: Int = -1,
    val comboFood: Boolean = false,
    val message: String = "",
){
    CABBAGE(objs.cabbage, 1, message = "You eat the cabbage. Yuck!"),

    ;

    companion object {
        val values = enumValues<Food>()
    }
}

