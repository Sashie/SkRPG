package io.github.DutchyD.SkillAPI.Effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffClearPlayerData extends Effect {
	
	private Expression<Player> player;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI add %amount% Exp[erience] to %player% from exp source %source%";
	}

	@Override
	protected void execute(Event e) {
		Player p = (Player)this.player.getSingle(e);
		
		
		
		try {
			
			SkillAPI.getPlayerData(p).resetAll();
			
		} catch (NullPointerException ex) {
			
			Skript.warning("[SkRPG] Error: NPE resetting class. Did the player have a class in the first place?");
			return;
		}
	}
}
