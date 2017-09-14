package com.ghstudios.CustomTNT;

import org.bukkit.plugin.java.*;
import com.ghstudios.CustomTNT.tnt.*;
import com.ghstudios.CustomTNT.tnt.type.*;
import org.bukkit.scheduler.*;
import org.fusesource.jansi.Ansi;
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
    	this.getConfig();
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
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "     ____ _  _ ____ ___ ____ _  _    ___ _  _ ___                 " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "     |    |  | [__   |  |  | || |     |  || |  |                  " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "     |___ |__| ___]  |  |__| | ||     |  | ||  |                  " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "                                                                  " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "                                                                  " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "   *-----------------------------------------------*              " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "                                                                  " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Spigot Link: https://www.spigotmc.org/resources/customtnt.25728/ " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Contact DuckCraftPvP On SpigotMC for support!                    " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Check out our custom server: DuckCraftPvP.com                    " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Made by: GHStudios                                               " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "                                                                  " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "______________________________________________________________    " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        System.out.println(" ");
        if (this.getConfig().getString("GiganticTNTName") == null) {
            this.getConfig().set("GiganticTNTName", (Object)"GiganticTNT");
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Adding Gigantic TNT Name Config Option" + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
            this.saveConfig();
        }
        if (this.getConfig().getString("GiganticTNTRadius") == null) {
            this.getConfig().set("GiganticTNTRadius", (Object)3);
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Adding Gigantic TNT Radius Config Option" + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
            this.saveConfig();
        }
        if (this.getConfig().getString("GiganticTNTLoreLine1") == null) {
            this.getConfig().set("GiganticTNTLoreLine1", (Object)"Line 1 Lore");
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Adding Gigantic TNT LoreLine1 Config Option" + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
            this.saveConfig();
        }
        if (this.getConfig().getString("GiganticTNTLoreLine2") == null) {
            this.getConfig().set("GiganticTNTLoreLine2", (Object)"Line 2 Lore");
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Adding Gigantic TNT LoreLine2 Config Option" + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
            this.saveConfig();
        }
        if (this.getConfig().getString("Version") == null) {
            this.getConfig().set("Version", (Object)1.0);
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Adding Version Config Option, Do not edit" + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
            this.saveConfig();
        }
        if (this.getConfig().getString("Update-Date") == null) {
            this.getConfig().set("Update-Date", (Object)"14|09|2017");
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + " Adding Date Config Option, Do not edit" + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
            this.saveConfig();
            System.out.println("");
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff().toString() + "[CustomTNTRecoded]" + Ansi.ansi().fg(Ansi.Color.YELLOW).boldOff().toString() + "______________________________________________________________    " + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString() + " ");
        }
        this.getCommand("CustomTNT").setExecutor((CommandExecutor)new Cmds());
    }
    
    public void onDisable() {
        TNTMain.instance = null;
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " CustomTNT has been Disabled!");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Made by: GHStudios");
        System.out.println(ChatColor.GREEN + "[CustomTNTRecoded]" + ChatColor.YELLOW + " Check out our custom server: DuckCraftPvP.com");
    }
    
    public static TNTMain get() {
        return TNTMain.instance;
    }
}
