package io.github.DutchyD.Registration;

import ch.njol.skript.Skript;
import io.github.DutchyD.SkillAPI.Conditions.CondCanProfess;
import io.github.DutchyD.SkillAPI.Conditions.CondSkillbarIsEnabled;
import io.github.DutchyD.SkillAPI.Conditions.CondSkillbarIsSetup;

public class RegisterConditions {
	
	public static void SkillAPI() {
		
		Skript.registerCondition(CondCanProfess.class, "SkillAPI can profess");
		Skript.registerCondition(CondSkillbarIsEnabled.class, "SkillAPI skillbar is enabled");
		Skript.registerCondition(CondSkillbarIsSetup.class, "SkillAPI skillbar is setup");
	}
}
