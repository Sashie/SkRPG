package io.github.DutchyD.SkRPG;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import io.github.DutchyD.Registration.RegisterEffects;
import io.github.DutchyD.Registration.RegisterEventValues;
import io.github.DutchyD.Registration.RegisterEvents;
import io.github.DutchyD.Registration.RegisterExpressions;
import io.github.DutchyD.Registration.RegisterTypes;
public class Main
  extends JavaPlugin {
	
	public void onEnable() {
		
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
		
		Plugin skript = Bukkit.getServer().getPluginManager().getPlugin("Skript");
		if (skript != null) {
			
			Skript.registerAddon(this);
			Bukkit.getServer().getLogger().info("[SkRPG] Plugin has been Enabled");
			
			Plugin SkillAPI = Bukkit.getServer().getPluginManager().getPlugin("SkillAPI");
			Plugin MythicMobs = Bukkit.getServer().getPluginManager().getPlugin("MythicMobs");
			
			if (SkillAPI != null) {
				
				if ( getConfig().getBoolean("SkillAPI") == true ) {
				
					Bukkit.getServer().getLogger().info("[SkRPG] SkillAPI found and registered into Skript!");
					
					//Types				
					RegisterTypes.SkillAPI();		
					//Events
					RegisterEvents.SkillAPI();
					//Event Values
					RegisterEventValues.SkillAPI();
					//Effects
					RegisterEffects.SkillAPI();			
					//Expressions
					RegisterExpressions.SkillAPI();
					
				} else {
					
					Bukkit.getServer().getLogger().info("[SkRPG] SkillAPI was manually disabled in the config and wasn't registered");
					
				}
			}
			
			if (MythicMobs != null) {
				
				if ( getConfig().getBoolean("MythicMobs") == true ) {
					
				
					Bukkit.getServer().getLogger().info("[SkRPG] MythicMobs found and registered into Skript!");
					
					//Effects
					RegisterEffects.MythicMobs();
					
				} else {
					
					Bukkit.getServer().getLogger().info("[SkRPG] MythicMobs was manually disabled in the config and wasn't registered");
					
				}
			}
			
			
		} else {
			
			Bukkit.getPluginManager().disablePlugin(this);
			getLogger().info( "[SkRPG] Plugin disabled. Skript dependency not found." );
			
		}
	} 
	
	public void onDisable() {
		
		getLogger().info( "[SkRPG] Plugin disabled. If no reason was stated, this is probably an error." );
		
		}	
}