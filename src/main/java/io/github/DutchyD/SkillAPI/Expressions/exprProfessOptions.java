package io.github.DutchyD.SkillAPI.Expressions;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class exprProfessOptions extends SimpleExpression<String> {
	
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Class<? extends String> getReturnType() {
		return String.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI profess options of %player%";
	}

	@Override
	@Nullable
	protected String[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			
			return new String[]{ SkillAPI.getPlayerData(p).getMainClass().getData().getOptions().toString() };
			
		} catch (NullPointerException ex) {
			
			return new String[]{ "None" };
		}
	}
}
