package com.ghstudios.CustomTNT;

import org.bukkit.plugin.java.*;
import com.ghstudios.CustomTNT.tnt.*;
import com.ghstudios.CustomTNT.tnt.type.*;
import org.bukkit.scheduler.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import com.ghstudios.CustomTNT.cmds.*;
import org.bukkit.command.*;

public class TNTMain extends JavaPlugin
{
    private static TNTMain instance;
    public ArrayList<TNT> tnt;
    
    public void onEnable() {
        TNTMain.instance = this;
        (this.tnt = new ArrayList<TNT>()).add(new FunTNT("name", "id"));
        this.tnt.add(new GiganticTNT("name", "id"));
        new BukkitRunnable() {
            private Object b;
            
            public void run() {
                final ArrayList<Block> remove = new ArrayList<Block>();
                for (final TNT t : TNTMain.this.tnt) {
                    final Iterator<?> localIterator2 = t.getBlocks().iterator();
                    while (localIterator2.hasNext()) {
                        this.b = localIterator2.next();
                        for (final Entity e : ((Block)this.b).getWorld().getEntities()) {
                            if (e.getType() == EntityType.PRIMED_TNT && e.getLocation().distance(((Block)this.b).getLocation()) <= 1.0 && !t.getEntities().contains(e)) {
                                t.addEntity(e);
                                remove.add((Block)this.b);
                            }
                        }
                    }
                    t.removeBlocks(remove);
                }
            }
        }.runTaskTimer((Plugin)this, 0L, 1L);
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "     ____ _  _ ____ ___ ____ _  _    ___ _  _ ___                 ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "     |    |  | [__   |  |  | || |     |  || |  |                  ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "     |___ |__| ___]  |  |__| | ||     |  | ||  |                  ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "                                                                  ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "                                                                  ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "   *-----------------------------------------------*              ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "                                                                  ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Spigot Link: https://www.spigotmc.org/resources/customtnt.25728/ ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Contact DuckCraftPvP On SpigotMC for support!                    ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Check out our custom server: DuckCraftPvP.com                    ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Made by: GHStudios                                               ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "                                                                  ");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "______________________________________________________________    ");
        System.out.println(" ");
        if (this.getConfig().getString("GiganticTNTName") == null) {
            this.getConfig().set("GiganticTNTName", (Object)"GiganticTNT");
            System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Adding Gigantic TNT Name Config Option");
            this.saveConfig();
        }
        if (this.getConfig().getString("GiganticTNTRadius") == null) {
            this.getConfig().set("GiganticTNTRadius", (Object)3);
            System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Adding Gigantic TNT Radius Config Option");
            this.saveConfig();
        }
        if (this.getConfig().getString("GiganticTNTLoreLine1") == null) {
            this.getConfig().set("GiganticTNTLoreLine1", (Object)"Line 1 Lore");
            System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Adding Gigantic TNT LoreLine1 Config Option");
            this.saveConfig();
        }
        if (this.getConfig().getString("GiganticTNTLoreLine2") == null) {
            this.getConfig().set("GiganticTNTLoreLine2", (Object)"Line 2 Lore");
            System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Adding Gigantic TNT LoreLine2 Config Option");
            this.saveConfig();
            System.out.println("");
            System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + "______________________________________________________________    ");
        }
        this.getCommand("CustomTNT").setExecutor((CommandExecutor)new Cmds());
    }
    
    public void onDisable() {
        TNTMain.instance = null;
        this.saveConfig();
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " CustomTNT has been Disabled!");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Made by: GHStudios");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Check out our custom server: DuckCraftPvP.com");
    }
    
    public static TNTMain get() {
        return TNTMain.instance;
    }
}
