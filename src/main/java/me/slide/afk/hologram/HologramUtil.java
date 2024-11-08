package me.slide.afk.hologram;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HologramUtil {
    public static void createHologram(UUID uuid) throws IllegalArgumentException {
        try {
            List<String> list = new ArrayList<>();
            list.add("AFK");
            Hologram hologram = DHAPI.createHologram(uuid.toString(), Bukkit.getPlayer(uuid).getLocation().add(0, 2.3, 0), list);
            hologram.showAll();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
