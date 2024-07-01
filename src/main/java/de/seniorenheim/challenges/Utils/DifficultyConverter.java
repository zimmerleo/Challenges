package de.seniorenheim.challenges.Utils;

public class DifficultyConverter {

    public static String convertToColorCode(Difficulty difficulty) {
        switch (difficulty) {
            case VERY_EASY: return "§2";
            case EASY: return "§a";
            case MEDIUM: return "§e";
            case HARD: return "§6";
            case VERY_HARD: return "§c";
            case EXTREME: return "§4";
            default: return "§7";
        }
    }

    public static int convertToInt(Difficulty difficulty) {
        switch (difficulty) {
            case VERY_EASY: return 1;
            case EASY: return 2;
            case MEDIUM: return 3;
            case HARD: return 4;
            case VERY_HARD, EXTREME: return 5;
            default: return 0;
        }
    }
}
