package de.seniorenheim.minigames.Utils.Inventories;

import de.seniorenheim.minigames.Challenges.Types.Challenge;
import de.seniorenheim.minigames.Utils.Difficulty.DifficultyConverter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChallengeChoosingInventory extends CustomInventory {

    private Inventory inventory;

    public ChallengeChoosingInventory(ArrayList<ArrayList<Challenge>> challengeLists, int index) {
        super();

        inventory = Bukkit.createInventory(null, 54, "§6Challenges | " + index);

        inventory.setItem(45, super.getPrevious());
        inventory.setItem(53, super.getNext());

        for (Challenge c : challengeLists.get(index-1)) {
            ItemStack item = new ItemStack(c.getMaterial());
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§r§8┌ §6§l" + c.getChallengeName());

            ArrayList<String> lore = new ArrayList<>();
            lore.add("§8├─────────────────────");
            lore.addAll(c.getChallengeDescription());
            lore.add("§8├─────────────────────");
            lore.add("§8│ §9Schwierigkeitsstufe§7: "
                    + DifficultyConverter.convertToColorCode(c.getDifficulty())
                    + "█ ".repeat(DifficultyConverter.convertToInt(c.getDifficulty()))
                    + "§7█ ".repeat(5 - DifficultyConverter.convertToInt(c.getDifficulty())));
            lore.add("§8│ §9Versuche§7: §9" + c.getTimesTried());
            lore.add("§8│ §9Abschlüsse§7: §9" + c.getTimesCompleted());
            DecimalFormat df = new DecimalFormat("0.00");
            double ratio = (c.getTimesTried() > 0 ? Double.parseDouble(df.format((double) c.getTimesCompleted() / c.getTimesTried() * 100)) : 0.00D);
            lore.add("§8│ §9Erfolgsquote§7: " + (ratio >= 75 ? "§2" : (ratio >= 50 ? "§a" : (ratio >= 25 ? "§e" : (ratio >= 10 ? "§c" : "§4")))) + ratio + "%");
            lore.add("§8└─────────────────────");
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);

            inventory.addItem(item);
        }
        for (int i = 0; i < 53; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.getFiller());
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
