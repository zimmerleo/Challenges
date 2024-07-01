package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Utils.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class BlockSwapChallenge extends Challenge {

    public BlockSwapChallenge(List<Player> participants, Timer timer) {
        super("BlockSwapChallenge",
                List.of("§8│ §bIn dieser Challenge",
                        "§8│ §bgeht es um Glück und",
                        "§8│ §bKönnen! Alle 10 Minuten",
                        "§8│ §bverändern sich die",
                        "§8│ §bBlöcke um dich herum!"), Material.GRASS_BLOCK, Difficulty.MEDIUM, participants, timer);
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
