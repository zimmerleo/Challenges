package de.seniorenheim.challenges.Challenges;

import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Difficulty;
import de.seniorenheim.challenges.Utils.Interfaces.ChallengeInterface;
import de.seniorenheim.challenges.Utils.Timers.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class Challenge implements ChallengeInterface {

    private final Timer timer;
    private final String challengeName;
    private final List<String> challengeDescription;
    private final Material material;
    private final Difficulty difficulty;
    private int timesCompleted;
    private int timesTried;
    private List<Player> participants;

    public Challenge(String challengeName, List<String> challengeDescription, Material material, Difficulty difficulty, List<Player> participants, Timer timer) {
        this.timer = timer;
        this.challengeName = challengeName;
        this.challengeDescription = challengeDescription;
        this.material = material;
        this.difficulty = difficulty;
        this.timesCompleted = (Main.getPlugin(Main.class).getChallengeManager().getFileConfiguration().get(challengeName + ".timesCompleted") != null
                ? Main.getPlugin(Main.class).getChallengeManager().getFileConfiguration().getInt(challengeName + ".timesCompleted")
                : -1);
        this.timesTried = (Main.getPlugin(Main.class).getChallengeManager().getFileConfiguration().get(challengeName + ".timesTried") != null
                ? Main.getPlugin(Main.class).getChallengeManager().getFileConfiguration().getInt(challengeName + ".timesTried")
                : -1);
        this.participants = participants;
    }

    @Override
    public boolean start() {
        return timer.start(participants);
    }

    @Override
    public boolean pause() {
        return timer.pause(participants);
    }

    @Override
    public boolean resume() {
        return timer.resume(participants);
    }

    @Override
    public boolean reset() {
        return timer.reset(participants);
    }

    @Override
    public boolean stop() {
        Bukkit.getScheduler().cancelTask(timer.getTaskID());
        Bukkit.getScheduler().cancelTask(timer.getDisplayTaskID());
        participants.clear();
        return true;
    }

    public Timer getTimer() {
        return timer;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public List<String> getChallengeDescription() {
        return challengeDescription;
    }

    public Material getMaterial() {
        return material;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getTimesCompleted() {
        return timesCompleted;
    }

    public int getTimesTried() {
        return timesTried;
    }

    public List<Player> getParticipants() {
        return participants;
    }
}
