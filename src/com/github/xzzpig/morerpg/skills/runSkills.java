package com.github.xzzpig.morerpg.skills;

import org.bukkit.entity.Player;

public class runSkills {
	public static void run(String player,String skill){
		switch(skill){
		case "Sword_defence":
			Sword_defence.run(player);
			break;
		case "Sword_rush":
			Sword_rush.run(player);
			break;
		case "Sword_tread":
			Sword_tread.run(player);
			break;
		}
	}
	
	public static void run(Player player,String skill){
		run(player.getName(),skill);
	}
}
