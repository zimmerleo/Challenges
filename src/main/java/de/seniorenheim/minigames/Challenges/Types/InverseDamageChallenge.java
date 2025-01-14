package de.seniorenheim.minigames.Challenges.Types;

import de.seniorenheim.minigames.Utils.Difficulty.Difficulty;
import de.seniorenheim.minigames.Utils.Timers.CountupTimer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public class InverseDamageChallenge extends Challenge implements Listener {

    private boolean eventCaused;

    public InverseDamageChallenge(List<Player> participants) {
        super("InverseDamageChallenge",
                List.of("§8│ §bSpiele Minecraft durch!",
                        "§8│ §bVerliere anstelle jedes",
                        "§8│ §bHungerbalkens ein Herz",
                        "§8│ §bund andersrum!"), Material.ROTTEN_FLESH, Difficulty.MEDIUM, participants, new CountupTimer());
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
