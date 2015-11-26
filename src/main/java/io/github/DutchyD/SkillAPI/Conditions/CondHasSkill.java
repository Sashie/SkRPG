package io.github.DutchyD.SkillAPI.Conditions;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class CondHasSkill extends Condition {
	
	private Expression<String> string;
	private Expression<Player> player;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		this.string = (Expression<String>) exprs[1];
		return false;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		// TODO Auto-generated method stub
		return "%player% has skill %string%";
	}

	@Override
	public boolean check(Event e) {
		Player p = (Player)this.player.getSingle(e);
		String s = (String)this.string.getSingle(e);
		
		SkillAPI.getPlayerData(p).hasSkill(s);
		
		return false;
	}	
}
