package at.zDreamiii.survivalUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class Grindstone implements CommandExecutor, Listener {

    private final SurvivalUtils plugin;

    public Grindstone(SurvivalUtils plugin) {
        this.plugin = plugin;

    Bukkit.getPluginManager().registerEvents( this,plugin);

    }

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

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() != InventoryType.GRINDSTONE) return;

        if (event.getRawSlot()!= 2) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getType() != InventoryType.GRINDSTONE) return;

        Player player = (Player) event.getPlayer();

        for (ItemStack item : event.getInventory().getContents()) {
            if (item != null) {
                player.getInventory().addItem(item);
            }
        }
    }
}
