package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Enderchest extends PlayerCommand {

    private final SurvivalUtils plugin;

    public Enderchest(SurvivalUtils plugin) {this.plugin = plugin;}

    @Override
    protected boolean onPlayerCommand(Player player, Command command, String label, String[] args) {

        if (!player.hasPermission("survivalutils.enderchest")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        player.openInventory(player.getEnderChest());
        player.sendMessage(ChatColor.GREEN + "Enderchest opened!");
        return true;
    }
}
