package org.motj;

import org.bukkit.plugin.java.JavaPlugin;
import org.motj.commands.Commands;
import org.motj.listeners.Listeners;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new Listeners(this);
		new Commands(this);
		
	}
	@Override
	public void onDisable() {
		
	}
}
