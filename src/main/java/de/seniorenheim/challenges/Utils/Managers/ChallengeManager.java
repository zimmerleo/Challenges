package de.seniorenheim.challenges.Utils.Managers;

import de.seniorenheim.challenges.Challenges.*;
import de.seniorenheim.challenges.Utils.Interfaces.ChallengeManagerInterface;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChallengeManager implements ChallengeManagerInterface {
    private ArrayList<ArrayList<Challenge>> challengeLists;
    private ArrayList<Challenge> activeChallenges;
    private File file;
    private FileConfiguration fileConfiguration;

    public ChallengeManager() {
        this.file = new File("plugins//Challenges/challenges.yml");
        this.fileConfiguration = new YamlConfiguration();

        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.challengeLists = new ArrayList<>();
        this.activeChallenges = new ArrayList<>();
    }

    @Override
    public boolean create(Challenge challenge) {

        if (challengeLists.isEmpty() || challengeLists.get(challengeLists.size()-1).size() >= 52) {
            challengeLists.add(new ArrayList<>());
        }

        challengeLists.get(challengeLists.size()-1).add(challenge);

        fileConfiguration.set(challenge.getChallengeName() + ".timesCompleted", 0);
        fileConfiguration.set(challenge.getChallengeName() + ".timesTried", 0);
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean activate(Challenge challenge) {

        if (activeChallenges.contains(challenge)) {
            return false;

        } else {
            activeChallenges.add(challenge);
            return true;
        }
    }

    @Override
    public Challenge findBy(Player player) {
        for (Challenge challenge : activeChallenges) {
            if (challenge.getParticipants().contains(player)) {
                return challenge;
            }
        }
        return null;
    }

    @Override
    public boolean deactivate(Challenge challenge) {
        if (activeChallenges.contains(challenge)) {
            activeChallenges.remove(challenge);
            return true;
        } else {
            return false;
        }
    }

    public void setup() {
        create(new BlockSwapChallenge(null, null));
        create(new DebuffChallenge(null, null));
        create(new EndermanChallenge(null, null));
        create(new InverseDamageChallenge(null, null));
        create(new SharedDamageChallenge(null, null));
        create(new NoCraftingTableChallenge(null, null));
    }

    public ArrayList<ArrayList<Challenge>> getChallengeLists() {
        return challengeLists;
    }

    public ArrayList<Challenge> getActiveChallenges() {
        return activeChallenges;
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }
}
