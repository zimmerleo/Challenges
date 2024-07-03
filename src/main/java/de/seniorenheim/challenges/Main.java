package de.seniorenheim.challenges;

import de.seniorenheim.challenges.Commands.*;
import de.seniorenheim.challenges.Utils.Managers.ChallengeManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Plugin plugin;
    private Main instance;
    private final ChallengeManager challengeManager = new ChallengeManager();

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        challengeManager.setup();

        loadCommands();
    }

    private void loadCommands() {
        getCommand("challenge").setExecutor(new ChallengeCommand());
        getCommand("join").setExecutor(new JoinCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("pause").setExecutor(new PauseCommand());
        getCommand("resume").setExecutor(new ResumeCommand());
        getCommand("reset").setExecutor(new ResetCommand());
        getCommand("stop").setExecutor(new StopCommand());
    }

    @Override
    public void onDisable() {
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
