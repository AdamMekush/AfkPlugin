package me.slide.afk.event;

import me.slide.afk.AfkPlugin;
import me.slide.afk.hologram.HologramUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
    @EventHandler
    public void respawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        if(AfkPlugin.getInstance().getAfkManager().getAfkPlayers().containsKey(player.getUniqueId())){
            HologramUtil.createHologram(player.getUniqueId());
        }
    }
}
