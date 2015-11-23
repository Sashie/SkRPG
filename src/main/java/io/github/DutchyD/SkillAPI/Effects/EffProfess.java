package io.github.DutchyD.SkillAPI.Effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.classes.RPGClass;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffProfess extends Effect {
	
	private Expression<Player> player;
	private Expression<String> string;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		this.string = (Expression<String>) exprs[1];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI profess player into %string%";
	}

	@Override
	protected void execute(Event e) {
		Player p = (Player)this.player.getSingle(e);
		String s = (String)this.string.getSingle(e);
		RPGClass c = SkillAPI.getClass(s);
		
			SkillAPI.getPlayerData(p).profess(c);
			
	}
}
