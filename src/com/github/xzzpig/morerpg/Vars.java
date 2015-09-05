package com.github.xzzpig.morerpg;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.github.xzzpig.morerpg.skills.Skiller;

public class Vars {
	public static List<String> moremonster_monster;
	public static int moremonster_chance;
	public static int moremonster_max;
	public static HashMap<String, Integer> cooldown = new HashMap<String, Integer>();
	public static List<Integer> sword_id;
	public static HashMap<String, Integer> rightclicktimes = new HashMap<String, Integer>();
	public static HashMap<String, Integer> leftclicktimes = new HashMap<String, Integer>();
	public static HashMap<String, String> zy = new HashMap<String, String>();
	public static HashMap<Player, Skiller> skillers = new HashMap<Player, Skiller>();
}
