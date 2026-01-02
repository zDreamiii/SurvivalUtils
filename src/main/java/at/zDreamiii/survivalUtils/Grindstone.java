package at.zDreamiii.survivalUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;


public class Grindstone implements CommandExecutor {

    private final SurvivalUtils plugin;

    public Grindstone(SurvivalUtils plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("survivalutils.grindstone")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        Inventory grindstone = Bukkit.createInventory(player, InventoryType.GRINDSTONE, "Grindstone");
        player.openInventory(grindstone);

        player.sendMessage(ChatColor.GREEN + "Grindstone opened!");
        return true;
    }
}
