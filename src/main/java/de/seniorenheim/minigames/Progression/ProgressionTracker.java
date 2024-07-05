package de.seniorenheim.minigames.Progression;

public class ProgressionTracker {

    /* Level I II III IV ...
        Elo (towards next level):
        I: 0
        II: 100 * 2^0 25
        III : 100 * 2^1 125
        IV: 100 * 2^2

        Given Elo on Completion: convertToInt(Difficulty difficulty)^level * (1 - level / maxLevel)
     */
}
