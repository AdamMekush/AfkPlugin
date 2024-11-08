package me.slide.afk.hologram;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import me.clip.placeholderapi.PlaceholderAPI;
import me.slide.afk.AfkPlugin;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;

public class HologramUtil {
    public static void createHologram(UUID uuid) throws IllegalArgumentException {
        try {
            List<String> list = AfkPlugin.getInstance().getConfig().getStringList("afk.title");
            list = PlaceholderAPI.setPlaceholders(Bukkit.getPlayer(uuid), list);
            Hologram hologram = DHAPI.createHologram(uuid.toString(), Bukkit.getPlayer(uuid).getLocation().add(0, 2.3, 0), list);
            hologram.showAll();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
