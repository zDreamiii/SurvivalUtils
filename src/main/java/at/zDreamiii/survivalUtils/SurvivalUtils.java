package at.zDreamiii.survivalUtils;


import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalUtils extends JavaPlugin {

    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        cooldownManager = new CooldownManager(this);

        this.getCommand("heal").setExecutor(new Heal(this));
        this.getCommand("feed").setExecutor(new Feed(this));
        this.getCommand("repair").setExecutor(new Repair(this));
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        this.getCommand("craft").setExecutor(new Workbench(this));
        this.getCommand("anvil").setExecutor(new Anvil(this));
        this.getCommand("enderchest").setExecutor(new Enderchest(this));
        this.getCommand("grindstone").setExecutor(new Grindstone(this));

    }

    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}
