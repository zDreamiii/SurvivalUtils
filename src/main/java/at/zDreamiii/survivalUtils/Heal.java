package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    private final SurvivalUtils plugin;

    public Heal(SurvivalUtils plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("survivalutils.heal")) {
            player.sendMessage(ChatColor.RED +"You don’t have permission to use this command!");
            return true;
        }

        if (plugin.getCooldownManager().isOnCooldown(player.getUniqueId(), "heal")) {
            long remaining = plugin.getCooldownManager().getRemainingTime(player.getUniqueId(), "heal");
            player.sendMessage(ChatColor.RED + "You must wait " + remaining + " seconds before using this command again!");
            return true;

        }

        double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        player.setHealth(maxHealth);
        player.sendMessage(ChatColor.GREEN + "You have been fully healed!");

        plugin.getCooldownManager().setCooldown(player.getUniqueId(), "heal");
        return true;
    }
}