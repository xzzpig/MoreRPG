package com.github.xzzpig.morerpg;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.github.xzzpig.BukkitTools.TEntity;
import com.github.xzzpig.BukkitTools.TString;

public class Monster implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void onZombieDamage(EntityDamageEvent event){
		
		if(!Vars.moremonster_monster.contains(event.getEntityType().getName())){
			return;
		}
		if(event.getCause().name() != "ENTITY_ATTACK"){
			return;
		}
		for(int x = 0;x < (int)(event.getDamage()/2);x++){
			int random =(int)(Math.random()*100);
			if(random < Vars.moremonster_chance){
				Location loc = event.getEntity().getLocation();
				World world = loc.getWorld();
				int zn=0;
				for(Entity entity:event.getEntity().getNearbyEntities(10, 10, 10)){
					if(entity.getType().name().equalsIgnoreCase(event.getEntityType().getName())){
						zn=zn+1;
					}
				}
				if(zn>Vars.moremonster_max){
					for(Player player:TEntity.getNearPlayer(event.getEntity(), 10, 10, 10)){
						player.sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+event.getEntityType().getName()+"数量已达上限("+Vars.moremonster_max+")");
					}
					return;
				}
				else{
					//world.spawn(loc, Zombie.class);
					world.spawnEntity(loc, EntityType.fromName(event.getEntityType().getName()));
					for(Player player:TEntity.getNearPlayer(event.getEntity(), 10, 10, 10)){
						player.sendMessage(TString.Prefix("MoreRPG")+TString.Color(4)+"新的"+event.getEntityType().getName()+"已生成!");
					}
					return;
				}
			}
		}
	}
}
