package com.github.xzzpig.morerpg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.xzzpig.morerpg.commands.Commands;
import com.github.xzzpig.morerpg.skills.SkillTrigger;
import com.github.xzzpig.morerpg.skills.Sword_defence;
import com.github.xzzpig.morerpg.skills.Sword_tread;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
	getLogger().info(getName()+"插件已被加载");
	getServer().getPluginManager().registerEvents(new Monster(), this);
	getServer().getPluginManager().registerEvents(new SkillTrigger(), this);
	getServer().getPluginManager().registerEvents(new VarsInitialise(), this);
	getServer().getPluginManager().registerEvents(new Sword_defence(), this);
	getServer().getPluginManager().registerEvents(new Sword_tread(), this);	
	saveDefaultConfig();
	getConfigs();
	}
	
	//插件停用函数
	@Override
	public void onDisable() {
	getLogger().info(getName()+"插件已被停用 ");
	}
	
	private void getConfigs(){
		Vars.moremonster_monster = this.getConfig().getStringList("moremonster.monster");
		Vars.moremonster_chance = this.getConfig().getInt("moremonster.chance", 10);
		Vars.moremonster_max = this.getConfig().getInt("moremonster.max", 10);
		Vars.sword_id = this.getConfig().getIntegerList("skill.sword.id");
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args)  {
		return Commands.command(sender, cmd, label, args);
	}
}
