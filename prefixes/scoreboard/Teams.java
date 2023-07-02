package dev.sklayry.prefixes.scoreboard;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Teams {

    public static void createTeams(Scoreboard scoreboard) {
        Team firstRank = scoreboard.registerNewTeam("0001");
        Team secondRank = scoreboard.registerNewTeam("0002");
        Team thirdRank = scoreboard.registerNewTeam("0003");
        Team normalRank = scoreboard.registerNewTeam("0999");
        firstRank.setPrefix("§cAdmin §7• ");
        firstRank.setColor(ChatColor.RED);
        secondRank.setPrefix("§eSupporter §7• ");
        secondRank.setColor(ChatColor.YELLOW);
        thirdRank.setPrefix("§aBuilder §7• ");
        thirdRank.setColor(ChatColor.GREEN);
        normalRank.setPrefix("§7Normal §7• ");
        normalRank.setColor(ChatColor.GRAY);
    }

    public static void setTeams(Player player) {
        LuckPerms luckPermsApi = LuckPermsProvider.get();
        Scoreboard scoreboard = player.getScoreboard();
        Bukkit.getOnlinePlayers().forEach(players -> {
            String group = luckPermsApi.getUserManager().getUser(players.getUniqueId()).getPrimaryGroup();
            switch (group.toLowerCase()) {
                case "first" -> {
                    if (!scoreboard.getTeam("0001").hasEntry(players.getName())) {
                        scoreboard.getTeam("0001").addEntry(players.getName());
                    }
                }
                case "second" -> {
                    if (!scoreboard.getTeam("0002").hasEntry(players.getName())) {
                        scoreboard.getTeam("0002").addEntry(players.getName());
                    }
                }
                case "third" -> {
                    if (!scoreboard.getTeam("0003").hasEntry(players.getName())) {
                        scoreboard.getTeam("0003").addEntry(players.getName());
                    }
                }
                default -> {
                    if (!scoreboard.getTeam("0999").hasEntry(players.getName())) {
                        scoreboard.getTeam("0999").addEntry(players.getName());
                    }
                }
            }
        });
    }
}
