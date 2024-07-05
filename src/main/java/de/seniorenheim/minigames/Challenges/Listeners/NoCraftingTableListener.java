package de.seniorenheim.minigames.Challenges.Listeners;

import de.seniorenheim.minigames.Challenges.Types.Challenge;
import de.seniorenheim.minigames.Challenges.Types.NoCraftingTableChallenge;
import de.seniorenheim.minigames.Main;
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
                if (c.getParticipants().contains(e.getPlayer()) && c instanceof NoCraftingTableChallenge && c.isStarted() && !c.isPaused()) {
                    e.setCancelled(true);
                    // e.getPlayer().closeInventory();
                    break;
                }
            }
        }
    }
}
