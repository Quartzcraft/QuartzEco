/*
 *  YAMLManager - by nfell2009
 *  All rights reserved
 *  Version: 1.2 (http://nfell2009.uk/rhino/yaml)
 * 
 */

package uk.co.quartzcraft.valuta;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class YAMLManager {
	
	private FileConfiguration fileConfig;
	private Object mainFile;
	
	// CONSTRUCT
	public YAMLManager(Object file) {
		this.fileConfig = toFileConfig(file);
		this.mainFile = file;
	}
	// GETTERS
	public FileConfiguration getFileConfig() {
		return this.fileConfig;
	}
	// EXTRAS
	public FileConfiguration toFileConfig(Object file) {
		if(file.getClass().equals(String.class)) {
			File yamlFile = new File((String) file);
			if (yamlFile.exists()) {
				return YamlConfiguration.loadConfiguration(yamlFile);
			}
		} else if (file.getClass().equals(File.class)) {
			File yamlFile = (File) file;
			if (yamlFile.exists()) {
				return YamlConfiguration.loadConfiguration(yamlFile);
			}
		}
		return null;
	}
	
	public Object getYAMLValue(String path) {
		if(fileConfig == null) {
			return null;
		} else {
			return fileConfig.get(path);
		}
	}
	
	public void deleteYAMLValue(String path) {
		writeYAMLValue(path, null);
	}
	
	public void writeYAMLValue(String path, Object value) {
		if(fileConfig == null) {
			return;
		} else {
			fileConfig.set(path, value);
			saveYAML();
		}
	}
	
	public void saveYAML() {
		if(mainFile.getClass().equals(String.class)) {
			try {
				fileConfig.save((String) mainFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (mainFile.getClass().equals(File.class)) {
			try {
				fileConfig.save((File) mainFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
