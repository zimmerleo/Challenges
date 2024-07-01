package de.seniorenheim.challenges.Utils.Timers;

import de.seniorenheim.challenges.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class CountdownTimer extends Timer {

    private int[] timerSettings;

    public CountdownTimer(int days, int hours, int minutes, int seconds) {
        super(days, hours, minutes, seconds);
        timerSettings = new int[]{days, hours, minutes, seconds};
    }

    @Override
    public boolean start(List<Player> players) {
        reset(players);
        decrement();
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
        decrement();
        return true;
    }

    @Override
    public boolean reset(List<Player> players) {
        pause(players);
        seconds = timerSettings[3];
        minutes = timerSettings[2];
        hours = timerSettings[1];
        days = timerSettings[0];
        return true;
    }

    private void decrement() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {

                seconds--;

                if (seconds == -1) {
                    seconds = 59;
                    minutes--;

                    if (minutes == -1) {
                        minutes = 59;
                        hours--;

                        if (hours == -1) {
                            hours = 23;
                            days--;
                        }
                    }
                }
            }
        }, 0, 20L);
    }


}
