package net.glowstone.command;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import java.util.Objects;

/**
 * For broadcasting server-wide messages!
 */
public class CommandBroadcast extends BukkitCommand {

    public CommandBroadcast() {
        super("broadcast");
        this.description = "Broadcast server-wide messages!";
        this.usageMessage = "/broadcast <message> ...";
        this.setPermission("glowstone.command.broadcast");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!testPermission(sender)) return true;
        if (args.length < 0) {
            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
            return false;
        }
        String msg = "";
        for (String part : args) {
            if (!Objects.equals(msg, "")) msg += " ";
            msg += part;
        }

        if (!(sender instanceof Player)) {
            Bukkit.broadcastMessage("[Console]: " + msg);
            return true;
        }
        if (CommandBroadcast.super.isRegistered()) {
            Bukkit.broadcastMessage(ChatColor.GRAY + " [" + ChatColor.BLUE + "Announcement" + ChatColor.GRAY + "] " + ChatColor.translateAlternateColorCodes('&', msg));
            for (Player playerNotified : Bukkit.getServer().getOnlinePlayers()) {
                playerNotified.playSound(playerNotified.getLocation(), Sound.NOTE_PIANO, 100, 100);
            }
            return true;
        }
        return true;
    }
}
