package de.seniorenheim.challenges.Listeners;

import de.seniorenheim.challenges.Challenges.Challenge;
import de.seniorenheim.challenges.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class SharedDamageListener implements Listener {

    List<Challenge> challenges = Main.getPlugin(Main.class).getChallengeManager().getActiveChallenges();

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            for (Challenge c : challenges) {
                if (c.getParticipants().contains(p)) {

                    for (Player all : c.getParticipants()) {
                        if (!all.getName().equals(p.getName())) {
                            all.damage(e.getDamage());
                        }
                    }
                    break;
                }
            }
        }
    }
}
