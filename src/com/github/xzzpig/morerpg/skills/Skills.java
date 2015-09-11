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
	
	public static SkillInfo getSkillInfo(String skill){
		String name = null;
		String zy = null;
		int maxlevel = 0;
		List<String> lore = new ArrayList<String>();
		int cooldown = 0;
		switch(skill){
		case "Sword_defence":
			name = "格挡";
			zy = "JS";
			maxlevel = 1;
			cooldown = 1000;
			{
				lore.add("剑士技能");
				lore.add("在一定时间内防御");
			}
			break;
		case "Sword_rush":
			name = "冲刺";
			zy = "JS";
			maxlevel = 1;
			cooldown = 5000;
			{
				lore.add("剑士技能");
				lore.add("快速冲向面对的敌人");
			}
			break;
		case "Sword_tread":
			name = "践踏";
			zy = "JS";
			maxlevel = 1;
			cooldown = 5000;
			{
				lore.add("剑士技能");
				lore.add("对一定范围内的敌人造成伤害");
			}
			break;
		}
		SkillInfo info = new SkillInfo(name, lore, zy, maxlevel,cooldown);
		return info;
	}
	
	
}
