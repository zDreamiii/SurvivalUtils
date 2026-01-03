package at.zDreamiii.survivalUtils;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Workbench implements CommandExecutor {

    private final SurvivalUtils plugin;

    public Workbench(SurvivalUtils plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("survivalutils.workbench")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission to use this command!");
            return true;
        }

        player.openWorkbench(null, true);
        player.sendMessage(ChatColor.GREEN + "Workbench opened!");
        return true;
    }
}
