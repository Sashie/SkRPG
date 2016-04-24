package io.github.DutchyD.Registration;

import ch.njol.skript.Skript;
import io.github.DutchyD.SkillAPI.Conditions.CondCanProfess;
import io.github.DutchyD.SkillAPI.Conditions.CondHasSkill;
import io.github.DutchyD.SkillAPI.Conditions.CondSkillbarIsEnabled;
import io.github.DutchyD.SkillAPI.Conditions.CondSkillbarIsSetup;

public class RegisterConditions {
	
	public static void SkillAPI() {
		
		
		Skript.registerCondition(CondCanProfess.class, "SkillAPI %player% can profess");
		Skript.registerCondition(CondSkillbarIsEnabled.class, "SkillAPI %player% has skillbar enabled");
		Skript.registerCondition(CondSkillbarIsSetup.class, "SkillAPI %player% skillbar is setup");
		Skript.registerCondition(CondHasSkill.class, "SkillAPI %player% has skill %string%");
	}
}
