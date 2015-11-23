package io.github.DutchyD.MythicMobs.Effects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import net.elseland.xikage.MythicMobs.MythicMobs;
import net.elseland.xikage.MythicMobs.API.MythicMobsAPI;
import net.elseland.xikage.MythicMobs.Mobs.MythicMob;

public class EffSpawnMythicMob extends Effect {
	
	private Expression<Location> loc;
	private Expression<String> string;
	private Expression<Integer> integer;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		this.loc = (Expression<Location>) exprs[2];
		this.string = (Expression<String>) exprs[1];
		this.integer = (Expression<Integer>) exprs[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		// TODO Auto-generated method stub
		return "MythicMobs Spawn level %integer% MythicMob %string% at %location%";
	}

	@Override
	protected void execute(Event e) {
		Location l = (Location)this.loc.getSingle(e);
		String string = (String)this.string.getSingle(e);
		Integer i = (Integer)this.integer.getSingle(e);
		
			
		MythicMobs mythicmobs = (MythicMobs) Bukkit.getServer().getPluginManager().getPlugin("MythicMobs");
			
		MythicMobsAPI api = mythicmobs.getAPI();
		MythicMob mm = api.getMobAPI().getMythicMob(string);
		api.getMobAPI().spawnMythicMob(mm, l, i);
			
		if (!( api.getMobAPI().getMythicMob(string).getInternalName().toString().equals(string) )) {
				
			Skript.warning("Tried to spawn nonexistant MythicMobs mob.");
				
		}
	}
}