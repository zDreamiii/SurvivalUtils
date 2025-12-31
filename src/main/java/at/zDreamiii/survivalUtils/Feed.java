package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    private final SurvivalUtils plugin;

    public Feed(SurvivalUtils plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

       if (!player.hasPermission("survivalutils.feed")) {
           player.sendMessage(ChatColor.RED +"You don’t have permission to use this command!");
           return true;
       }

        if (plugin.getCooldownManager().isOnCooldown(player.getUniqueId(), "feed")) {
            long remaining = plugin.getCooldownManager().getRemainingTime(player.getUniqueId(), "feed");
            player.sendMessage(ChatColor.RED + "You must wait " + remaining + " seconds before using this command again!");
            return true;
       }

        player.setFoodLevel(20);
        player.setSaturation(20f);
        player.sendMessage(ChatColor.GREEN + "Your hunger has been satisfied!");

        plugin.getCooldownManager().setCooldown(player.getUniqueId(), "feed");
        return true;
    }
}