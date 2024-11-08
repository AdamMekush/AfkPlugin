package me.slide.afk;

import me.slide.afk.event.*;
import me.slide.afk.ticker.StatusTicker;
import org.bukkit.plugin.java.JavaPlugin;

public final class AfkPlugin extends JavaPlugin {
    private AfkManager afkManager;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        afkManager = new AfkManager();

        StatusTicker statusTicker = new StatusTicker();
        statusTicker.runTaskTimerAsynchronously(this, 0, 1);
    }

    @Override
    public void onDisable() {

    }

    public static AfkPlugin getInstance(){
        return getPlugin(AfkPlugin.class);
    }

    public AfkManager getAfkManager() {
        return afkManager;
    }
}
