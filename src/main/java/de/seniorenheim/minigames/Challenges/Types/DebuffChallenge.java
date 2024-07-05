package de.seniorenheim.minigames.Challenges.Types;

import de.seniorenheim.minigames.Utils.Difficulty.Difficulty;
import de.seniorenheim.minigames.Utils.Timers.CountupTimer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class DebuffChallenge extends Challenge {

    public DebuffChallenge(List<Player> participants) {
        super("DebuffChallenge",
                List.of("§8│ §bSpiele Minecraft so",
                        "§8│ §bschnell es geht durch,",
                        "§8│ §bwährend du alle 5",
                        "§8│ §bMinuten einen zufälligen",
                        "§8│ §bDebuff bekommst!"), Material.FERMENTED_SPIDER_EYE, Difficulty.HARD, participants, new CountupTimer());
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
