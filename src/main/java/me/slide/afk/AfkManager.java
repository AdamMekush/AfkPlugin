package me.slide.afk;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class AfkManager {
    private final Map<UUID, Long> lastActions;

    public AfkManager(){
        lastActions = new HashMap<>();
    }

    public void addPlayer(Player player){
        addPlayer(player.getUniqueId());
    }

    public void addPlayer(UUID uuid){
        lastActions.put(uuid, System.currentTimeMillis());
    }

    public void removePlayer(Player player){
        removePlayer(player.getUniqueId());
    }

    public void removePlayer(UUID uuid){
        lastActions.remove(uuid);
    }

    public void setPlayerLastTick(Player player){
        setPlayerLastTick(player.getUniqueId());
    }

    public void setPlayerLastTick(UUID uuid){
        lastActions.replace(uuid, System.currentTimeMillis());
    }

    public Map<UUID, Long> getAfkPlayers(){
        return lastActions.entrySet().stream().filter(entry -> entry.getValue() + AfkPlugin.getInstance().getConfig().getLong("afk.timeout") < System.currentTimeMillis()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
