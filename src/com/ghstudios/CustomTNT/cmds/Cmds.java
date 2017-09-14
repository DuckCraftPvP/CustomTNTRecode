package com.ghstudios.CustomTNT.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ghstudios.CustomTNT.TNTMain;
import com.ghstudios.CustomTNT.tnt.TNT;

public class Cmds implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("customtnt")) {
			Player player = (Player) sender;
			if (player.hasPermission("customtnt.commands.support")) {
				if (args.length == 0) {
					player.sendMessage(
							"CustomTNT Commands" + ChatColor.DARK_PURPLE + "Give | Support | Reload | Version");
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("support")) {
						player.sendMessage(ChatColor.GREEN + "Join our discord here" + ChatColor.WHITE + ":" + ChatColor.GOLD + "https://discord.gg/3VWhzZP");
					}
				} else if (args.length == 2) {
					if (args[1].equalsIgnoreCase("reload")) {
						player.sendMessage("This command is not added yet. | Reload");
					}
				} else if (args.length == 3) {
					if (args[2].equalsIgnoreCase("version")) {
						player.sendMessage("This command is not added yet. | version");
					}
				} else if (args.length == 4) {
					if (args[3].equalsIgnoreCase("give")) {
						player.sendMessage("Usage: /CustomTNT give <player> <level> [amount]");
						final Player p = Bukkit.getPlayer(args[4]);
						if (p == null) {
							player.sendMessage("Error: Player not found");
							return true;
						}
						final int level = Integer.parseInt(args[5]);
						if (level < 1 || level > TNTMain.get().tnt.size()) {
							player.sendMessage("Error: Invalid level");
							return true;
						}
						final int amount = (args.length > 4) ? Integer.parseInt(args[6]) : 1;
						if (amount < 1) {
							player.sendMessage("Error: Invalid Amount");
							return true;
						}
						final TNT tnt = TNTMain.get().tnt.get(level - 1);
						p.getInventory().addItem(new ItemStack[] { tnt.getItem() });
						p.updateInventory();
						player.sendMessage(ChatColor.GREEN + "CustomTNT" + ChatColor.WHITE + ":" + ChatColor.GOLD + "Gave" + amount + " " + tnt.getName() + " to " + p.getDisplayName());
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.DARK_RED + "You do not have perm to run this command, Sorry :(");
				}
			}
		}
		return false;
	}
}