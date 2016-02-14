package uk.co.quartzcraft.valuta.util;

import org.bukkit.entity.Player;

import uk.co.quartzcraft.core.data.QPlayer;
import uk.co.quartzcraft.valuta.Valuta;

public class CurrencyManager {

	public String makeBalancePretty(Double b, Boolean addCurrencySign) {
		String bal = String.valueOf(b);
		if(bal.length() <= 3) {
			if(addCurrencySign) {
				if(Valuta.beforeText) {
					return Valuta.currencySymbol + bal;
				} else {
					return bal + Valuta.currencySymbol;
				}
			} else {
				return bal;
			}
		} else {
			String[] sBal = bal.split("");
			Integer i = 0;
			String out = null;
			for(String sb : sBal) {
				++i;
				if(i > 3) {
					i = 0;
					out = prepareOutVariable(out, "," + sb);
				} else {
					out = prepareOutVariable(out, sb);
				}
			}
			if(out == null) {
				return bal;
			} else {
				if(addCurrencySign) {
					if(Valuta.beforeText) {
						return Valuta.currencySymbol + out;
					} else {
						return out + Valuta.currencySymbol;
					}
				} else {
					return out;
				}
			}
		}
	}
	
	private String prepareOutVariable(String out, String value) {
		if(out == null) {
			return value;
		} else {
			out = out.concat(value);
			return out;
		}
	}
	
	public VPlayer getVPlayer(Player player) {
		QPlayer qp = new QPlayer(player.getUniqueId());
		return new VPlayer(qp);
	}
	
	
}
