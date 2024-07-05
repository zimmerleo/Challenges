package de.seniorenheim.minigames.Challenges.Commands;

import de.seniorenheim.minigames.Challenges.Types.Challenge;
import de.seniorenheim.minigames.Main;
import de.seniorenheim.minigames.Utils.Managers.ChallengeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopCommand implements CommandExecutor {
    private ChallengeManager cm = Main.getPlugin(Main.class).getChallengeManager();

    @Override
    public boolean onCommand(CommandSender cs, Command command, String cmdLabel, String[] args) {
        if (cs instanceof Player) {
            Player p = (Player) cs;

            if (args.length == 0) {
                for (Challenge ch : cm.getActiveChallenges()) {
                    if (ch.getParticipants().get(0) == p && ch.isStarted()) {
                        ch.stop();
                        break;
                    }
                }
            } else {
                p.sendMessage("§cFalsche Syntax! Nutze /stop");
            }
        }
        return false;
    }
}
