package de.seniorenheim.challenges.Listeners;

import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Inventories.ChallengeChoosingInventory;
import de.seniorenheim.challenges.Utils.Inventories.ChallengeCreatingInventory;
import de.seniorenheim.challenges.Utils.Managers.ChallengeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ChallengeInvListener implements Listener {

    private ChallengeManager cm = Main.getPlugin(Main.class).getChallengeManager();

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().contains("§6Challenges | ")) {
            int index = Integer.parseInt(e.getView().getTitle().substring(14));

            //TODO
            p.sendMessage("Index " + index);

            e.setCancelled(true);

            if (e.getCurrentItem() != null && Objects.requireNonNull(e.getCurrentItem().getItemMeta()).hasDisplayName()) {

                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§e→" -> {
                        if (index + 1 <= cm.getChallengeLists().size()) {
                            p.openInventory(new ChallengeChoosingInventory(cm.getChallengeLists(), index + 1).getInventory());
                        }
                    }
                    case "§e←" -> {
                        if (index - 1 >= 1) {
                            p.openInventory(new ChallengeChoosingInventory(cm.getChallengeLists(), index - 1).getInventory());
                        }
                    }
                    case "" -> { }
                    default -> {
                        //TODO
                        p.sendMessage(e.getCurrentItem().getItemMeta().getDisplayName().substring(10));
                        p.openInventory(new ChallengeCreatingInventory(e.getCurrentItem()).getInventory());
                    }
                }
            }
        }
    }
}
