package de.seniorenheim.challenges.Commands;

import de.seniorenheim.challenges.Challenges.Challenge;
import de.seniorenheim.challenges.Main;
import de.seniorenheim.challenges.Utils.Managers.ChallengeManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {

    private ChallengeManager cm = Main.getPlugin(Main.class).getChallengeManager();

    @Override
    public boolean onCommand(CommandSender cs, Command command, String cmdLabel, String[] args) {
        if (cs instanceof Player) {
            Player p = (Player) cs;

            if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target != null && target != p) {

                    for (Challenge ch : cm.getActiveChallenges()) {
                        if (ch.getParticipants().contains(target) && (!ch.isStarted() || ch.isPaused())) {
                            ch.getParticipants().add(p);
                            p.sendMessage("§aDu bist der §e" + ch.getChallengeName() + " §avon §e" + target.getName() + " §abeigetreten!");
                            break;
                        }
                    }

                } else {
                    p.sendMessage("§cDiesen Spieler gibt es nicht!");
                }


            } else {
                p.sendMessage("§cFalsche Syntax! Nutze /join <Spieler>");
            }
        }
        return false;
    }
}