package me.slide.afk.event;

import eu.decentsoftware.holograms.api.DHAPI;
import me.slide.afk.AfkPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void death(PlayerDeathEvent event){
        Player player = event.getPlayer();
        if(AfkPlugin.getInstance().getAfkManager().getAfkPlayers().containsKey(player.getUniqueId())){
            DHAPI.removeHologram(player.getUniqueId().toString());
        }
    }
}
