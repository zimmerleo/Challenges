package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Utils.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class SharedDamageChallenge extends Challenge {

    public SharedDamageChallenge(List<Player> participants, Timer timer) {
        super("SharedDamageChallenge",
                List.of("§8│ §bSpiel Minecraft durch,",
                        "§8│ §balleine oder mit Freunden!",
                        "§8│ §bTeilt euch eine Healthbar,",
                        "§8│ §bganz nach dem Motto:",
                        "§8│ §b'Geteiltes Leid ist",
                        "§8│ §bhalbes Leid!'"), Material.CHAIN, Difficulty.HARD, participants, timer);
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
