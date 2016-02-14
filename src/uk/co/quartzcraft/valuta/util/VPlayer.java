package uk.co.quartzcraft.valuta.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.entity.Player;

import uk.co.quartzcraft.core.data.QPlayer;
import uk.co.quartzcraft.core.systems.perms.Group;
import uk.co.quartzcraft.valuta.Valuta;

public class VPlayer {

	private QPlayer player;
	private Double balance;
	private String prettyBalanceWithCurrency, prettyBalanceWithoutCurrency;
	
	
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
	
	public String getPrettyBalance(Boolean includeCurrencySymbol) {
		if(includeCurrencySymbol) {
			return this.prettyBalanceWithCurrency;
		} else {
			return this.prettyBalanceWithoutCurrency;
		}
	}
	
	
	@Deprecated
	// Deprecated in favour of getPrettyBalance(Boolean b)
	public String getPrettyBalanceWithCurrency() {
		return this.prettyBalanceWithCurrency;
	}
	
	@Deprecated
	// Deprecated in favour of getPrettyBalance(Boolean b)
	public String getPrettyBalanceWithoutCurrency() {
		return this.prettyBalanceWithoutCurrency;
	}
	
	//SETTERS
	public void setBalance(Double b) {
		this.balance = b;
	}
	
	public void setPrettyBalance(Object value, Boolean includeCurrencySymbol) {
		if(value.getClass().equals(String.class)) {
			String v = (String) value;
			if(includeCurrencySymbol) {
				this.prettyBalanceWithCurrency = v;
			} else {
				this.prettyBalanceWithoutCurrency = v;
			}
		} else if(value.getClass().equals(Boolean.class)) {
			if(includeCurrencySymbol) {
				this.prettyBalanceWithCurrency = fetchPrettyBalance(includeCurrencySymbol);
			} else {
				this.prettyBalanceWithCurrency = fetchPrettyBalance(includeCurrencySymbol);
			}
		}
	}
	
	//EXTRAS
	public void subtractFromBalance(Double b) {
		Double vb = getBalance();
		vb = vb - b;
		setBalance(vb);
	}
	
	public void addToBalance(Double b) {
		Double vb = getBalance();
		vb = vb + b;
		setBalance(vb);
	}
	
	public void dividBalance(Double b) {
		Double vb = getBalance();
		vb = vb/b;
		setBalance(vb);
	}
	 
	public void multipleBalance(Double b) {
		Double vb = getBalance();
		vb = vb * b;
		setBalance(vb);
	}
	
	public File getDataFile() {
		return new File(Valuta.playerFolder, getPlayer().getUniqueId() + ".yml");
	}
	
	public void saveData() {
		YAMLManager ym = new YAMLManager(getDataFile());
		ym.writeYAMLValue("data.name", getPlayer().getName());
		ym.writeYAMLValue("data.balance", getBalance());
	}
	
	public void didTransaction() {
		YAMLManager ym = new YAMLManager(getDataFile());
		ym.writeYAMLValue("data.transaction count", (Integer) ym.getYAMLValue("data.transaction count") + 1);
	}
	
	public void logDataToFile(String toLog) {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		YAMLManager ym = new YAMLManager(getDataFile());
		ym.writeYAMLValue("logging.transactions" + date, toLog);
	}
	
	public void logDataToSQLite(String toLog) {
		// TODO: finish this
	}
	
	public void logDataToMySQL(String toLog) {
		// TODO: finish this. Maybe QuartzCore has something... #askmba
	}
	
	public String fetchPrettyBalance(Boolean includeCurrencySymbol) {
		CurrencyManager cm = new CurrencyManager();
		return cm.makeBalancePretty(getBalance(), includeCurrencySymbol);
	}
	
	public Boolean canAfford(Double payment) {
		if(getBalance() > payment) {
			return true;
		} else {
			return false;
		}
	}
	
	public void createIfNotExists() {
		if(getDataFile().exists()) {
			return;
		} else {
			getDataFile().mkdirs();
			Group g = getQPlayer().getGroup();
			YAMLManager ym = new YAMLManager(getDataFile());
			ym.writeYAMLValue("data.name", getName());
			ym.writeYAMLValue("data.balance", (Double) Valuta.configYAML.getYAMLValue("defaults." + g.getFullName()));
		}
	}
	
	public void updateName() {
		if(getDataFile().exists()) {
			getDataFile().mkdirs();
			YAMLManager ym = new YAMLManager(getDataFile());
			ym.writeYAMLValue("data.name", getName());
		} else {
			createIfNotExists();		
		}
	}
	
	public String getName() {
		return getPlayer().getName();
	}
	
	public void unloadD() {
		
	}
	
}
