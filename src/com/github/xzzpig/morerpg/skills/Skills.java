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
			name = "��";
			zy = "JS";
			maxlevel = 1;
			cooldown = 1000;
			{
				lore.add("��ʿ����");
				lore.add("��һ��ʱ���ڷ���");
			}
			break;
		case "Sword_rush":
			name = "���";
			zy = "JS";
			maxlevel = 1;
			cooldown = 5000;
			{
				lore.add("��ʿ����");
				lore.add("���ٳ�����Եĵ���");
			}
			break;
		case "Sword_tread":
			name = "��̤";
			zy = "JS";
			maxlevel = 1;
			cooldown = 5000;
			{
				lore.add("��ʿ����");
				lore.add("��һ����Χ�ڵĵ�������˺�");
			}
			break;
		}
		SkillInfo info = new SkillInfo(name, lore, zy, maxlevel,cooldown);
		return info;
	}
	
	
}
