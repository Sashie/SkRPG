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

public class exprAttributePoints extends SimpleExpression<Integer> {
	
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Class<? extends Integer> getReturnType() {
		return Integer.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI attribute points";
	}
	
	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
			
		if (mode == ChangeMode.SET) {
			SkillAPI.getPlayerData(player.getSingle(e)).setAttribPoints((Integer)delta[0]);
		}
			
		if (mode == ChangeMode.ADD) {
				
			SkillAPI.getPlayerData(player.getSingle(e)).giveAttribPoints((Integer)delta[0]);
		}
	}
			
	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		
		if (mode == Changer.ChangeMode.SET)
			
			return CollectionUtils.array(Integer.class);
		
		if (mode == Changer.ChangeMode.ADD)
			
			return CollectionUtils.array(Integer.class);
		
		return null;
	}
		
	@Override
	@Nullable
	protected Integer[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			
			return new Integer[]{ SkillAPI.getPlayerData(p).getAttributePoints() };
			
		} catch (NullPointerException ex) {
			
			return new Integer[]{ 0 };
		}
	}
}
