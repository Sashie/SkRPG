package io.github.DutchyD.Registration;

import ch.njol.skript.Skript;
import io.github.DutchyD.MythicMobs.Effects.EffSpawnMythicMob;
import io.github.DutchyD.SkillAPI.Effects.EffAddExp;
import io.github.DutchyD.SkillAPI.Effects.EffAddLevel;
import io.github.DutchyD.SkillAPI.Effects.EffAddSkillPoints;
import io.github.DutchyD.SkillAPI.Effects.EffAllowExpSource;
import io.github.DutchyD.SkillAPI.Effects.EffCastSkill;
import io.github.DutchyD.SkillAPI.Effects.EffClearBonuses;
import io.github.DutchyD.SkillAPI.Effects.EffClearPlayerData;
import io.github.DutchyD.SkillAPI.Effects.EffDisallowExpSource;
import io.github.DutchyD.SkillAPI.Effects.EffOpenAttributeMenu;
import io.github.DutchyD.SkillAPI.Effects.EffProfess;
import io.github.DutchyD.SkillAPI.Effects.EffRefundAttributePoints;
import io.github.DutchyD.SkillAPI.Effects.EffRegenerateMana;
import io.github.DutchyD.SkillAPI.Effects.EffToggleSkillbar;

public class RegisterEffects {
	
	public static void SkillAPI() {
		
		Skript.registerEffect(EffAddLevel.class, new String[] { "SkillAPI add %integer% level[s] to %player% from exp source %expsource%" } );
		Skript.registerEffect(EffAddExp.class, new String[] { "SkillAPI add %integer% Exp[erience] to %player% from exp source %expsource%" } );
		Skript.registerEffect(EffAddSkillPoints.class, new String[] { "SkillAPI add %integer% (sp|skillpoint[s]|skill point[s]) to %player% from exp source %expsource%" } );
		Skript.registerEffect(EffRefundAttributePoints.class, new String[] { "SkillAPI refund %player%'s attribute points", "SkillAPI refund attribute points of %player%"} );
		Skript.registerEffect(EffClearPlayerData.class, new String[] { "SkillAPI clear %player%'s data", "SkillAPI clear data of %player%"} );
		Skript.registerEffect(EffClearBonuses.class, new String[] { "SkillAPI clear %player%'s bonuses", "SkillAPI clear bonuses of %player%"} );
		Skript.registerEffect(EffToggleSkillbar.class, new String[] { "SkillAPI toggle %player%'s skillbar", "SkillAPI toggle skillbar of %player%"} );
		Skript.registerEffect(EffRegenerateMana.class, new String[] { "SkillAPI regen[erate] %player%'s mana", "SkillAPI regen[erate] mana of %player%"} );
		Skript.registerEffect(EffOpenAttributeMenu.class, new String[] { "SkillAPI open attr[ibute] menu (for|of) %player%", "SkillAPI open %player%'s attr[ibute] menu"} );
		
		Skript.registerEffect(EffAllowExpSource.class, new String[] { "SkillAPI add %ExpSource% (to|from) %string%'s allowed exp[erience] sources"} );
		Skript.registerEffect(EffDisallowExpSource.class, new String[] { "SkillAPI remove %ExpSource% (to|from) %string%'s allowed exp[erience] sources"} );
		Skript.registerEffect(EffCastSkill.class, new String[] { "SkillAPI make %player% cast skill %string%"} );
		Skript.registerEffect(EffProfess.class, new String[] { "SkillAPI profess %player% into %string%" } );
	}
	
	public static void MythicMobs() {
		
		Skript.registerEffect(EffSpawnMythicMob.class, new String[] { "MythicMobs Spawn level %integer% MythicMob %string% at %location%" } );
		
	}

}
