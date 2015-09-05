package com.github.xzzpig.morerpg.skills;

import java.util.ArrayList;
import java.util.List;

public class Skills {
	public static String[] zys ={"null","JS"};
	public static List<String> getSkills(){
		List<String> skills = new ArrayList<String>(0);
		for(String zy:zys){
			List<String> skills2 = getSkills(zy);
			if(skills2 != null){
				for(String skill:skills2){
					skills.add(skill);
				}
			}
		}
		return skills;
	}
	public static List<String> getSkills(String zy){
		List<String> skills = new ArrayList<String>(0);
		switch(zy){
		case "null":
			skills.add("null");
			break;
		case "JS":
			skills.add("Sword_defence");
			skills.add("Sword_rush");
			skills.add("Sword_tread");
			break;
		}
		return skills;
	}
	
	
}
