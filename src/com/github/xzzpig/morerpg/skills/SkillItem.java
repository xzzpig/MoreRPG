package com.github.xzzpig.morerpg.skills;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.xzzpig.BukkitTools.TString;

public class SkillItem {
	public static ItemStack getSkillItem(String skill){
		ItemStack item = new ItemStack(Material.FIREBALL);
		ItemMeta im = item.getItemMeta();
		SkillInfo info = Skills.getSkillInfo(skill);
		im.setDisplayName("§5§l[Skill]"+skill);
		List<String> lore = new ArrayList<String>();
		lore.add(TString.Color(6)+"技能名称:"+info.name);
		lore.add(TString.Color(3)+"使用职业:"+info.zy);
		lore.add(TString.Color(3)+"最大等级:"+info.maxlevel);
		lore.add(TString.Color(3)+"冷却时间"+((double)info.cooldown/1000)+"s");
		im.setLore(lore);
		item.setItemMeta(im);
		return item;
	}
}
