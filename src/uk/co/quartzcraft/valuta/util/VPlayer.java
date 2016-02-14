package uk.co.quartzcraft.valuta.util;

import org.bukkit.entity.Player;

import uk.co.quartzcraft.core.data.QPlayer;

public class VPlayer {

	private QPlayer player;
	private Double balance;
	
	
	// CONSTRUCT
	public VPlayer(QPlayer p) {
		this.player = p;
	}
	
	public VPlayer(Player p) {
		QPlayer qp = new QPlayer(player.getUniqueId());
		new VPlayer(qp);
	}
	
	// GETTERS
	public Player getPlayer() {
		return this.player.getPlayer();
	}
	
	public QPlayer getQPlayer() {
		return this.player;
	}
	
	public Double getBalance() {
		return this.balance;
	}
	
	//SETTERS
	public void setBalance(Double b) {
		this.balance = b;
	}
	
	//EXTRAS
	public String getPrettyBalance(Boolean includeCurrencySymbol) {
		CurrencyManager cm = new CurrencyManager();
		return cm.makeBalancePretty(getBalance(), includeCurrencySymbol);
	}
}
