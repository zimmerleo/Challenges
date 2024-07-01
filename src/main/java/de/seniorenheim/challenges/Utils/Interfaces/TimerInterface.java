package de.seniorenheim.challenges.Utils.Interfaces;

import org.bukkit.entity.Player;

import java.util.List;

public interface TimerInterface {

    int getSeconds();
    int getMinutes();
    int getHours();
    int getDays();
    int getTaskID();
    int getDisplayTaskID();

    boolean start(List<Player> players);
    boolean pause(List<Player> players);
    boolean resume(List<Player> players);
    boolean reset(List<Player> players);
    void display(List<Player> players);
}
