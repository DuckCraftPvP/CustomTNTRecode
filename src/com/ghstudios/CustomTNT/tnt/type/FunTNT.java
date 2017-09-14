package com.ghstudios.CustomTNT.tnt.type;

import com.ghstudios.CustomTNT.tnt.*;
import org.bukkit.event.*;
import org.bukkit.*;
import com.ghstudios.CustomTNT.*;

public class FunTNT extends TNT implements Listener
{
    public FunTNT(final String name, final String id) {
        super(name, Material.TNT, id);
    }
    
    @Override
    protected boolean onExplode(final Location location) {
        if (location.getBlock().getType() == Material.STATIONARY_WATER) {
            return true;
        }
        int x;
        for (int radius = x = TNTMain.get().getConfig().getInt("GiganticTNTRadius"); x <= radius; ++x) {
            for (int y = -radius; y <= radius; ++y) {
                for (int z = -radius; z <= radius; ++z) {
                    this.destroyBlock(location.clone().add((double)x, (double)y, (double)z));
                }
            }
        }
        return true;
    }
    
    public void destroyBlock(final Location location) {
        TNT.breakBlock(location.getBlock());
    }
}
