package de.seniorenheim.minigames.Challenges.Types;

import de.seniorenheim.minigames.Main;
import de.seniorenheim.minigames.Utils.Difficulty.Difficulty;
import de.seniorenheim.minigames.Utils.Timers.CountupTimer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class EndermanChallenge extends Challenge {

    private final Random random = new Random();
    private int task;

    public EndermanChallenge(List<Player> participants) {
        super("EndermanChallenge",
                List.of("§8│ §bSei ein Enderman!",
                        "§8│ §bAlle 2 Minuten tele-",
                        "§8│ §bportierst du dich an",
                        "§8│ §beinen zufälligen Ort",
                        "§8│ §bin deiner Nähe.",
                        "§8│ §bGleichzeitig bekommst",
                        "§8│ §bdu durch Wasser Schaden!"), Material.ENDER_EYE, Difficulty.MEDIUM, participants, new CountupTimer());
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
                for (Player p : getParticipants()) {

                    if (p.getPlayerWeather() == WeatherType.DOWNFALL) {
                        Block blockAboveHead = p.getLocation().add(0, 2, 0).getBlock();
                        Block highestBlock = p.getWorld().getHighestBlockAt(p.getLocation());

                        if (blockAboveHead.getType().isAir() && highestBlock.getY() < blockAboveHead.getY()) {
                            p.damage(0.5);
                            p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5, 1));
                        }
                    } else if (p.getLocation().getBlock().getType() == Material.WATER) {
                        p.damage(0.5);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5, 1));
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
