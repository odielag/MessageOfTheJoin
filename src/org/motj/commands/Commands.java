package org.motj.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.motj.Main;
import org.motj.utils.Utils;



public class Commands implements CommandExecutor  {
	private Main plugin;
	
	public Commands(Main plugin) {
		this.plugin = plugin;
				
		plugin.getCommand("motj").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//ConsoleCommands:
		
		//PlayerCommands:
		Player player = (Player)sender;
		if (player == null) {return true;}
		//Player Commands
		switch(cmd.getName().toLowerCase())
		{
			case "motj":
			{
				switch (args[0].toLowerCase())
				{
					case "test":
						if (!player.hasPermission("motj.test")) 
						{
							player.sendMessage(Utils.chat("&c You do not have permissions to execute this command."));
							return true;
						}
						player.sendMessage(Utils.chat("&a Testing MessageOfTheJoin..."));
						
						Utils.PrintFirstJoinMessage(player, plugin.getConfig().getStringList("firstJoin_message_broadcast"), plugin.getConfig().getString("firstJoin_message_personal"));

						break;
				}
				break;
			}
			
			default:
				break;
		}
		
		return true;
	}
}