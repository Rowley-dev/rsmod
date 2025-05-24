package org.rsmod.content.generic.locs.depositbox

import com.sun.jdi.LongValue
import org.rsmod.api.config.refs.content
import org.rsmod.api.type.editors.loc.LocEditor
import org.rsmod.api.type.refs.loc.LocReferences
import org.rsmod.game.type.loc.LocType

internal typealias deposit_locs = BankDepositLocs

internal object BankDepositLocs : LocReferences() {
    val bank_deposit_box = find("bank_deposit_box")
    val bank_deposit_chest = find("bank_deposit_chest")
}

internal object BankDepositLocEditor : LocEditor() {
    init {
        deposit(deposit_locs.bank_deposit_chest)
        deposit(deposit_locs.bank_deposit_box)

    }

    private fun deposit(type: LocType) {
        edit(type) { contentGroup = content.bank_deposit_box }
    }
}
