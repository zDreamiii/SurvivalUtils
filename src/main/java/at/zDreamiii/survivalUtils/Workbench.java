package at.zDreamiii.survivalUtils;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Workbench extends PlayerCommand {

    private final SurvivalUtils plugin;

    public Workbench(SurvivalUtils plugin) {this.plugin = plugin;}

    @Override
    protected boolean onPlayerCommand(Player player, Command command, String label, String[] args) {

        if (!player.hasPermission("survivalutils.workbench")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        player.openWorkbench(null, true);
        player.sendMessage(ChatColor.GREEN + "Workbench opened!");
        return true;
    }
}

