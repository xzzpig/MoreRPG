package com.github.xzzpig.morerpg.skills;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TimerForItem extends Thread {
	Player player;
	ItemStack item;
	int hold;
	
	public TimerForItem(Player player,ItemStack item,int hold){
		this.player = player;
		this.item = item;
		this.hold = hold;
	}
	
	public void run(){
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ItemStack item2 = player.getItemInHand();
		if(item2.getType().equals(Material.FIREBALL)&&item2.getItemMeta().getDisplayName().startsWith("¡ì5¡ìl[Skill]")){
			player.getInventory().setHeldItemSlot(hold);
			Skiller.getSkiller(player).runSkill(item2.getItemMeta().getDisplayName().substring(11));
		}
	}
}
