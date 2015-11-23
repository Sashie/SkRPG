package io.github.DutchyD.Registration;

import org.bukkit.entity.Entity;

import com.sucy.skill.api.enums.ExpSource;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import io.github.DutchyD.SkillAPI.Expressions.exprAttributePoints;
import io.github.DutchyD.SkillAPI.Expressions.exprClassGroup;
import io.github.DutchyD.SkillAPI.Expressions.exprExperience;
import io.github.DutchyD.SkillAPI.Expressions.exprLevel;
import io.github.DutchyD.SkillAPI.Expressions.exprMainClass;
import io.github.DutchyD.SkillAPI.Expressions.exprMana;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxHealth;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxLevel;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxMana;
import io.github.DutchyD.SkillAPI.Expressions.exprRequiredExp;
import io.github.DutchyD.SkillAPI.Expressions.exprTotalExperience;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprDamage;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprDamager;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprExpSource;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprExperienceGivenLost;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprVictim;

public class RegisterExpressions {
	
	public static void SkillAPI() {
		
		//Settable expressions
		
		Skript.registerExpression(exprMaxMana.class, Number.class, ExpressionType.PROPERTY, "SkillAPI max mana of %player%", "SkillAPI %player%'s max mana");
		Skript.registerExpression(exprMainClass.class, String.class, ExpressionType.PROPERTY, "SkillAPI main class of %player%", "SkillAPI %player%'s main class");
		Skript.registerExpression(exprMaxHealth.class, Number.class, ExpressionType.PROPERTY, "SkillAPI max health of %player%", "SkillAPI %player%'s max health");
		Skript.registerExpression(exprAttributePoints.class, Number.class, ExpressionType.PROPERTY, "SkillAPI attribute points of %player%", "SkillAPI %player%'s attribute points");
		
		//Non-Settable expressions
		Skript.registerExpression(exprClassGroup.class, String.class, ExpressionType.PROPERTY, "SkillAPI class group of %player%", "SkillAPI %player%'s class group");
		Skript.registerExpression(exprTotalExperience.class, Double.class, ExpressionType.PROPERTY, "SkillAPI total experience of %player%", "SkillAPI %player%'s total experience");
		Skript.registerExpression(exprExperience.class, Double.class, ExpressionType.PROPERTY, "SkillAPI experience of %player%", "SkillAPI %player%'s experience");
		Skript.registerExpression(exprMana.class, Double.class, ExpressionType.PROPERTY, "SkillAPI mana of %player%", "SkillAPI %player%'s mana");
		Skript.registerExpression(exprMaxLevel.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI max level of %player%", "SkillAPI %player%'s max level");
		Skript.registerExpression(exprLevel.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI level of %player%", "SkillAPI %player%'s level");
		Skript.registerExpression(exprRequiredExp.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI required exp[erience] of %player%", "SkillAPI %player%'s required exp[erience]");
		
		//Simple expressions
		Skript.registerExpression(exprDamager.class, Entity.class, ExpressionType.SIMPLE, "SkillAPI attacker");
		Skript.registerExpression(exprVictim.class, Entity.class, ExpressionType.SIMPLE, "SkillAPI Victim");
		Skript.registerExpression(exprDamage.class, Double.class, ExpressionType.SIMPLE, "SkillAPI Damage");
		Skript.registerExpression(exprExpSource.class, ExpSource.class, ExpressionType.SIMPLE, "SkillAPI ExpSource");
		Skript.registerExpression(exprExperienceGivenLost.class, Double.class, ExpressionType.SIMPLE, "SkillAPI Exp[erience] (Given|Lost)");
	}

}
