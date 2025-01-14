package de.seniorenheim.minigames.Challenges.Listeners;

import de.seniorenheim.minigames.Challenges.Types.Challenge;
import de.seniorenheim.minigames.Main;
import de.seniorenheim.minigames.Utils.Inventories.ChallengeChoosingInventory;
import de.seniorenheim.minigames.Utils.Inventories.ChallengeCreatingInventory;
import de.seniorenheim.minigames.Utils.Managers.ChallengeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Objects;

public class ChallengeInvListener implements Listener {

    private ChallengeManager cm = Main.getPlugin(Main.class).getChallengeManager();

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().startsWith("§6Challenges | ")) {
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
        } else if (e.getView().getTitle().endsWith("Challenge")) {
            e.setCancelled(true);

            if (e.getCurrentItem() != null && Objects.requireNonNull(e.getCurrentItem().getItemMeta()).hasDisplayName()) {

                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§a✓" -> {

                        try {
                            Class<?> clazz = Class.forName(e.getView().getTitle().substring(2));
                            Constructor<?> constructor = clazz.getConstructor(List.class);

                            Challenge challenge = (Challenge) constructor.newInstance(List.of(p));

                            cm.activate(challenge);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    case "§c✗" -> {
                        p.openInventory(new ChallengeChoosingInventory(cm.getChallengeLists(), 1).getInventory());
                    }
                    default -> { }
                }
            }
        }
    }
}
