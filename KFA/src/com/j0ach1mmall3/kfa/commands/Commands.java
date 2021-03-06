package com.j0ach1mmall3.kfa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.j0ach1mmall3.kfa.Main;

public class Commands implements CommandExecutor{
	private Main plugin;
	public Commands(Main plugin){
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kfa")) {
			if (sender instanceof Player){
				Player p = (Player) sender;
				if (args.length == 0) {
					p.sendMessage("�cUsage: /kfa reload");
					return true;
				} else if (args[0].equalsIgnoreCase("reload")) {
					if (!p.hasPermission("kfa.reload")) {
						String msg4 = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Noperm"));
				        msg4.replaceAll("%playerName", p.getName());
				         p.sendMessage(msg4);
						return true;
					} else {
						plugin.reloadConfig();						
						String msg5 = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Configreload"));
						p.sendMessage(msg5);
						return true;
					}
				}
			} else {
				ConsoleCommandSender c = (ConsoleCommandSender) sender;
				if (args.length == 0) {
					c.sendMessage(ChatColor.RED + "Usage: /kfa reload");
					return true;
				} else if (args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					String msg5 = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Configreload"));
					c.sendMessage(msg5);
					return true;
				}
			}
		}
		return false;
	}
}
