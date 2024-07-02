package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Utils.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class EndermanChallenge extends Challenge {

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
