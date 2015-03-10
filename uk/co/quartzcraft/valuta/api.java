package uk.co.quartzcraft.valuta;

public class api
{
	private static Valuta plugin = Valuta_M.getPlugin();
	
	public static save saveBalances()
	{
		for(String p : Valuta_M.getBalanceMap().keySet())
		{
			plugin.getConfig().get("balance.+p, Valuta_M.getBalanceMap().get(p)");
		}
		plugin.saveConfig();
	}
	
	public static void loadBalances()
	{
		if(!plugin.getConfig().contains("balance")) return;
		for(String S : plugin.getConfig().getConfigurationSection("balance".getKeys(false)))
		{
			Valuta_M.setBalance(s, plugin.getConfig().getDouble("balance."+s));
		}
	}
}
