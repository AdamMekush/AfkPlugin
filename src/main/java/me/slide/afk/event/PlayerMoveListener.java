package me.slide.afk.event;

import eu.decentsoftware.holograms.api.DHAPI;
import me.slide.afk.AfkPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void move(PlayerMoveEvent event){
        if(AfkPlugin.getInstance().getAfkManager().getAfkPlayers().containsKey(event.getPlayer().getUniqueId())){
            DHAPI.removeHologram(event.getPlayer().getUniqueId().toString());
        }
        AfkPlugin.getInstance().getAfkManager().setPlayerLastTick(event.getPlayer());
    }
}
