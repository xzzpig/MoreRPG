package com.github.xzzpig.morerpg.skills;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.github.xzzpig.BukkitTools.TEntity;
import com.github.xzzpig.BukkitTools.TString;
import com.github.xzzpig.morerpg.Vars;

public class Sword_defence implements Listener {
	public static HashMap<String, Boolean> allow = new HashMap<String, Boolean>();
	public static HashMap<String, Integer> cooldown = new HashMap<String, Integer>();
	public static HashMap<String, Integer> dure = new HashMap<String, Integer>();
	
	@SuppressWarnings("deprecation")
	public static void run(String player){
		int id = TEntity.toPlayer(player).getItemInHand().getTypeId();
		if(!Vars.sword_id.contains(id))
			return;				
		allow.put(player, true);
		if(!cooldown.containsKey(player))
			cooldown.put(player, 0);
		if(cooldown.containsKey(player)&&cooldown.get(player)==0){
			dure.put(player, 1);
			new TimeReset(player, dure, 500,0).start();
			cooldown.put(player, 1);
			new TimeReset(player, cooldown, 1000,0,TString.Prefix("MoreRPG")+TString.Color(4)+"技能 格挡 冷却结束").start();
		}
		else
			TEntity.toPlayer(player).sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"技能 格挡 还在冷却");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	private void onAttracted(EntityDamageByEntityEvent event) {
		if(event.getEntityType().name() !="PLAYER")
			return;
		Player player =(Player)event.getEntity();
		String name = player.getName();
		if(!allow.containsKey(player.getName()))
			allow.put(player.getName(), false);
		if(Sword_defence.allow.get(name) == false)
			return;
		else
			Sword_defence.allow.put(name, false);
		{
			int id = player.getItemInHand().getTypeId();
			if(!Vars.sword_id.contains(id))
				return;				
			if(dure.get(name) == 1){
				event.setCancelled(true);
				player.sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"技能 格挡 成功");
			}
		}
	}
}
