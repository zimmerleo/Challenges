package de.seniorenheim.challenges.Commands;

import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Inventories.ChallengeChoosingInventory;
import de.seniorenheim.challenges.Utils.Managers.ChallengeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ChallengeCommand implements CommandExecutor {

    private ChallengeManager cm = Main.getPlugin(Main.class).getChallengeManager();

    @Override
    public boolean onCommand(CommandSender cs, Command command, String cmdLabel, String[] args) {
        if (cs instanceof Player) {
            Player p = (Player) cs;

            if (args.length == 0) {
                p.openInventory(new ChallengeChoosingInventory(cm.getChallengeLists().get(0)).getInventory());
            } else {
                p.sendMessage("§cFalsche Syntax! Nutze /challenge");
            }
        }
        return false;
    }
}
