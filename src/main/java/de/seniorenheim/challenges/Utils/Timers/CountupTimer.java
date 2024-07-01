package de.seniorenheim.challenges.Utils.Timers;

import de.seniorenheim.challenges.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class CountupTimer extends Timer {
    public CountupTimer() {
        super(0, 0, 0, 0);
    }

    @Override
    public boolean start(List<Player> players) {
        reset(players);
        increment();
        display(players);
        return true;
    }

    @Override
    public boolean pause(List<Player> players) {
        if (getTaskID() != -1) {
            Bukkit.getScheduler().cancelTask(getTaskID());
        }
        return true;
    }

    @Override
    public boolean resume(List<Player> players) {
        increment();
        return true;
    }

    @Override
    public boolean reset(List<Player> players) {
        pause(players);
        seconds = 0;
        minutes = 0;
        hours = 0;
        days = 0;
        return true;
    }

    private void increment() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {

                seconds++;

                if (seconds == 60) {
                    seconds = 0;
                    minutes++;

                    if (minutes == 60) {
                        minutes = 0;
                        hours++;

                        if (hours == 24) {
                            hours = 0;
                            days++;
                        }
                    }
                }
            }
        }, 0, 20L);
    }
}
