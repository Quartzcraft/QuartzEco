package uk.co.quartzcraft.valuta.util;

import java.util.HashMap;

import uk.co.quartzcraft.core.data.QPlayer;
import uk.co.quartzcraft.core.systems.fancymessage.FancyMessage;

public class ActionMessenger {

	public static HashMap<Integer, FancyMessage> actionMessages = new HashMap<Integer, FancyMessage>();
	
	public void registerMessage(Integer id, FancyMessage message) {
		if(actionMessages.containsKey(id)) {
			actionMessages.remove(id);
		}
		actionMessages.put(id, message);
	}
	
	public void removeMessage(Integer id) {
		if(actionMessages.containsKey(id)) {
			actionMessages.remove(id);
		}
	}
	
	public FancyMessage getMessage(Integer id) {
		if(actionMessages.containsKey(id)) {
			return actionMessages.get(id);
		} else {
			return null;
		}
	}
	
	public void sendMessage(Integer id, QPlayer player) {
		FancyMessage fm = getMessage(id);
		if(fm == null) {
			return;
		} else {
			fm.send(player.getPlayer());
		}
	}
}
