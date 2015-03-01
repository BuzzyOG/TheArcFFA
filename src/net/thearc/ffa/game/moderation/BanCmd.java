package net.thearc.ffa.game.moderation;

import net.thearc.ffa.game.commands.CommandIndex;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCmd implements CommandExecutor {

    private static CommandIndex index;

    public static void registerArgs() {
        index = new CommandIndex("Banish");
        index.addAgument("[player]", "Ban a player from the server.");
        index.addAgument("[player] [reason]", "Ban a player for a reason.");
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ban")) {

            if (args.length == 0) {
                index.show(s);
            } else if (args.length == 1) {
                String arg = args[0];
                String reason = "None specified";
                    Bukkit.getOfflinePlayer(arg).setBanned(true);
                    if (Bukkit.getOfflinePlayer(arg).isOnline())
                    Bukkit.getPlayer(arg).kickPlayer("§8< §6The Arc Network §8>\n \n§cYou have been banned.\n§7Reason: §4" + reason + ".");
                    if (s instanceof Player) {
                        Player p = (Player)s;
                        Bukkit.broadcastMessage("§3[BAN] §7" + p.getName() + " §chas banned §7" + arg + " §cfor §4" + reason);
                    } else
                        Bukkit.broadcastMessage("§3[BAN] §7" + "§eCONSOLE" + " §chas banned §7" + arg + " §cfor §4" + reason);
            } else if (args.length > 1) {
                String arg = args[0];
                String reason = "";

                for (int i = 1; i < args.length - 1; i++) {
                    reason += args[i] + ' ';
                }
                reason += args[args.length - 1];

                    OfflinePlayer b = Bukkit.getOfflinePlayer(arg);
                    b.setBanned(true);
                    if (b.isOnline())
                        Bukkit.getPlayer(arg).kickPlayer("§8< §6The Arc Network §8>\n \n§cYou have been banned.\n§7Reason: §4" + reason + ".");
                    if (s instanceof Player) {
                        Player p = (Player)s;
                        Bukkit.broadcastMessage("§3[BAN] §7" + p.getName() + " §chas banned §7" + b.getName() + " §cfor §4" + reason);
                    } else
                        Bukkit.broadcastMessage("§3[BAN] §7" + "§eCONSOLE" + " §chas banned §7" + b.getName() + " §cfor §4" + reason);
            }

        }

        return true;
    }

}
