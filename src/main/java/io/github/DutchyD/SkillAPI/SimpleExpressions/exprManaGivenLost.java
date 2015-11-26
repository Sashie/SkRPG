package io.github.DutchyD.SkillAPI.SimpleExpressions;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.api.event.PlayerManaGainEvent;
import com.sucy.skill.api.event.PlayerManaLossEvent;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.skript.registrations.Classes;
import ch.njol.util.Kleenean;

public class exprManaGivenLost extends SimpleExpression<Double> {
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(final Expression<?>[] vars, final int matchedPattern, final Kleenean isDelayed, final ParseResult parser) {
		if (!ScriptLoader.isCurrentEvent(PlayerManaGainEvent.class, PlayerManaLossEvent.class)) {
			Skript.error("Cannot use 'SkillAPI Mana Given/Lost' outside of a Mana gain/loss event", ErrorQuality.SEMANTIC_ERROR);
			return false;
		}
		return true;
	}
	
	@Override
	protected Double[] get(final Event e) {
		return new Double[] {getManaGivenLost(e)};
	}
	
	@Nullable
	private static Double getManaGivenLost(final @Nullable Event e) {
		if (e == null)
			return null;
		if (e instanceof PlayerManaGainEvent) {
			
			final Object o = ((PlayerManaGainEvent) e).getAmount();
			
			return (Double) o;
		}
		
		if (e instanceof PlayerManaLossEvent) {
			
			final Object o = ((PlayerManaLossEvent) e).getAmount();
			
			return (Double) o;
		}
		return null;
	}
	
	@Override
	public Class<? extends Double> getReturnType() {
		return Double.class;
	}
	
	@Override
	public String toString(final @Nullable Event e, final boolean debug) {
		if (e == null)
			return "SkillAPI mana given or lost";
		return Classes.getDebugMessage(getSingle(e));
	}
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
}