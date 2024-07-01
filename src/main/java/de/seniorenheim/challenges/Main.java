package de.seniorenheim.challenges;

import de.seniorenheim.challenges.Commands.ChallengeCommand;
import de.seniorenheim.challenges.Utils.Managers.ChallengeManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Plugin plugin;
    private Main instance;
    private ChallengeManager challengeManager;

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        challengeManager = new ChallengeManager();
        challengeManager.setup();

        loadCommands();

    }

    private void loadCommands() {
        getCommand("challenge").setExecutor(new ChallengeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public Main getInstance() {
        return instance;
    }

    public ChallengeManager getChallengeManager() {
        return challengeManager;
    }
}
