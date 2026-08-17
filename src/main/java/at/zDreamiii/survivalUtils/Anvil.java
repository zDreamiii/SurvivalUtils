package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Anvil extends PlayerCommand {

    private final SurvivalUtils plugin;

    public Anvil(SurvivalUtils plugin) {this.plugin = plugin;}

    @Override
    protected boolean onPlayerCommand(Player player, Command command, String label, String[] args) {

        if (!player.hasPermission("survivalutils.anvil")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        if (!plugin.isPaper()) {
            player.sendMessage(ChatColor.RED + "This command requires Paper.");
            return true;
        }

        player.openAnvil(null, true);
        player.sendMessage(ChatColor.GREEN + "Anvil opened!");
        return true;
    }
}
