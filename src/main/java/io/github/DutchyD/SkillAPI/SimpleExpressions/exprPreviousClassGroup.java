package io.github.DutchyD.SkillAPI.SimpleExpressions;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.api.event.PlayerClassChangeEvent;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.skript.registrations.Classes;
import ch.njol.util.Kleenean;

public class exprPreviousClassGroup extends SimpleExpression<String> {
	
	@Override
	public boolean init(final Expression<?>[] vars, final int matchedPattern, final Kleenean isDelayed, final ParseResult parser) {
		if (!ScriptLoader.isCurrentEvent(PlayerClassChangeEvent.class)) {
			Skript.error("Cannot use 'SkillAPI previous class group' outside of a PlayerClassChangeEvent event", ErrorQuality.SEMANTIC_ERROR);
			return false;
		}
		return true;
	}
	
	@Override
	protected String[] get(final Event e) {
		return new String[] {getPreviousClass(e)};
	}
	
	@Nullable
	private static String getPreviousClass(final @Nullable Event e) {
		if (e == null)
			return null;
		if (e instanceof PlayerClassChangeEvent) {
			
			final Object o = ((PlayerClassChangeEvent) e).getPreviousClass().getGroup();
			
			return (String) o;
		}
		return null;
	}
	
	@Override
	public Class<? extends String> getReturnType() {
		return String.class;
	}
	
	@Override
	public String toString(final @Nullable Event e, final boolean debug) {
		if (e == null)
			return "SkillAPI previous class group";
		return Classes.getDebugMessage(getSingle(e));
	}
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
}