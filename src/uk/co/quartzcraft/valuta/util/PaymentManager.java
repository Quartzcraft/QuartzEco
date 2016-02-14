package uk.co.quartzcraft.valuta.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import uk.co.quartzcraft.core.features.ActionBar;
import uk.co.quartzcraft.core.systems.fancymessage.FancyMessage;

public class PaymentManager {
	
	public Boolean payPlayer(VPlayer sender, VPlayer reciever, Double payment) {
		CurrencyManager cm = new CurrencyManager();
		if(sender.canAfford(payment)) {
			sender.subtractFromBalance(payment);
			reciever.addToBalance(payment);
			FancyMessage aMsg = new FancyMessage("Player ")
			            .color(ChatColor.DARK_RED)
			            .then(sender.getPlayer().getName())
			            .color(ChatColor.RED)
			            .style(ChatColor.ITALIC)
			            .then(" paid you ").color(ChatColor.DARK_RED)
			            .then(cm.makeBalancePretty(payment, true)).color(ChatColor.AQUA);
			ActionBar.displayBar(reciever.getPlayer(), aMsg.toJSONString());
			
			aMsg = new FancyMessage("You paid ")
						.color(ChatColor.DARK_RED)
						.then(reciever.getPlayer().getName())
						.color(ChatColor.RED)
						.style(ChatColor.ITALIC)
						.then(cm.makeBalancePretty(payment, true)).color(ChatColor.AQUA);
			ActionBar.displayBar(sender.getPlayer(), aMsg.toJSONString());
			
			sender.didTransaction();
			sender.logDataToFile("[Sent] -> [Pay] Paid " + payment + " to " + reciever.getPlayer().getName());
			
			reciever.didTransaction();
			reciever.logDataToFile("[Recieved] -> [Pay] Recieved " + payment + " from " + sender.getPlayer().getName());
			return true;
		} else {
			FancyMessage aMsg = new FancyMessage("You can't afford that! Your balance: ")
			            .color(ChatColor.DARK_RED)
			            .then(cm.makeBalancePretty(sender.getBalance(), true)).color(ChatColor.RED);
			ActionBar.displayBar(sender.getPlayer(), aMsg.toJSONString());
			return false;
		}
	}
	
	public Boolean purchaseItem(VPlayer sender, VPlayer reciever, Double payment, ItemStack... item) {
		if(payPlayer(sender, reciever, payment)) {
			sender.getPlayer().getInventory().addItem(item);
			return true;
		}
		return false;
	}
	
}
