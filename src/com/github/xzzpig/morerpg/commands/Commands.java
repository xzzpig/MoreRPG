package com.github.xzzpig.morerpg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.xzzpig.BukkitTools.TString;

public class Commands {
	@SuppressWarnings("deprecation")
	public static boolean command(CommandSender sender,Command cmd,String label,String[] args)  {
		Player player = Bukkit.getServer().getPlayer(sender.getName());
		if(label.equalsIgnoreCase("morerpg")||label.equalsIgnoreCase("mr")){
			player.sendMessage(TString.Prefix("MoreRPG",2)+"/skill  -查看技能帮助");
			return true;
		}
		if(label.equalsIgnoreCase("skill")){
			return CSkill.run(sender, cmd, label, args);
		}
		return false;
	}
}
