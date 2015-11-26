package io.github.DutchyD.Registration;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;

import com.sucy.skill.api.enums.ExpSource;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import io.github.DutchyD.SkillAPI.Expressions.exprAttributePoints;
import io.github.DutchyD.SkillAPI.Expressions.exprChatColour;
import io.github.DutchyD.SkillAPI.Expressions.exprClassGroup;
import io.github.DutchyD.SkillAPI.Expressions.exprExperience;
import io.github.DutchyD.SkillAPI.Expressions.exprHealthScale;
import io.github.DutchyD.SkillAPI.Expressions.exprLevel;
import io.github.DutchyD.SkillAPI.Expressions.exprMainClass;
import io.github.DutchyD.SkillAPI.Expressions.exprMana;
import io.github.DutchyD.SkillAPI.Expressions.exprManaRegen;
import io.github.DutchyD.SkillAPI.Expressions.exprManaScale;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxHealth;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxLevel;
import io.github.DutchyD.SkillAPI.Expressions.exprMaxMana;
import io.github.DutchyD.SkillAPI.Expressions.exprRequiredExp;
import io.github.DutchyD.SkillAPI.Expressions.exprTotalExperience;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprCastedSkill;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprDamage;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprDamager;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprExpSource;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprExperienceGivenLost;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprLevelsGained;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprManaGivenLost;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprNewClassBaseHealth;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprNewClassBaseMana;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprNewClassGroup;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprNewClassName;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprPreviousClassBaseHealth;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprPreviousClassBaseMana;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprPreviousClassGroup;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprPreviousClassName;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprUnlockedSkill;
import io.github.DutchyD.SkillAPI.SimpleExpressions.exprVictim;

public class RegisterExpressions {
	
	public static void SkillAPI() {
	
		
		//Settable expressions		
		Skript.registerExpression(exprMaxMana.class, Number.class, ExpressionType.PROPERTY, "SkillAPI max mana of %player%", "SkillAPI %player%'s max mana"); // add only
		Skript.registerExpression(exprMainClass.class, String.class, ExpressionType.PROPERTY, "SkillAPI main class of %player%", "SkillAPI %player%'s main class"); // set only
		Skript.registerExpression(exprMaxHealth.class, Number.class, ExpressionType.PROPERTY, "SkillAPI max health of %player%", "SkillAPI %player%'s max health"); // add only
		Skript.registerExpression(exprAttributePoints.class, Number.class, ExpressionType.PROPERTY, "SkillAPI attribute points of %player%", "SkillAPI %player%'s attribute points"); //set and add
		
		//Non-Settable expressions
		Skript.registerExpression(exprClassGroup.class, String.class, ExpressionType.PROPERTY, "SkillAPI class group of %player%", "SkillAPI %player%'s class group");
		Skript.registerExpression(exprTotalExperience.class, Double.class, ExpressionType.PROPERTY, "SkillAPI total experience of %player%", "SkillAPI %player%'s total experience");
		Skript.registerExpression(exprExperience.class, Double.class, ExpressionType.PROPERTY, "SkillAPI experience of %player%", "SkillAPI %player%'s experience");
		Skript.registerExpression(exprMana.class, Double.class, ExpressionType.PROPERTY, "SkillAPI mana of %player%", "SkillAPI %player%'s mana");
		Skript.registerExpression(exprMaxLevel.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI max level of %player%", "SkillAPI %player%'s max level");
		Skript.registerExpression(exprLevel.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI level of %player%", "SkillAPI %player%'s level");
		Skript.registerExpression(exprRequiredExp.class, Integer.class, ExpressionType.PROPERTY, "SkillAPI required exp[erience] of %player%", "SkillAPI %player%'s required exp[erience]");
		Skript.registerExpression(exprHealthScale.class, Double.class, ExpressionType.PROPERTY, "SkillAPI health scale of %player%", "SkillAPI %player%'s health scale");
		Skript.registerExpression(exprManaScale.class, Double.class, ExpressionType.PROPERTY, "SkillAPI mana scale of %player%", "SkillAPI %player%'s mana scale");
		Skript.registerExpression(exprChatColour.class, ChatColor.class, ExpressionType.PROPERTY, "SkillAPI (chat colo[u]r|chatcolo[u]r) of %player%", "SkillAPI %player%'s (chat colo[u]r|chatcolo[u]r)");
		Skript.registerExpression(exprManaRegen.class, Double.class, ExpressionType.PROPERTY, "SkillAPI mana regen of %player%", "SkillAPI %player%'s mana regen");
		
		//Simple expressions
		Skript.registerExpression(exprDamager.class, Entity.class, ExpressionType.SIMPLE, "SkillAPI attacker");
		Skript.registerExpression(exprVictim.class, Entity.class, ExpressionType.SIMPLE, "SkillAPI victim");
		Skript.registerExpression(exprDamage.class, Double.class, ExpressionType.SIMPLE, "SkillAPI Damage done");
		Skript.registerExpression(exprExpSource.class, ExpSource.class, ExpressionType.SIMPLE, "SkillAPI ExpSource");
		Skript.registerExpression(exprExperienceGivenLost.class, Double.class, ExpressionType.SIMPLE, "SkillAPI Exp[erience] (Gained|Lost)");
		Skript.registerExpression(exprManaGivenLost.class, Double.class, ExpressionType.SIMPLE, "SkillAPI mana (gained|Lost)");
		Skript.registerExpression(exprCastedSkill.class, String.class, ExpressionType.SIMPLE, "SkillAPI skill casted");
		Skript.registerExpression(exprLevelsGained.class, Integer.class, ExpressionType.SIMPLE, "SkillAPI levels gained");
		Skript.registerExpression(exprPreviousClassBaseHealth.class, Double.class, ExpressionType.SIMPLE, "SkillAPI prev[ious] class base health");
		Skript.registerExpression(exprPreviousClassBaseMana.class, Double.class, ExpressionType.SIMPLE, "SkillAPI prev[ious] class base mana");
		Skript.registerExpression(exprPreviousClassName.class, String.class, ExpressionType.SIMPLE, "SkillAPI prev[ious] class");
		Skript.registerExpression(exprPreviousClassGroup.class, String.class, ExpressionType.SIMPLE, "SkillAPI prev[ious] class group");
		Skript.registerExpression(exprNewClassBaseHealth.class, Double.class, ExpressionType.SIMPLE, "SkillAPI new class base health");
		Skript.registerExpression(exprNewClassBaseMana.class, Double.class, ExpressionType.SIMPLE, "SkillAPI new class base mana");
		Skript.registerExpression(exprNewClassName.class, String.class, ExpressionType.SIMPLE, "SkillAPI new class");
		Skript.registerExpression(exprNewClassGroup.class, String.class, ExpressionType.SIMPLE, "SkillAPI new class group");
		Skript.registerExpression(exprUnlockedSkill.class, String.class, ExpressionType.SIMPLE, "SkillAPI unlocked skill");
	}

}
