package io.github.DutchyD.SkillAPI.Effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.enums.ExpSource;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffAddSkillPoints extends Effect {
	
	private Expression<ExpSource> exp;
	private Expression<Player> player;
	private Expression<Integer> number;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.exp = (Expression<ExpSource>) exprs[2];
		this.player = (Expression<Player>) exprs[1];
		this.number = (Expression<Integer>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI add %amount% (sp|skill points|skill points) to %player% from exp source %source%";
	}

	@Override
	protected void execute(Event e) {
		Player p = (Player)this.player.getSingle(e);
		Integer amount = (Integer)this.number.getSingle(e);
		ExpSource source = (ExpSource)this.exp.getSingle(e);
		
		
		
		try {
			
			SkillAPI.getPlayerData(p).givePoints(amount, source);
			
		} catch (NullPointerException ex) {
			
			Skript.warning("[SkRPG] Error: NPE at adding skill points to class. Did the player have a class in the first place?");
			return;
		}
	}
}
