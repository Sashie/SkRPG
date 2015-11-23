package io.github.DutchyD.SkillAPI.Conditions;

import org.bukkit.entity.Player;

import com.sucy.skill.SkillAPI;

import ch.njol.skript.conditions.base.PropertyCondition;

public class CondSkillbarIsEnabled extends PropertyCondition<Player> {

	@Override
	public boolean check(Player player) {
		return SkillAPI.getPlayerData(player).getSkillBar().isEnabled();
	}

	@Override
	protected String getPropertyName() {
		return "SkillAPI skillbar is enabled";
	}
	
	
}
