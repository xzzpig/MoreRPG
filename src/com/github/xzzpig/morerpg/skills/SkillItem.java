package com.github.xzzpig.morerpg.skills;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SkillItem {
	public static ItemStack getSkillItem(String skill){
		ItemStack item = new ItemStack(Material.FIREBALL);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("¡ì5¡ìl[Skill]"+skill);
		item.setItemMeta(im);
		return item;
	}
}
