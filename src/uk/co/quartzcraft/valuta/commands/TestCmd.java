package uk.co.quartzcraft.valuta.commands;

import uk.co.quartzcraft.core.command.framework.CommandArgs;
import uk.co.quartzcraft.core.command.framework.QCommand;
import uk.co.quartzcraft.valuta.util.PaymentManager;
import uk.co.quartzcraft.valuta.util.VPlayer;

public class TestCmd {

	@QCommand(name = "testcmd", aliases = { "testcmd" }, permission = "QCC.test", description = "This is a test command", usage = "This is how you use it", requirePlayer = false)
    public void testcmd(CommandArgs args) {
		PaymentManager pm = new PaymentManager();
		pm.payPlayer(new VPlayer(args.getPlayer()), new VPlayer(args.getPlayer()), 100.00);
    }
}