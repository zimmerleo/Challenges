package de.seniorenheim.challenges.Commands;

import de.seniorenheim.challenges.Challenges.BlockSwapChallenge;
import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Inventories.ChallengeChoosingInventory;
import de.seniorenheim.challenges.Utils.Managers.ChallengeManager;
import de.seniorenheim.challenges.Utils.Timers.CountdownTimer;
import de.seniorenheim.challenges.Utils.Timers.CountupTimer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

public class ChallengeCommand implements CommandExecutor {

    private ChallengeManager cm = Main.getPlugin(Main.class).getChallengeManager();

    @Override
    public boolean onCommand(CommandSender cs, Command command, String cmdLabel, String[] args) {
        if (cs instanceof Player) {
            Player p = (Player) cs;

            p.openInventory(new ChallengeChoosingInventory(cm.getChallengeLists().get(0)).getInventory());

            new CountdownTimer(1, 1, 1, 10).start(List.of(Bukkit.getPlayer("xX_HEHEBOI_Xx")));

        }

        /* inventar öffnen
        challenge auswählen
        bestätigen
        challenge wird erstellt
        spieler können beitreten
        challenge wird gestartet
         */
        return false;
    }
}
