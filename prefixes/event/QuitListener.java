package dev.sklayry.prefixes.event;

import dev.sklayry.prefixes.util.Utilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (Utilities.getPlayerBukkitTaskMap().containsKey(player)) {
            Utilities.getBukkitTask(player).cancel();
        }
    }
}
