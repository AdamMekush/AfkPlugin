package me.slide.afk.event;

import me.slide.afk.AfkPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void quit(PlayerQuitEvent event){
        AfkPlugin.getInstance().getAfkManager().removePlayer(event.getPlayer());
    }
}
