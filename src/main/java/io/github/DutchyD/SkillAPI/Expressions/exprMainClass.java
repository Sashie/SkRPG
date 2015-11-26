package io.github.DutchyD.SkillAPI.Expressions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.player.PlayerData;
import com.sucy.skill.manager.ClassBoardManager;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;

public class exprMainClass extends SimpleExpression<String> {
	
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
		return "SkillAPI main class of %player%";
	}

	@Override
	@Nullable
	protected String[] get(Event e) {
		
		Player p = (Player)this.player.getSingle(e);
		
		try {
			
			return new String[]{ SkillAPI.getPlayerData(p).getMainClass().getData().getName() };
			
		} catch (NullPointerException ex) {
			
			return new String[]{ "None" };
		}
	}
	
	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
			
		if (mode == ChangeMode.SET) {
			
			Player p = (Player)this.player.getSingle(e);
			String string = (String)delta[0];
			RPGClass C = SkillAPI.getClass(string);
			
			try {
				
				SkillAPI.getPlayerData(p).getMainClass().setClassData(C);
				
				if (SkillAPI.getPlayerData(p).getMainClass().getData().getName().equalsIgnoreCase(string) == true) {
					
					PlayerData pd = SkillAPI.getPlayerData(player.getSingle(e));
					String prefix = SkillAPI.getClass(string).getPrefix();
					ChatColor cc = SkillAPI.getClass(string).getPrefixColor();
					
					ClassBoardManager.update(pd, prefix, cc);
					
				} else {
					
					Skript.warning("[SkRPG] Scoreboard wasn't updated. Error at: EffSetClass.java");
				}
				
			} catch (NullPointerException ex) {
				
				if (SkillAPI.getPlayerData(p).canProfess(C)) {
					
					SkillAPI.getPlayerData(p).profess(C);
				
				} else {
					
					Skript.warning("[SkRPG] Error setting player's class. Please contact plugin dev. if this happens again.");
					
				}
			}
		}
	}
			
	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		
		if (mode == Changer.ChangeMode.SET)
			
			return CollectionUtils.array(String.class);
		
		if (mode == Changer.ChangeMode.ADD)
			
			return null;
		return null;
	}
}
