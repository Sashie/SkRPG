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
		
		Skript.registerEvent("SkillAPI level up", SimpleEvent.class, PlayerLevelUpEvent.class, "SkillAPI level up");
		Skript.registerEvent("SkillAPI experience gain", SimpleEvent.class, PlayerExperienceGainEvent.class, "SkillAPI experience gain");
		Skript.registerEvent("SkillAPI experience loss", SimpleEvent.class, PlayerExperienceLostEvent.class, "SkillAPI experience loss");
		Skript.registerEvent("SkillAPI class change", SimpleEvent.class, PlayerClassChangeEvent.class, "SkillAPI class change");
		Skript.registerEvent("SkillAPI cast skill", SimpleEvent.class, PlayerCastSkillEvent.class, "SkillAPI cast skill");
		Skript.registerEvent("SkillAPI mana gain", SimpleEvent.class, PlayerManaGainEvent.class, "SkillAPI mana gain");
		Skript.registerEvent("SkillAPI cast skill", SimpleEvent.class, PlayerManaLossEvent.class, "SkillAPI cast skill");
		Skript.registerEvent("SkillAPI SkillAPI skill unlock", SimpleEvent.class, PlayerSkillUnlockEvent.class, "SkillAPI skill unlock");
		
	}

}
