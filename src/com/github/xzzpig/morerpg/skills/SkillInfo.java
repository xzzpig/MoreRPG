package com.github.xzzpig.morerpg.skills;

import java.util.ArrayList;
import java.util.List;

public class SkillInfo {
	public String name = "null";
	public List<String> lore = new ArrayList<String>();
	public String zy = "null";
	public int maxlevel = 1;
	public int cooldown = 0;
	public SkillInfo(String name,List<String> lore,String zy,int maxlevel,int cooldown){
		this.name = name;
		this.lore = lore;
		this.zy = zy;
		this.maxlevel = maxlevel;
		this.cooldown = cooldown;
	}
	public SkillInfo() {
	}
}
