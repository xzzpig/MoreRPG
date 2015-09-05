package com.github.xzzpig.morerpg.skills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.xzzpig.BukkitTools.TEntity;
import com.github.xzzpig.BukkitTools.TString;
import com.github.xzzpig.morerpg.Vars;

public class Sword_tread implements Listener {
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
			new TimeReset(player, cooldown, 5000,0,TString.Prefix("MoreRPG")+TString.Color(4)+"技能 践踏 冷却结束").start();
			tread(TEntity.toPlayer(player));
		}
		else
			TEntity.toPlayer(player).sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"技能 践踏  还在冷却");
	}
	@SuppressWarnings("deprecation")
	private static void tread(Player player){
		ItemStack is = player.getItemInHand();
		int id = is.getTypeId();
		if(!Vars.sword_id.contains(id))
			return;
		List<String> lore = is.getItemMeta().getLore();
		double damage = 0;
		if(lore != null){
			for(String temp:lore){
				if(temp.startsWith("[Damage]:"))
					damage = Double.valueOf(temp.substring(9));
			}
		}
		List<Entity> entitys = player.getNearbyEntities(5, 2, 5);
		for(Entity entity:entitys){
			if (entity instanceof LivingEntity){
				LivingEntity le = (LivingEntity) entity;
				le.damage(damage,player);				
			}
		}
		player.sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"技能 践踏 使用成功");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	private void onAttracted(EntityDamageByEntityEvent event) {
		if(event.getDamager().getType().name() !="PLAYER")
			return;
		Player player = (Player) event.getDamager();
		ItemStack is = player.getItemInHand();
		double damage = event.getDamage();
		int id = is.getTypeId();
		if(!Vars.sword_id.contains(id))
			return;
		List<String> lore = is.getItemMeta().getLore();
		ItemMeta im = is.getItemMeta();
		if(lore != null){
			for(String temp:lore){
				if(temp.startsWith("[Damage]:"))
					return;
			}
			lore.add("[Damage]:"+damage);
			im.setLore(lore);
			is.setItemMeta(im);
		}
		else{
			List<String> temp = new ArrayList<String>();
			temp.add("[Damage]:"+damage);
			im.setLore(temp);
			is.setItemMeta(im);
		}
	}
}
