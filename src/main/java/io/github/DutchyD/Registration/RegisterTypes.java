package io.github.DutchyD.Registration;

import javax.annotation.Nullable;

import com.sucy.skill.api.enums.ExpSource;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;

public class RegisterTypes {
	
	public static void SkillAPI() {
		
			Classes.registerClass(new ClassInfo<ExpSource>(ExpSource.class, "expsource").parser(new Parser<ExpSource>() { 
				
				@Override
				@Nullable
				public ExpSource parse(String s, ParseContext context) {
					try {
						
						return ExpSource.valueOf( s.replace(" ", "_").trim().toUpperCase());
						
					} catch (IllegalArgumentException ex) {
						
						return null;
					}
				}
				
				@Override
				public String toVariableNameString(ExpSource expsource) {
						
					return expsource.name().toLowerCase();
				}
				
				@Override
				public String toString(ExpSource expsource, int flags) {
					
					return expsource.name().toLowerCase();
				}
				
				@Override
				public String getVariableNamePattern() {
					return ".+";
				}
			}));
	}
}
