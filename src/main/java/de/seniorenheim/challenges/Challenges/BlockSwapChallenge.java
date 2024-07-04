package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Difficulty.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class BlockSwapChallenge extends Challenge {

    private final Random random = new Random();
    private int task;

    public BlockSwapChallenge(List<Player> participants, Timer timer) {
        super("BlockSwapChallenge",
                List.of("§8│ §bAlle 5 Minuten werden",
                        "§8│ §bdie Blöcke um dich herum",
                        "§8│ §bdurch andere ersetzt!"), Material.GRASS_BLOCK, Difficulty.EASY, participants, timer);
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

                if (getTimer().getMinutes() % 5 == 0 && getTimer().getSeconds() == 0) {
                    for (Player p : getParticipants()) {
                        swapBlocks(p);
                    }
                }
            }
        }, 0L, 20L);
    }

    private void swapBlocks(Player p) {
        World world = p.getWorld();
        int radius = 16;
        int px = p.getLocation().getBlockX();
        int py = p.getLocation().getBlockY();
        int pz = p.getLocation().getBlockZ();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    Block block = world.getBlockAt(px + x, py + y, pz + z);
                    if (block.getType() != Material.AIR) {
                        block.setType(getRandomBlockType());
                    }
                }
            }
        }
    }

    private Material getRandomBlockType() {
        Material[] materials = Material.values();
        Material material;
        do {
            material = materials[random.nextInt(materials.length)];
        } while (!material.isBlock() || material == Material.AIR || material.isLegacy());

        return material;
    }
}
