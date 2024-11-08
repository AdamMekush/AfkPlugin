package me.slide.afk.event;

import me.slide.afk.AfkPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void move(PlayerJoinEvent event){
        AfkPlugin.getInstance().getAfkManager().addPlayer(event.getPlayer());
    }
}
