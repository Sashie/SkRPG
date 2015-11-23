package io.github.DutchyD.SkillAPI.SimpleExpressions;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.api.enums.ExpSource;
import com.sucy.skill.api.event.PlayerExperienceGainEvent;
import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.skript.registrations.Classes;
import ch.njol.util.Kleenean;

public class exprExpSource extends SimpleExpression<ExpSource> {
	
	@Override
	public boolean init(final Expression<?>[] vars, final int matchedPattern, final Kleenean isDelayed, final ParseResult parser) {
		if (!ScriptLoader.isCurrentEvent(PlayerExperienceGainEvent.class)) {
			Skript.error("Cannot use 'SkillAPI ExpSource' outside of a experience gain event", ErrorQuality.SEMANTIC_ERROR);
			return false;
		}
		return true;
	}
	
	@Override
	protected ExpSource[] get(final Event e) {
		return new ExpSource[] {getExp(e)};
	}
	
	@Nullable
	private static ExpSource getExp(final @Nullable Event e) {
		if (e == null)
			return null;
		if (e instanceof PlayerExperienceGainEvent) {
			
			final Object o = ((PlayerExperienceGainEvent) e).getSource();
			
			return (ExpSource) o;
		}
		return null;
	}
	
	@Override
	public Class<? extends ExpSource> getReturnType() {
		return ExpSource.class;
	}
	
	@Override
	public String toString(final @Nullable Event e, final boolean debug) {
		if (e == null)
			return "SkillAPI ExpSource";
		return Classes.getDebugMessage(getSingle(e));
	}
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
}