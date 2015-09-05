package com.github.xzzpig.morerpg.skills;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.github.xzzpig.BukkitTools.TConfig;

public class Skiller {
	private static HashMap<Player, Skiller> skillers = new HashMap<Player, Skiller>();
	private Player player;
	private String zy;
	private List<String> skills;
	public Skiller(Player player){
		this.player = player;
		this.zy = (String)TConfig.getConfig("MoreRPG", "Skills.yml",player.getName()+".zy");
		if(this.zy == null)
			this.zy = "null";
		this.skills = Skills.getSkills(this.zy);
	}
	
	public static Skiller getSkiller(Player player) {
		setSkiller(player);
		return skillers.get(player);
	}
	private static void setSkiller(Player player) {
		if(skillers.containsKey(player)){
			return;
		}
		skillers.put(player,new Skiller(player));
	}
	public static void resetSkiller(Player player) {
		if(skillers.containsKey(player)){
			skillers.remove(player);
		}
		setSkiller(player);
	}

	public Player getPlayer() {
		return player;
	}
	public String getZy() {
		return zy;
	}
	public List<String> getSkills() {
		return skills;
	}
	
	
	
	public void runSkill(String skill){
		if(skills.contains(skill)){
			runSkills.run(player, skill);
			return;
		}
	}
	public void runSkill(int skillid){
		runSkills.run(player, skills.get(skillid));
	}
}
