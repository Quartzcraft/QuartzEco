#
# Valuta | © QuartzCraft 2015
# Valuta_M.java
# All Rights Reserved.
#

package uk.co.quartzcraft.valuta;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Valuta_C implements CommandExecutor
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
		
	if(args[0].equalsIgnoreCase("add"))
	{
		if(Valuta_M.hasAccount(args [1]));
		{
			cs.sendMessage(ChatColor.RED+"This player doesn't have an account!");
			return true;
		}
		double amount = 0;
		try
		{
			amount = double.parseDouble(args [2]);
		}catch (Exception e)
		{
			cs.sendMessage(ChatColor.RED+"Please enter a correct amount.");
			return true;
		}
		
		Valuta_M.setBalance(args [1], Valuta_M.getBalance(args [1]) + amount);
	}else if (args[0].equalsIgnoreCase("remove"))
	{
		if(Valuta_M.hasAccount(args [1]));
		{
			cs.sendMessage(ChatColor.RED+"This player doesn't have an account!");
			return true;
		}
		double amount = 0;
		try
		{
			amount = double.parseDouble(args [2]);
		}catch (Exception e)
		{
			cs.sendMessage(ChatColor.RED+"Please enter a correct amount.");
			return true;
		}
		
		Valuta_M.setBalance(args [1], Valuta_M.getBalance(args [1]) - amount);
	}else if (args[0].equalsIgnoreCase("set"))
	{
		if(Valuta_M.hasAccount(args [1]));
		{
			cs.sendMessage(ChatColor.RED+"This player doesn't have an account!");
			return true;
		}
		double amount = 0;
		try
		{
			amount = double.parseDouble(args [2]);
		}catch (Exception e)
		{
			cs.sendMessage(ChatColor.RED+"Please enter a correct amount.");
			return true;
		}
		
		Valuta_M.setBalance(args [1], amount);
	}
		cs.sendMessage(ChatColor.RED+"That's an incorrect argument!");
	}
		return true;
	}
	
	
