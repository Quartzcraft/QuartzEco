package uk.co.quartzcraft.valuta.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import uk.co.quartzcraft.valuta.util.VPlayer;

public class PlayerJoin implements Listener {
	
	public void onPlayerJoin(PlayerJoinEvent event) {
		VPlayer vp = new VPlayer(event.getPlayer());
		vp.createIfNotExists();
	}

}
