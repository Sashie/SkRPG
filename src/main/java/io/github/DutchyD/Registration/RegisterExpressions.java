package io.github.DutchyD.Registration;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import io.github.DutchyD.SkillAPI.Expressions.exprAttributePoints;
import io.github.DutchyD.SkillAPI.Expressions.exprClassGroup;
import io.github.DutchyD.SkillAPI.Expressions.exprHealth;
import io.github.DutchyD.SkillAPI.Expressions.exprLevel;
import io.github.DutchyD.SkillAPI.Expressions.exprMainClass;
import io.github.DutchyD.SkillAPI.Expressions.exprMana;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxHealth;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxLevel;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxMana;

public class RegisterExpressions {
	
	public static void SkillAPI() {
		
		Skript.registerExpression(exprMaxMana.class, Double.class, ExpressionType.PROPERTY, "SkillAPI max mana of %player%", "SkillAPI %player%'s max mana"); //Settable
		Skript.registerExpression(exprMana.class, Double.class, ExpressionType.PROPERTY, "SkillAPI mana of %player%", "SkillAPI %player%'s mana");
		Skript.registerExpression(exprMainClass.class, String.class, ExpressionType.PROPERTY, "SkillAPI main class of %player%", "SkillAPI %player%'s main class"); //Settable
		Skript.registerExpression(exprMaxLevel.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI max level of %player%", "SkillAPI %player%'s max level");
		Skript.registerExpression(exprLevel.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI level of %player%", "SkillAPI %player%'s level");
		Skript.registerExpression(exprHealth.class, Double.class, ExpressionType.PROPERTY, "SkillAPI health of %player%", "SkillAPI %player%'s health");
		Skript.registerExpression(exprMaxHealth.class, Double.class, ExpressionType.PROPERTY, "SkillAPI max health of %player%", "SkillAPI %player%'s max health"); //Settable
		Skript.registerExpression(exprAttributePoints.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI attribute points of %player%", "SkillAPI %player%'s attribute points"); //Settable
		Skript.registerExpression(exprClassGroup.class, String.class, ExpressionType.PROPERTY, "SkillAPI class group of %player%", "SkillAPI %player%'s class group");
		
	}

}
