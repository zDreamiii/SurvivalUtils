package at.zDreamiii.survivalUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamemodeTabCompleter implements TabCompleter {

    private final List<String> modes = Arrays.asList(
            "0", "1", "2", "3",
            "survival", "creative", "adventure", "spectator"
    );

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            String input = args[0].toLowerCase();
            List<String> completions = new ArrayList<>();

            for (String mode : modes) {
                if (mode.toLowerCase().startsWith(input)) {
                    completions.add(mode);
                }
            }
            return completions;
        }
        return null;
    }
}
