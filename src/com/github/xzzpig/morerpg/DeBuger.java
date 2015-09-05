package com.github.xzzpig.morerpg;

import java.util.List;

import com.github.xzzpig.BukkitTools.TString;
import com.github.xzzpig.morerpg.skills.Skills;

public class DeBuger {

	public static void main(String[] args) {
		List<String> skills = Skills.getSkills("null");
		for(String skill:skills){
			TString.Print(skill);
		}
	}

}
