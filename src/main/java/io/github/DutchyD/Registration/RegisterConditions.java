package io.github.DutchyD.Registration;

import ch.njol.skript.Skript;
import io.github.DutchyD.SkillAPI.Conditions.CondCanProfess;

public class RegisterConditions {
	
	public static void SkillAPI() {
		
		Skript.registerCondition(CondCanProfess.class, "SkillAPI can profess");
	}
}
