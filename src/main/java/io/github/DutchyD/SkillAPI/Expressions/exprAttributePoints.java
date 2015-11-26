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

public class exprAttributePoints extends SimpleExpression<Number> {
	
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Class<? extends Number> getReturnType() {
		return Number.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI attribute points of %player%";
	}
	
	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
			
		
		Number n = (Number)delta[0];
		Integer integer = n.intValue();
		
		if (mode == ChangeMode.SET) {
			
			SkillAPI.getPlayerData(player.getSingle(e)).setAttribPoints(integer);
		}
			
		if (mode == ChangeMode.ADD) {
				
			SkillAPI.getPlayerData(player.getSingle(e)).giveAttribPoints(integer);
		}
	}
			
	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		
		if (mode == Changer.ChangeMode.SET)
			
			return CollectionUtils.array(Number.class);
		
		if (mode == Changer.ChangeMode.ADD)
			
			return CollectionUtils.array(Number.class);
		
		return null;
	}
		
	@Override
	@Nullable
	protected Number[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			
			Integer integer = SkillAPI.getPlayerData(p).getAttributePoints();
			Number number = (Number)integer;
			
			return new Number[]{ number };
			
		} catch (NullPointerException ex) {
			
			return new Number[]{ 0 };
		}
	}
}
