package io.github.DutchyD.SkillAPI.Effects;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.enums.ExpSource;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffAllowExpSource extends Effect {
	
	private Expression<ExpSource> exp;
	private Expression<String> string;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.exp = (Expression<ExpSource>) exprs[0];
		this.string = (Expression<String>) exprs[1];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI add %ExpSource% to %string%'s allowed exp[erience] sources";
	}

	@Override
	protected void execute(Event e) {
		String string = (String)this.string.getSingle(e);
		ExpSource source = (ExpSource)this.exp.getSingle(e);
		
		
		
		try {
			
			SkillAPI.getClass(string).allowExpSource(source);
			
		} catch (NullPointerException ex) {
			
			Skript.warning("[SkRPG] Error: NPE at adding an experience source to player. Please make sure the player has a class and the type of ExpSource is entered correctly.");
			return;
		}
	}
}
