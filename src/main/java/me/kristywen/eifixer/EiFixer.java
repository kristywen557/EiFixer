package me.kristywen.eifixer;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class EiFixer extends JavaPlugin {

    public static HashMap<String, HashMap<String, Integer>> list = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("eireset").setExecutor(new FixCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
