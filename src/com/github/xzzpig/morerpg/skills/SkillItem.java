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
		im.setDisplayName("��5��l[Skill]"+skill);
		List<String> lore = new ArrayList<String>();
		lore.add(TString.Color(6)+"��������:"+info.name);
		lore.add(TString.Color(3)+"ʹ��ְҵ:"+info.zy);
		lore.add(TString.Color(3)+"���ȼ�:"+info.maxlevel);
		lore.add(TString.Color(3)+"��ȴʱ��"+((double)info.cooldown/1000)+"s");
		im.setLore(lore);
		item.setItemMeta(im);
		return item;
	}
}
