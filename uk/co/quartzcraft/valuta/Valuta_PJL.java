package uk.co.quartzcraft.valuta;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Valuta_PJL implements Listener 
{
	@EventHandler
	public void plugin (PlayerJoinEvent event)
	{
		if(Valuta_M.hasAccount(event.getPlayer().getUniqueId())) return;
		Valuta_M.setBalance(event.getPlayer().getUniqueId(), 1500);
	}
}
