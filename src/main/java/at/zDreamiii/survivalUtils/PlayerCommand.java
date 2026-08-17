package at.zDreamiii.survivalUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand implements CommandExecutor {

    @Override
    public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        return onPlayerCommand(player, command, label, args);
    }

    protected abstract boolean onPlayerCommand(Player player, Command command, String label, String[] args);
}
