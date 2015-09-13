package com.github.xzzpig.morerpg.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SkillerExp implements Listener{
	@EventHandler
	private void onConfigPlayer(EntityDeathEvent event) {
		Player player = event.getEntity().getKiller();
		int amount = event.getDroppedExp();
		Skiller.getSkiller(player).addExp(amount);
	}
	
	public void toLevel(int exp){
		
	}
}