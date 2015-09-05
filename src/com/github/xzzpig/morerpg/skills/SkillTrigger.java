package com.github.xzzpig.morerpg.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import com.github.xzzpig.morerpg.Vars;

public class SkillTrigger implements Listener{
	
	@EventHandler
	private void onRightClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		String action = event.getAction().name();
		if((action == "RIGHT_CLICK_AIR"||action == "RIGHT_CLICK_BLOCK")){
			if(!Vars.rightclicktimes.containsKey(player.getName()))
				Vars.rightclicktimes.put(event.getPlayer().getName(), 0);
			if(Vars.rightclicktimes.get(player.getName()) == 0){
				Vars.rightclicktimes.put(player.getName(), 1);
				new TimeReset(player.getName(), Vars.rightclicktimes, 200).start();
				if(Skiller.getSkiller(player).getSkills().size()>0)
					Skiller.getSkiller(player).runSkill(0);
			}
			else if(Vars.rightclicktimes.get(player.getName()) == 1){
				Vars.rightclicktimes.put(player.getName(), 2);
				new TimeReset(player.getName(), Vars.rightclicktimes, 500).start();
				if(Skiller.getSkiller(player).getSkills().size()>1)
					Skiller.getSkiller(player).runSkill(1);
			}
		}
	}
	
	@EventHandler
	private void onLeftClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		String action = event.getAction().name();
		if((action == "LEFT_CLICK_AIR"||action == "LEFT_CLICK_BLOCK")){
			if(!Vars.leftclicktimes.containsKey(player.getName()))
				Vars.leftclicktimes.put(event.getPlayer().getName(), 0);
			if(Vars.leftclicktimes.get(player.getName()) == 0){
				Vars.leftclicktimes.put(player.getName(), 1);
				new TimeReset(player.getName(), Vars.leftclicktimes, 200).start();
				//TODO
			}
			else if(Vars.leftclicktimes.get(player.getName()) == 1){
				Vars.leftclicktimes.put(player.getName(), 2);
				new TimeReset(player.getName(), Vars.leftclicktimes, 500).start();
				//TODO
				if(Skiller.getSkiller(player).getSkills().size()>2)
					Skiller.getSkiller(player).runSkill(2);
			}
		}
	}
	
	@EventHandler
	private void onQPush(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if(Vars.leftclicktimes.get(player.getName())==1){
			//TODO
			event.setCancelled(true);
		}
		else if(Vars.rightclicktimes.get(player.getName())==1){
			//TODO
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	private void onUseSkillItems(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		ItemStack item = player.getItemInHand();
		int hold = player.getInventory().getHeldItemSlot();
		new TimerForItem(player, item, hold).start();
	}
}
