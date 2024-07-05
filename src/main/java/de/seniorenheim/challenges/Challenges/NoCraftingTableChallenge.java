package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Utils.Difficulty.Difficulty;
import de.seniorenheim.challenges.Utils.Timers.CountupTimer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class NoCraftingTableChallenge extends Challenge {

    public NoCraftingTableChallenge(List<Player> participants) {
        super("NoCraftingTableChallenge",
                List.of("§8│ §bZiel ist es, Minecraft ohne",
                        "§8│ §beinen CraftingTable durch-",
                        "§8│ §bzuspielen! Bist du der",
                        "§8│ §bHerausforderung gewachsen?"), Material.CRAFTING_TABLE, Difficulty.VERY_HARD, participants, new CountupTimer());
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
