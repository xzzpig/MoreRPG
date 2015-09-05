package com.github.xzzpig.morerpg.skills;

import java.util.HashMap;

import com.github.xzzpig.BukkitTools.TEntity;


public class TimeReset extends Thread {
	
	private String name;
	private HashMap<String, Integer> var;
	private int time;
	private int setvar = 0;
	private String message="";
	
	public TimeReset(String name,HashMap<String, Integer> var,int time){
		this.name = name;
		this.var = var;
		this.time =time;
	}
	
	public TimeReset(String name,HashMap<String, Integer> var,int time,int setvar){
		this.name = name;
		this.var = var;
		this.time =time;
		this.setvar = setvar;
	}
	
	public TimeReset(String name,HashMap<String, Integer> var,int time,int setvar,String message){
		this.name = name;
		this.var = var;
		this.time =time;
		this.setvar = setvar;
		this.message = message;
	}
	
	public void run(){
		try {
			Thread.sleep(this.time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.var.put(name, setvar);
		if(message != "")
			TEntity.toPlayer(name).sendMessage(message);
	}
}
