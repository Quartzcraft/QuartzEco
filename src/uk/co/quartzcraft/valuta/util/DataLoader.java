package uk.co.quartzcraft.valuta.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import uk.co.quartzcraft.core.data.QPlayer;
import uk.co.quartzcraft.valuta.Valuta;

public class DataLoader {
	
	
	// Player join option
	public void setPlayerData(Player p) {
		File pFile = new File(Valuta.playerFolder, p.getUniqueId() + ".yml");
		if(!pFile.exists()) {
			try {
				pFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			YAMLManager ym = new YAMLManager(pFile);
			YAMLManager ymc = new YAMLManager(Valuta.configFile);
			ym.writeYAMLValue("data.balance", (Double) ymc.getYAMLValue("settings.starting balance"));
		}
		YAMLManager ym = new YAMLManager(pFile);
		VPlayer vp = new VPlayer(new QPlayer(p.getUniqueId()));
		vp.setBalance((Double) ym.getYAMLValue("data.balance"));
	}
	
	
	// Server start option
	public void loadAllPlayerData() {
		Set<File> playerFiles = getFiles(Valuta.playerFolder);
		if(playerFiles == null) {
			Bukkit.getLogger().severe("[Valuta] NO PLAYER FILES FOUND. IS THIS A MISTAKE?");
			return;
		} else {
			for(File pFile : playerFiles) {
				YAMLManager ym = new YAMLManager(pFile);
				UUID pUUID = UUID.fromString(pFile.getName());
				VPlayer vp = new VPlayer(new QPlayer(pUUID));
				vp.setBalance((Double) ym.getYAMLValue("data.balance"));
			}
		}
	}
	
	public Set<File> getFiles(File dir) {
		Set<File> fileTree = new HashSet<File>();
	    for (File entry : dir.listFiles()) {
	        if (entry.isFile()) {
	        	fileTree.add(entry);
	        }
	    }
	    if(fileTree.size() > 0) {
	    	return fileTree;
	    } else {
	    	return null;
	    }
	}

}
