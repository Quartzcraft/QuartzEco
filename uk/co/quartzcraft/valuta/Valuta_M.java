#
# Valuta | © QuartzCraft 2015
# Valuta_M.java
# All Rights Reserved.
#

package uk.co.quartzcraft.valuta;
 
import java.util.HashMap;
 
public class Valuta_M
{
	public static HashMap<String, Double> balance = new HashMap<>();

	public static void setBalance(String player, double amount)
	{
		balance.put(player, amount);
	}

	public static Double getBalance (String player)
	{
		return balance.get(player);
	}
}
