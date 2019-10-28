package org.motj.listeners;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.motj.Main;
import org.motj.utils.Utils;
public class Listeners implements Listener {

	private Main plugin;
	
	public List<String> broadcastMessages;
	public String firstJoinMessage;
	
	public Listeners(Main plugin)
	{
		this.plugin = plugin;
		
		broadcastMessages = plugin.getConfig().getStringList("firstJoin_message_broadcast");
		firstJoinMessage = plugin.getConfig().getString("firstJoin_message_personal");
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		if (!player.hasPlayedBefore())
		{			
			Utils.PrintFirstJoinMessage(player, broadcastMessages, firstJoinMessage);
		}
	}
	
	
}
