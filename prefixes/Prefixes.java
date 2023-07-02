package dev.sklayry.prefixes;

import dev.sklayry.prefixes.event.ChatListener;
import dev.sklayry.prefixes.event.JoinListener;
import dev.sklayry.prefixes.event.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Prefixes extends JavaPlugin {
    private static Prefixes instance;

    @Override
    public void onEnable() {
        instance = this;
        registerListeners();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
    }

    public static Prefixes getInstance() {
        return instance;
    }
}


//Author CrackedAngel