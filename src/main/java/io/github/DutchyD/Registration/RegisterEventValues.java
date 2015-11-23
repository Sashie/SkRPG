package io.github.DutchyD.Registration;

import org.bukkit.entity.Player;
import com.sucy.skill.api.event.PlayerCastSkillEvent;
import com.sucy.skill.api.event.PlayerClassChangeEvent;
import com.sucy.skill.api.event.PlayerExperienceGainEvent;
import com.sucy.skill.api.event.PlayerExperienceLostEvent;
import com.sucy.skill.api.event.PlayerLevelUpEvent;
import com.sucy.skill.api.event.PlayerManaGainEvent;
import com.sucy.skill.api.event.PlayerManaLossEvent;
import com.sucy.skill.api.event.PlayerSkillUnlockEvent;

import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;

public class RegisterEventValues {
	
	public static void SkillAPI() {
		
		EventValues.registerEventValue(PlayerLevelUpEvent.class, Player.class, new Getter<Player, PlayerLevelUpEvent>() {
			
			public Player get(PlayerLevelUpEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerExperienceGainEvent.class, Player.class, new Getter<Player, PlayerExperienceGainEvent>() {
			
			public Player get(PlayerExperienceGainEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerExperienceLostEvent.class, Player.class, new Getter<Player, PlayerExperienceLostEvent>() {
			
			public Player get(PlayerExperienceLostEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerClassChangeEvent.class, Player.class, new Getter<Player, PlayerClassChangeEvent>() {
			
			public Player get(PlayerClassChangeEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerCastSkillEvent.class, Player.class, new Getter<Player, PlayerCastSkillEvent>() {
			
			public Player get(PlayerCastSkillEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerManaGainEvent.class, Player.class, new Getter<Player, PlayerManaGainEvent>() {
			
			public Player get(PlayerManaGainEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerManaLossEvent.class, Player.class, new Getter<Player, PlayerManaLossEvent>() {
			
			public Player get(PlayerManaLossEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
		
		EventValues.registerEventValue(PlayerSkillUnlockEvent.class, Player.class, new Getter<Player, PlayerSkillUnlockEvent>() {
			
			public Player get(PlayerSkillUnlockEvent e) {
				
				return e.getPlayerData().getPlayer().getPlayer();
			}
		}, 0);
	}
}
