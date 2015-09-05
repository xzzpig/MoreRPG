package com.github.xzzpig.morerpg.skills;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.github.xzzpig.BukkitTools.TEntity;
import com.github.xzzpig.BukkitTools.TString;
import com.github.xzzpig.morerpg.Vars;

public class Sword_rush {
	public static HashMap<String, Integer> cooldown = new HashMap<String, Integer>();
	
	@SuppressWarnings("deprecation")
	public static void run(String player){
		int id = TEntity.toPlayer(player).getItemInHand().getTypeId();
		if(!Vars.sword_id.contains(id))
			return;
		if(!cooldown.containsKey(player))
			cooldown.put(player, 0);
		if(cooldown.get(player)==0){
			cooldown.put(player, 1);
			new TimeReset(player, cooldown, 5000,0,TString.Prefix("MoreRPG")+TString.Color(4)+"技能 冲刺 冷却结束").start();
			rush(TEntity.toPlayer(player));
		}
		else
			TEntity.toPlayer(player).sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"技能 冲刺  还在冷却");
	}
	private static void rush(Player player){
		//TEntity.getTarget(player).getLocation();
		Location targetloc = TEntity.getTarget(player).getLocation();
		player.teleport(targetloc);
		if(targetloc == player.getLocation()){
			player.sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"未找到目标");
			cooldown.put(player.getName(), 0);
		}
		else
			player.sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"已使用技能 冲刺");
	}
}
