package io.github.DutchyD.SkillAPI.Expressions;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class exprLevel extends SimpleExpression<Integer> {
	
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
	@Override
	public Class<? extends Integer> getReturnType() {
		return Integer.class;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "Level of player";
	}
	
	@Override
	@Nullable
	protected Integer[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			return new Integer[]{ SkillAPI.getPlayerData(p).getMainClass().getLevel() };
			
		} catch (NullPointerException ex) {
			
			return new Integer[]{ 0 };
		}
	}
}
