package dev.sklayry.prefixes.util;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class Utilities {
    private static final Map<Player, BukkitTask> playerBukkitTaskMap = new HashMap<>();

    public static void putToPlayerBukkitTaskMap(Player player, BukkitTask bukkitTask) {
        playerBukkitTaskMap.put(player, bukkitTask);
    }

    public static BukkitTask getBukkitTask(Player player) {
        return playerBukkitTaskMap.get(player);
    }

    public static Map<Player, BukkitTask> getPlayerBukkitTaskMap() {
        return playerBukkitTaskMap;
    }
}
