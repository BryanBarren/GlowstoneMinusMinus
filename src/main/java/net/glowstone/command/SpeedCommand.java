package net.glowstone.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

/**
 * For running or flying extremely fast! Doesn't quite work yet.
 */
public class SpeedCommand extends BukkitCommand {

    public SpeedCommand() {
        super("speed");
        this.description = "Change the speed at which you run and fly! --Doesn't quite work yet.";
        this.usageMessage = "/speed <1|2|3|4|5> ...";
        this.setPermission("glowstone.command.speed");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!testPermission(sender)) return true;
        if (args.length < 0) {
            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
            return false;
        }
        Player p = (Player) sender;
        if (SpeedCommand.super.isRegistered()); {
            switch (args[0].toLowerCase()) {
                case "1":
                    p.setWalkSpeed(0.2F);
                    p.setFlySpeed(0.2F);
                    p.sendMessage("Set your Speed to 1!");
                    return true;
                case "2":
                    p.setWalkSpeed(0.3F);
                    p.setFlySpeed(0.3F);
                    p.sendMessage("Set your Speed to 2!");
                    return true;
                case "3":
                    p.setWalkSpeed(0.4F);
                    p.setFlySpeed(0.4F);
                    p.sendMessage("Set your Speed to 3!");
                    return true;
                case "4":
                    p.setWalkSpeed(0.5F);
                    p.setFlySpeed(0.5F);
                    p.sendMessage("Set your Speed to 4!");
                    return true;
                case "5":
                    p.setWalkSpeed(0.6F);
                    p.setFlySpeed(0.6F);
                    p.sendMessage("Set your Speed to 5!");
                    return true;
                case "-1":
                    p.setWalkSpeed(0.1F);
                    p.setFlySpeed(0.1F);
                    p.sendMessage("Set your Speed to" + ChatColor.MAGIC + " -1SuperCrazySlow mode!");
                    return true;
                default:
                    p.sendMessage(ChatColor.RED + "You have specified an invalid Speed!");
                    return true;
            }
        }
    }
}
