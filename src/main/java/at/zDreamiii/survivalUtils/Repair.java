package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class Repair extends PlayerCommand {

    private final SurvivalUtils plugin;

    public Repair(SurvivalUtils plugin) {
        this.plugin = plugin;
    }

    @Override
    protected boolean onPlayerCommand(Player player, Command command, String label, String[] args) {
        ItemStack item = player.getInventory().getItemInMainHand();

        if (!player.hasPermission("survivalutils.repair")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        if (item == null || item.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "You must hold an item in your hand that can be repaired!");
            return true;
        }

        if (!(item.getItemMeta() instanceof Damageable damageable)
            || item.getType().getMaxDurability() <= 0) {
            player.sendMessage(ChatColor.RED + "This item cannot be repaired.");
            return true;

        }

        if (!damageable.hasDamage()) {
            player.sendMessage(ChatColor.RED + "This item is already fully repaired.");
            return true;
        }

        if (plugin.getCooldownManager().isOnCooldown(player.getUniqueId(), "repair")) {
            long remaining = plugin.getCooldownManager().getRemainingTime(player.getUniqueId(), "repair");
            player.sendMessage(ChatColor.RED + "You must wait " + remaining + " seconds before using this command again!");
            return true;
        }

        damageable.setDamage(0);
        item.setItemMeta(damageable);

        player.sendMessage(ChatColor.GREEN + "Your item has been successfully repaired!");
        plugin.getCooldownManager().setCooldown(player.getUniqueId(), "repair");

        return true;
    }
}
