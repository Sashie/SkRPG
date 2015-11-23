package io.github.DutchyD.Registration;

import com.sucy.skill.api.event.PlayerCastSkillEvent;
import com.sucy.skill.api.event.PlayerClassChangeEvent;
import com.sucy.skill.api.event.PlayerExperienceGainEvent;
import com.sucy.skill.api.event.PlayerExperienceLostEvent;
import com.sucy.skill.api.event.PlayerLevelUpEvent;
import com.sucy.skill.api.event.PlayerManaGainEvent;
import com.sucy.skill.api.event.PlayerManaLossEvent;
import com.sucy.skill.api.event.PlayerSkillUnlockEvent;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;

public class RegisterEvents {
	
	public static void SkillAPI() {
		
		Skript.registerEvent("SkillAPI player level up", SimpleEvent.class, PlayerLevelUpEvent.class, "SkillAPI player level up");
		Skript.registerEvent("SkillAPI player experience gain", SimpleEvent.class, PlayerExperienceGainEvent.class, "SkillAPI player experience gain");
		Skript.registerEvent("SkillAPI player experience loss", SimpleEvent.class, PlayerExperienceLostEvent.class, "SkillAPI player experience loss");
		Skript.registerEvent("SkillAPI player class change", SimpleEvent.class, PlayerClassChangeEvent.class, "SkillAPI player class change");
		Skript.registerEvent("SkillAPI player cast skill", SimpleEvent.class, PlayerCastSkillEvent.class, "SkillAPI player cast skill");
		Skript.registerEvent("SkillAPI player mana gain", SimpleEvent.class, PlayerManaGainEvent.class, "SkillAPI player mana gain");
		Skript.registerEvent("SkillAPI player cast skill", SimpleEvent.class, PlayerManaLossEvent.class, "SkillAPI player cast skill");
		Skript.registerEvent("SkillAPI player cast skill", SimpleEvent.class, PlayerSkillUnlockEvent.class, "SkillAPI skill unlock");
		
	}

}
