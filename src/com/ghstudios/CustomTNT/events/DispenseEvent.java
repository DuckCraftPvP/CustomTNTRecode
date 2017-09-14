package com.ghstudios.CustomTNT.events;

import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class DispenseEvent
{
    @EventHandler
    private void blockDispenseEvent(final BlockDispenseEvent event) {
        event.getBlock().getType().equals((Object)Material.DISPENSER);
    }
}
