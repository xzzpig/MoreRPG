package com.github.xzzpig.morerpg.skills;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.github.xzzpig.BukkitTools.TConfig;
import com.github.xzzpig.BukkitTools.TPlayer;

public class Skiller {
	private static HashMap<Player, Skiller> skillers = new HashMap<Player, Skiller>();
	private Player player;
	private String zy;
	private List<String> skills;
	private int exp;
	private int level;
	public Skiller(Player player){
		this.player = player;
		this.zy = (String)TConfig.getConfig("MoreRPG", "Skills.yml",player.getName()+".zy");
		if(this.zy == null)
			this.zy = "null";
		this.skills = Skills.getSkills(this.zy);
		this.exp =(int)TConfig.getConfig("MoreRPG", "Skills.yml",player.getName()+".exp");
		this.level = TPlayer.ExpToLevel(exp);
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
	public int getExp() {
		return exp;
	}
	public void setExp(int amount) {
		this.exp = amount;
		this.level = TPlayer.ExpToLevel(amount);
		TConfig.saveConfig("MoreRPG","Skills.yml", player.getName()+".exp", exp);
	}
	public void addExp(int amount){
		setExp(getExp()+amount);
	}
	public int getLevel() {
		return level;
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
		if(skillid >= skills.size())
			return;
		runSkills.run(player, skills.get(skillid));
	}
}
