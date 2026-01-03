package at.zDreamiii.survivalUtils;


import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalUtils extends JavaPlugin {

    private CooldownManager cooldownManager;
    private boolean paper;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        cooldownManager = new CooldownManager(this);

        paper = checkPaper();

        if (paper) {
            getLogger().info("Running on Paper – full container support enabled.");
        } else {
            getLogger().warning("Running on Spigot – some container features are disabled.");
        }

        this.getCommand("heal").setExecutor(new Heal(this));
        this.getCommand("feed").setExecutor(new Feed(this));
        this.getCommand("repair").setExecutor(new Repair(this));

        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());

        this.getCommand("craft").setExecutor(new Workbench(this));
        this.getCommand("anvil").setExecutor(new Anvil(this));
        this.getCommand("enderchest").setExecutor(new Enderchest(this));

    }

    private boolean checkPaper() {
        try {
            Class.forName("io.papermc.paper.configuration.Configuration");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public boolean isPaper() {
        return paper;
    }

    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}
