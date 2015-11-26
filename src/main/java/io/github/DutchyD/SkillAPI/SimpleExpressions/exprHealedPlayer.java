package io.github.DutchyD.SkillAPI.SimpleExpressions;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.api.event.SkillHealEvent;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.skript.registrations.Classes;
import ch.njol.util.Kleenean;

public class exprHealedPlayer extends SimpleExpression<Entity> {
	
	@Override
	public boolean init(final Expression<?>[] vars, final int matchedPattern, final Kleenean isDelayed, final ParseResult parser) {
		if (!ScriptLoader.isCurrentEvent(SkillHealEvent.class)) {
			Skript.error("Cannot use 'SkillAPI healed player' outside of a SkillDamage event", ErrorQuality.SEMANTIC_ERROR);
			return false;
		}
		return true;
	}
	
	@Override
	protected Entity[] get(final Event e) {
		return new Entity[] {getHealedPlayer(e)};
	}
	
	@Nullable
	private static Entity getHealedPlayer(final @Nullable Event e) {
		if (e == null)
			return null;
		if (e instanceof SkillHealEvent) {
			
			final Object o = ((SkillHealEvent) e).getTarget();
			
			return (Entity) o;
		}
		return null;
	}
	
	@Override
	public Class<? extends Entity> getReturnType() {
		return Entity.class;
	}
	
	@Override
	public String toString(final @Nullable Event e, final boolean debug) {
		if (e == null)
			return "SkillAPI healed player";
		return Classes.getDebugMessage(getSingle(e));
	}
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
}