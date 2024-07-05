package de.seniorenheim.minigames.Utils.Inventories;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomInventory {

    private ItemStack filler;
    private ItemStack next;
    private ItemStack previous;
    private ItemStack confirm;
    private ItemStack cancel;

    public CustomInventory() {

        filler = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName("");
        filler.setItemMeta(fillerMeta);

        next = new ItemStack(Material.PAPER);
        ItemMeta nextMeta = next.getItemMeta();
        nextMeta.setDisplayName("§e→");
        next.setItemMeta(nextMeta);

        previous = new ItemStack(Material.PAPER);
        ItemMeta previousMeta = previous.getItemMeta();
        previousMeta.setDisplayName("§e←");
        previous.setItemMeta(previousMeta);

        confirm = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName("§a✓");
        confirm.setItemMeta(confirmMeta);

        cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName("§c✗");
        cancel.setItemMeta(cancelMeta);
    }

    public ItemStack getFiller() {
        return filler;
    }

    public ItemStack getNext() {
        return next;
    }

    public ItemStack getPrevious() {
        return previous;
    }

    public ItemStack getConfirm() {
        return confirm;
    }

    public ItemStack getCancel() {
        return cancel;
    }
}
