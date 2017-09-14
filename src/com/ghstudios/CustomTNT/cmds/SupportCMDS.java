package com.ghstudios.CustomTNT.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SupportCMDS {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("customtnt")){
			Player player = (Player) sender;
			if (player.hasPermission("customtnt.commands.support")) {
				if (args.length == 0) {
					player.sendMessage("CustomTNT Commands" + ChatColor.DARK_PURPLE + "Give | Support | Reload | Version");
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
			}
			return true;
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "You do not have perm to run this command, Sorry :(");
		return true;
		}
	}
		return false;
	}
}














/*public abstract class SupportCMDS implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		  if (cmd.getName().equalsIgnoreCase("customtnt")) { //Check command name
		    if(args.length == 1){ //Check argument length
		      if(args[0].equalsIgnoreCase("support")){ //Check first argument
		        System.out.println(ChatColor.GREEN + "Join our discord here:" + ChatColor.GOLD + "https://discord.gg/3VWhzZP");
		        return true; // return, everything else doesn't matter anymore
		      }
		      if(args[0].equalsIgnoreCase("reload")){ //Check first argument
		    	  System.out.println(ChatColor.RED + "Coming Soon!");
			        return true; // return, everything else doesn't matter anymore
			      }
		    }
		  }
		  return false;
		}
}*/