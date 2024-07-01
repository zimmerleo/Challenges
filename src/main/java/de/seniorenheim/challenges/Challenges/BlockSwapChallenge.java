package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Utils.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class BlockSwapChallenge extends Challenge {

    public BlockSwapChallenge(List<Player> participants, Timer timer) {
        super("BlockSwapChallenge",
                List.of("§8│ §bAlle 5 Minuten werden",
                        "§8│ §bdie Blöcke um dich herum",
                        "§8│ §bdurch andere ersetzt!"), Material.GRASS_BLOCK, Difficulty.MEDIUM, participants, timer);
    }

    @Override
    public boolean start() {
        return super.start();
    }

    @Override
    public boolean pause() {
        return super.pause();
    }

    @Override
    public boolean resume() {
        return super.resume();
    }

    @Override
    public boolean reset() {
        return super.reset();
    }

    @Override
    public boolean stop() {
        return super.stop();
    }
}
