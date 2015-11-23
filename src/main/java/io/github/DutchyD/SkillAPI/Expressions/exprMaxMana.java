package io.github.DutchyD.SkillAPI.Expressions;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;

public class exprMaxMana extends SimpleExpression<Double> {
	
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Class<? extends Double> getReturnType() {
		return Double.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI max mana of Player";
	}

	@Override
	@Nullable
	protected Double[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			
			return new Double[]{ SkillAPI.getPlayerData(p).getMaxMana() };
			
		} catch (NullPointerException ex) {
			
			return new Double[]{ 0.0 };
		}
	}
	
	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
			
		if (mode == ChangeMode.ADD) {
				
			SkillAPI.getPlayerData(player.getSingle(e)).addMaxMana((Double)delta[0]);
		}
	}
			
	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		
		if (mode == Changer.ChangeMode.SET)
			
			return null;
		
		if (mode == Changer.ChangeMode.ADD)
			
			return CollectionUtils.array(Double.class);
		
		return null;
	}
}
