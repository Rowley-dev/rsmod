package org.rsmod.content.generic.locs.depositbox

import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext
import org.rsmod.api.config.refs.interfaces
import org.rsmod.api.config.refs.content
import org.rsmod.api.script.onOpLoc1
import org.rsmod.api.script.onOpLoc2
import org.rsmod.api.script.onOpLoc3

class DepositBox : PluginScript() {
    override fun ScriptContext.startup() {
        onOpLoc3(content.deposit_box) {openDeposit()}
        onOpLoc2(content.deposit_box) {openDeposit()}
        onOpLoc1(content.deposit_box) {openDeposit()}
    }

    private fun ProtectedAccess.openDeposit() {
        ifOpenOverlay(interfaces.bank_depositbox)
    }
}
