package dev.sklayry.prefixes.event;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Scoreboard scoreboard = player.getScoreboard();
        LuckPerms luckPermsApi = LuckPermsProvider.get();
        User user = luckPermsApi.getUserManager().getUser(player.getUniqueId());
        Group group = luckPermsApi.getGroupManager().getGroup(user.getPrimaryGroup());
        String displayName = group.getDisplayName();
        String message = event.getMessage().replace("%", "%%");
        event.setFormat(displayName + " §7• " + scoreboard.getEntryTeam(player.getName()).getColor() + player.getName() + " §8» §r" + message);

    }
}


//