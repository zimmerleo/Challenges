package de.seniorenheim.challenges.Utils.Timers;

import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Interfaces.TimerInterface;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class Timer implements TimerInterface {

    protected int seconds;
    protected int minutes;
    protected int hours;
    protected int days;
    protected int taskID = -1;
    protected int displayTaskID = -1;

    public Timer(int days, int hours, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.days = days;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getDays() {
        return days;
    }

    public int getTaskID() {
        return taskID;
    }

    public int getDisplayTaskID() {
        return displayTaskID;
    }

    public void display(List<Player> players) {
        displayTaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {

                String timer = "§a".concat(days >= 10 ? String.valueOf(days) : "0" + String.valueOf(days)).concat("§7:§a")
                        .concat(hours >= 10 ? String.valueOf(hours) : "0" + String.valueOf(hours)).concat("§7:§a")
                        .concat(minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes)).concat("§7:§a")
                        .concat(seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds));

                for (Player p : players) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(timer));
                }
            }
        }, 0, 20L);
    }
}
