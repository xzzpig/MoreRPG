package com.github.xzzpig.morerpg;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.xzzpig.BukkitTools.TConfig;
import com.github.xzzpig.BukkitTools.TString;
import com.github.xzzpig.morerpg.skills.Skiller;
import com.github.xzzpig.morerpg.skills.Sword_defence;

public class VarsInitialise implements Listener {
	@EventHandler
	public void onLogin(PlayerLoginEvent event){
		TString.Print("已初始化");
		Vars.rightclicktimes.put(event.getPlayer().getName(), 0);
		Sword_defence.cooldown.put(event.getPlayer().getName(), 0);
		Vars.zy.put(event.getPlayer().getName(),(String)TConfig.getConfig("MoreRPG", "Skills.yml",event.getPlayer().getName()+".zy"));
		Skiller.getSkiller(event.getPlayer());
		}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		Vars.rightclicktimes.remove(event.getPlayer().getName());
		Sword_defence.cooldown.remove(event.getPlayer().getName());
	}
}
