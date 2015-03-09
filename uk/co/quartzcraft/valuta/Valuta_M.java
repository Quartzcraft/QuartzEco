#
# Valuta | © QuartzCraft 2015
# Valuta_M.java
# All Rights Reserved.
#

package uk.co.quartzcraft.valuta;

import java.util.HashMap;

public class Valuta_M
{
	private static Valuta plugin;
	
	public Valuta_M(Valuta instance)
	{
		plugin = instance;
	}
	
	public static HashMap<String, Double> balance = new HashMap<>();
	
	public static void setBalance(String player, double amount)
	{
		balance.put(player, amount);
	}
	
	public static Double getBalance (String player)
	{
		return balance.get(player);
	}
	
	public static boolean hasAccount (String player)
	{
		return balance.containsKey(player); 
	}
	

		public static HashMap<String, Double> getBalanceMap()
		{
			return balance;
		}
		
		public static Valuta getPlugin()
		{
			return plugin;
		}
}
