package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Utils.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class InverseDamageChallenge extends Challenge {

    public InverseDamageChallenge(List<Player> participants, Timer timer) {
        super("InverseDamageChallenge",
                List.of("§8│ §bSpiele Minecraft durch!",
                        "§8│ §bVerliere anstelle jedes",
                        "§8│ §bHungerbalkens ein Herz",
                        "§8│ §bund andersrum!"), Material.ROTTEN_FLESH, Difficulty.MEDIUM, participants, timer);
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
