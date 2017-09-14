package com.ghstudios.CustomTNT.tnt;

import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.inventory.*;
import com.ghstudios.CustomTNT.*;
import org.bukkit.plugin.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;

public abstract class TNT implements Listener
{
    private final String name;
    private final String id;
    private final HashSet<Entity> entities;
    private final HashSet<Block> blocks;
    private final ItemStack item;
    private final Material mat;
    
    protected TNT(final String name, final Material mat, final String id) {
        this(name, id, mat, new HashSet<String>());
    }
    
	protected TNT(final String name, final String id, final Material mat, final HashSet<String> lore) {
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)TNTMain.get());
        this.entities = new HashSet<Entity>();
        this.blocks = new HashSet<Block>();
        this.name = name;
        lore.add(this.id = id);
        final ItemStack item = new ItemStack(mat);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.name);
        meta.setLore((List)Arrays.asList("h", "i"));
        item.setItemMeta(meta);
        this.item = item;
        this.mat = mat;
    }
    
    protected abstract boolean onExplode(final Location p0);
    
    public final ItemStack getItem() {
        return this.item;
    }
    
    public final HashSet<Block> getBlocks() {
        return this.blocks;
    }
    
    public final HashSet<Entity> getEntities() {
        return this.entities;
    }
    
    public final void addEntity(final Entity e) {
        this.entities.add(e);
    }
    
    public final void removeBlocks(final ArrayList<Block> b) {
        this.blocks.removeAll(b);
    }
    
    @EventHandler
    public final void onBlockPlaced(final PlayerInteractEvent e) {
        if (e.getItem() == null || !e.getItem().hasItemMeta() || e.getItem().getItemMeta().getLore() != null) {}
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null && e.getItem().getType() == this.mat) {
            final List<String> lore = (List<String>)e.getItem().getItemMeta().getLore();
            if (lore == null) {
                return;
            }
            if (!lore.get(0).equals(this.id)) {
                return;
            }
            this.blocks.add(e.getClickedBlock().getRelative(e.getBlockFace()));
        }
    }
    
    public final String getName() {
        return this.name;
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public final void onExplode(final EntityExplodeEvent e) {
        if (this.entities.contains(e.getEntity())) {
            this.entities.remove(e.getEntity());
            if (this.onExplode(e.getLocation())) {
                e.getEntity().getWorld().createExplosion(e.getLocation(), 0.0f);
            }
            e.setCancelled(true);
        }
    }
    
    protected void destroyBlock(final Location location, final Material... mat) {
        final Block b = location.getBlock();
        for (final Material m : mat) {
            if (m == b.getType()) {
                breakBlock(b);
            }
        }
    }
    
    public static void breakBlock(final Block b) {
        if (b.getType() != Material.OBSIDIAN && b.getType() == Material.BEDROCK) {
            if (b.getType() == Material.MOB_SPAWNER) {
                return;
            }
            b.breakNaturally();
        }
    }
}
