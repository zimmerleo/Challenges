package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Difficulty.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class EndermanChallenge extends Challenge {

    private final Random random = new Random();
    private int task;

    public EndermanChallenge(List<Player> participants, Timer timer) {
        super("EndermanChallenge",
                List.of("§8│ §bSei ein Enderman!",
                        "§8│ §bAlle 2 Minuten tele-",
                        "§8│ §bportierst du dich an",
                        "§8│ §beinen zufälligen Ort",
                        "§8│ §bin deiner Nähe.",
                        "§8│ §bGleichzeitig bekommst",
                        "§8│ §bdu durch Wasser Schaden!"), Material.ENDER_EYE, Difficulty.MEDIUM, participants, timer);
    }

    @Override
    public boolean start() {
        checkTimer();
        return super.start();
    }

    @Override
    public boolean pause() {
        Bukkit.getScheduler().cancelTask(task);
        return super.pause();
    }

    @Override
    public boolean resume() {
        checkTimer();
        return super.resume();
    }

    @Override
    public boolean reset() {
        Bukkit.getScheduler().cancelTask(task);
        return super.reset();
    }

    @Override
    public boolean stop() {
        Bukkit.getScheduler().cancelTask(task);
        return super.stop();
    }

    private void checkTimer() {
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {

                if (getTimer().getMinutes() % 2 == 0 && getTimer().getSeconds() == 0) {
                    for (Player p : getParticipants()) {
                        teleportRandom(p);
                    }
                }
            }
        }, 0L, 20L);
    }

    private void teleportRandom(Player p) {
        int x = random.nextInt(p.getLocation().getBlockX() - 50, p.getLocation().getBlockX() + 50);
        int z = random.nextInt(p.getLocation().getBlockZ() - 50, p.getLocation().getBlockZ() + 50);

        p.teleport(p.getWorld().getHighestBlockAt(x, z).getLocation());
    }
}
