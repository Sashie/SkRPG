package io.github.DutchyD.SkillAPI.Expressions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class exprChatColour extends SimpleExpression<ChatColor> {
	
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Class<? extends ChatColor> getReturnType() {
		return ChatColor.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.player = (Expression<Player>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "SkillAPI chat colour of %player%";
	}

	@Override
	@Nullable
	protected ChatColor[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			
			return new ChatColor[]{ SkillAPI.getPlayerData(p).getMainClass().getData().getPrefixColor() };
			
		} catch (NullPointerException ex) {
			
			return new ChatColor[]{ ChatColor.WHITE };
		}
	}
}
