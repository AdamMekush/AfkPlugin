package me.slide.afk.ticker;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import me.slide.afk.AfkPlugin;
import me.slide.afk.AfkManager;
import me.slide.afk.hologram.HologramUtil;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StatusTicker extends BukkitRunnable {
    @Override
    public void run() {
        AfkManager afkManager = AfkPlugin.getInstance().getAfkManager();
        afkManager.getAfkPlayers().forEach(((uuid, aLong) -> {
            if(AfkPlugin.getInstance().getServer().getPlayer(uuid).getHealth() > 0){
                try {
                    Hologram hologram = DHAPI.getHologram(uuid.toString());
                    DHAPI.moveHologram(hologram, Bukkit.getPlayer(uuid).getLocation().add(0, 2.6, 0));
                } catch (IllegalArgumentException e) {
                    HologramUtil.createHologram(uuid);
                }
            }
        }));
    }
}
