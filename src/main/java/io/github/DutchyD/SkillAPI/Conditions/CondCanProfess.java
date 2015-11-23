package io.github.DutchyD.SkillAPI.Conditions;

import org.bukkit.entity.Player;

import com.sucy.skill.SkillAPI;

import ch.njol.skript.conditions.base.PropertyCondition;

public class CondCanProfess extends PropertyCondition<Player> {

	@Override
	public boolean check(Player player) {
		return SkillAPI.getPlayerData(player).canProfess( SkillAPI.getPlayerData(player).getMainClass().getData() );
	}

	@Override
	protected String getPropertyName() {
		return "SkillAPI can profess";
	}
	
	
}
