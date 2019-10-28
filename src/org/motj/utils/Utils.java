package org.motj.utils;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static void PrintFirstJoinMessage(Player player, List<String> broadcastMessages, String firstJoinMessage)
	{
		//Select random message from config list.
		Random rand = new Random();
		String randomMsg = broadcastMessages.get(rand.nextInt(broadcastMessages.size())).replace("<player>", player.getName());
		//Broadcast Random Message
		Bukkit.broadcastMessage(Utils.chat(randomMsg));
		
		//Send player First join Message
		String replacedfirstJoinMessage = firstJoinMessage.replace("<player>", player.getName());
		player.sendMessage(Utils.chat(replacedfirstJoinMessage));
	}
}
