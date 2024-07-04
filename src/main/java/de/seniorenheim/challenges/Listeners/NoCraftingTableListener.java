package de.seniorenheim.challenges.Listeners;

import de.seniorenheim.challenges.Challenges.Challenge;
import de.seniorenheim.challenges.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.CraftingInventory;

import java.util.List;

public class NoCraftingTableListener implements Listener {

    List<Challenge> challenges = Main.getPlugin(Main.class).getChallengeManager().getActiveChallenges();

    //TODO Überall abfragen ob sich der Spieler in der jew. Challenge befindet
    @EventHandler
    public void onOpenCraftingTable(InventoryOpenEvent e) {
        if (e.getInventory() instanceof CraftingInventory) {
            for (Challenge c : challenges) {
                if (c.getParticipants().contains(e.getPlayer())) {
                    e.setCancelled(true);
                    // e.getPlayer().closeInventory();
                    break;
                }
            }
        }
    }
}
