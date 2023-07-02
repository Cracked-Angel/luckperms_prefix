package dev.sklayry.prefixes.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class LobbyScoreboard {

    public static void setScoreboard(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.registerNewObjective("display", "dummy", "  §dPersonal Scoreboard  ");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team rank = scoreboard.registerNewTeam("rank");
        rank.setPrefix("§cSearching...");
        rank.addEntry(ChatColor.BLACK.toString());

        objective.getScore("§6 §6").setScore(4);
        objective.getScore("§dRank:").setScore(3);
        objective.getScore(ChatColor.BLACK.toString()).setScore(2);
        objective.getScore("§2 §2").setScore(1);
        objective.getScore("§eexample.net").setScore(0);
    }

    public static void update(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team rank = scoreboard.getTeam("rank");
        if (rank == null) rank = scoreboard.registerNewTeam("rank");
        rank.setPrefix("     "+scoreboard.getEntryTeam(player.getName()).getPrefix().split(" ")[0]);
    }
}
