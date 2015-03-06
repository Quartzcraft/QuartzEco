#
# Valuta | © QuartzCraft 2015
# Economy_C.java
# All Rights Reserved.
#

package uk.co.quartzcraft.valuta;
 
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
 
public class Economy_C implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender cs, Command command, String S, String[] args)
	{
		if(args.length != 3)
		{
			cs.sendMessage(ChatColor.RED+"You can't do that.");
			cs.sendMessage(ChatColor.GREEN+"The correct way: /valuta <add/remove/set> <player> <amount>");
			return true;
		}
               
		if (cs.hasPermission(valuta.use))
	}
		return true;
	}
