package de.seniorenheim.challenges.Utils.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChallengeCreatingInventory extends CustomInventory {

    private Inventory inventory;

    public ChallengeCreatingInventory(ItemStack item) {
        super();

        inventory = Bukkit.createInventory(null, 27, item.getItemMeta().getDisplayName());

        inventory.setItem(11, super.getCancel());
        inventory.setItem(13, item);
        inventory.setItem(15, super.getConfirm());

        for (int i = 0; i <= 26; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.getFiller());
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
