package de.seniorenheim.challenges.Listeners;

import de.seniorenheim.challenges.Challenges.Challenge;
import de.seniorenheim.challenges.Challenges.InverseDamageChallenge;
import de.seniorenheim.challenges.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.List;

public class InverseDamageListener implements Listener {

    List<Challenge> challenges = Main.getPlugin(Main.class).getChallengeManager().getActiveChallenges();
    private boolean eventCaused;

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            double damage = e.getDamage();

            for (Challenge c : challenges) {
                if (c.getParticipants().contains(p) && c instanceof InverseDamageChallenge && c.isStarted() && !c.isPaused()) {

                    if (!eventCaused) {
                        e.setCancelled(true);
                        eventCaused = true;
                        p.setFoodLevel( 20 - (int) (damage * 100) / 100);
                        eventCaused = false;
                    }
                    break;
                }
            }
        }
    }
    @EventHandler
    public void onStarve(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            for (Challenge c : challenges) {
                if (c.getParticipants().contains(p) && c instanceof InverseDamageChallenge && c.isStarted() && !c.isPaused()) {

                    if (!eventCaused) {
                        e.setCancelled(true);
                        eventCaused = true;
                        p.damage(e.getFoodLevel());
                        eventCaused = false;
                    }
                    break;
                }
            }
        }
    }
}
