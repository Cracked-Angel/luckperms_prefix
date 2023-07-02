package dev.sklayry.prefixes.event;

import dev.sklayry.prefixes.Prefixes;
import dev.sklayry.prefixes.scoreboard.LobbyScoreboard;
import dev.sklayry.prefixes.scoreboard.Teams;
import dev.sklayry.prefixes.util.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        Teams.createTeams(player.getScoreboard());
        Bukkit.getScheduler().runTaskLater(Prefixes.getInstance(), () -> LobbyScoreboard.setScoreboard(player), 1);
        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(Prefixes.getInstance(), () -> {
            Teams.setTeams(player);
            LobbyScoreboard.update(player);
        }, 2, 10);
        Utilities.putToPlayerBukkitTaskMap(player, bukkitTask);
    }
}
