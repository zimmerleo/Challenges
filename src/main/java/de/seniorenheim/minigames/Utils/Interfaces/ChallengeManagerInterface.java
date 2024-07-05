package de.seniorenheim.minigames.Utils.Interfaces;

import de.seniorenheim.minigames.Challenges.Types.Challenge;
import org.bukkit.entity.Player;

public interface ChallengeManagerInterface {

    public boolean create(Challenge challenge);
    public Challenge findBy(Player player);
    public boolean activate(Challenge challenge);
    public boolean deactivate(Challenge challenge);
}
