package com.github.xzzpig.morerpg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.xzzpig.BukkitTools.TConfig;
import com.github.xzzpig.BukkitTools.TString;
import com.github.xzzpig.morerpg.Statics;
import com.github.xzzpig.morerpg.skills.SkillItem;
import com.github.xzzpig.morerpg.skills.Skiller;

public class CSkill {
	@SuppressWarnings("deprecation")
	public static boolean run(CommandSender sender,Command cmd,String label,String[] args)  {
		Player player = Bukkit.getServer().getPlayer(sender.getName());
		String arg0;
		if(args.length==0)
			arg0="help";
		else
			arg0 = args[0];
		if(arg0.equalsIgnoreCase("help")){
			player.sendMessage(TString.Prefix("MoreRPG",2)+"/skill switch [ְҵid]  -ѡ��ְҵ");	
			player.sendMessage(TString.Prefix("MoreRPG",2)+"/skill item <��������>  -��Ӽ��ܵ�����");	
			return true;
		}
		
		else if(arg0.equalsIgnoreCase("switch")){
			if(args.length != 2){
				player.sendMessage(TString.Color(2)+"ְҵ(ְҵid):");
				player.sendMessage(TString.Color(2)+"��ʿ(JS)");
				return true;
			}
			String zy = args[1];
			if(!Skiller.getSkiller(player).getZy().equalsIgnoreCase("null")){
				player.sendMessage(TString.Prefix("MoreRPG",2)+"������ְҵ:"+ Skiller.getSkiller(player).getZy());
				return true;
			}
			if(!Statics.zy.toString().contains(zy)){
				player.sendMessage(TString.Prefix("MoreRPG",2)+"�Ҳ�����ְҵ:"+zy+" ����/skill switch �鿴����");
				return true;
			}
			TConfig.saveConfig("MoreRPG","Skills.yml", player.getName()+".zy", zy);
			Skiller.resetSkiller(player);
			player.sendMessage(TString.Prefix("MoreRPG",2)+"��ѡ��ְҵ: "+ Skiller.getSkiller(player).getZy() +" �ɹ�");
			return true;
		}
		
		else if(arg0.equalsIgnoreCase("item")){
			if(args.length == 1){
				for(String skill:Skiller.getSkiller(player).getSkills()){
					player.getInventory().addItem(SkillItem.getSkillItem(skill));
				}
			}
			else if(args.length == 2){
				String arg1 = args[1];
				for(String skill:Skiller.getSkiller(player).getSkills()){
					if(skill.equalsIgnoreCase(arg1)){
						player.getInventory().addItem(SkillItem.getSkillItem(arg1));
					}
				}
			}
			else{
				return false;
			}
			player.sendMessage(TString.Prefix("MoreRPG",4)+"�ѽ�������Ʒ��������Ʒ��");
			return true;
		}
		return false;
	}
}
