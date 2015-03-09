#
# Valuta | © QuartzCraft 2015
# Valuta.java
# All Rights Reserved.
#

package uk.co.quartzcraft.valuta;

import org.bukkit.plugin.java.JavaPlugin;

public class Valuta extends JavaPlugin
{
	public void onEnable()
	{
		getCommand("valuta").setExecutor(new ValutaCommand());
		new Valuta_M(this);
		api.loadBalances();
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
	}
	
	public void onDisable()
	{
		api.saveBalances();
	}

}
