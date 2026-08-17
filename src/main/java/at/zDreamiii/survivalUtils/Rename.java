package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rename extends PlayerCommand {

    private final SurvivalUtils plugin;

    public Rename(SurvivalUtils plugin) {this.plugin = plugin;}

    @Override
    protected boolean onPlayerCommand(Player player, Command command, String label, String[] args) {

        if (!player.hasPermission("survivalutils.rename")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        if (item == null || item.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "You must be holding an item to rename it!");
            return true;
        }

        String newName = String.join(" ", args).trim();

        if (newName.length() > 32) {
            player.sendMessage(ChatColor.RED + "Name too long! Max 32 characters.");
            return true;
        }

        newName = ChatColor.translateAlternateColorCodes('&', newName);

        ItemMeta meta = item.getItemMeta();
        if (meta == null) return true;
        meta.setDisplayName(newName);
        item.setItemMeta(meta);

        player.sendMessage(ChatColor.GREEN + "Item renamed to " + newName);
        return true;
    }
}
