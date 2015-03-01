package net.thearc.ffa.game.pvp.infraction.command;

import net.thearc.ffa.game.commands.CommandIndex;
import net.thearc.ffa.game.pvp.infraction.Infraction;
import net.thearc.ffa.game.pvp.infraction.InfractionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PvplogCmd implements CommandExecutor {

    private static CommandIndex index;

    public static void registerArgs() {
        index = new CommandIndex("PvPLog");
        index.addAgument("latest", "View your latest infraction");
        index.addAgument("view", "View all your recent infractions");
        index.addAgument("latest [player]", "View [player]'s latest infraction");
        index.addAgument("view [player]", "View [player]'s recent infractions");
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pvplog")) {
            if (s instanceof Player) {
                Player p = (Player) s;

                if (args.length == 0) {
                    index.show(p);
                } else if (args.length == 1) {
                    String arg = args[0];
                    if (arg.equalsIgnoreCase("latest")) {
                        p.sendMessage(index.getDivider());
                        p.sendMessage("§aYour Latest Infraction:");
                        Infraction inf = InfractionManager.getLastest(p);
                        p.sendMessage(" §e" + inf.getKiller().getName() + " §c§lX §6" + inf.getWhoDied().getName() + " §7at §9" + inf.getTime());
                        p.sendMessage(index.getDivider());
                    } else if (arg.equalsIgnoreCase("view")) {
                        p.sendMessage(index.getDivider());
                        p.sendMessage("§aYour Recent Infractions:");
                        for (Infraction inf : InfractionManager.getAll(p)) {
                            p.sendMessage(" §e" + inf.getKiller().getName() + " §c§lX §6" + inf.getWhoDied().getName() + " §7at §9" + inf.getTime());
                        }
                        p.sendMessage(index.getDivider());
                    } else {
                        p.sendMessage("§4§lFFA §cIncorrect value submitted.");
                        index.show(p);
                    }

                } else if (args.length == 2) {
                    String arg = args[0];
                    String who = args[1];
                    if (Bukkit.getOfflinePlayer(who).isOnline()) {
                        Player w = Bukkit.getPlayer(who);
                        if (arg.equalsIgnoreCase("latest")) {
                            p.sendMessage(index.getDivider());
                            p.sendMessage("§a" + who + "'s Latest Infraction:");
                            Infraction inf = InfractionManager.getLastest(w);
                            p.sendMessage(" §e" + inf.getKiller().getName() + " §c§lX §6" + inf.getWhoDied().getName() + " §7at §9" + inf.getTime());
                            p.sendMessage(index.getDivider());
                        } else if (arg.equalsIgnoreCase("view")) {
                            p.sendMessage(index.getDivider());
                            p.sendMessage("§a" + who + "'s Recent Infractions:");
                            for (Infraction inf : InfractionManager.getAll(w)) {
                                p.sendMessage(" §e" + inf.getKiller().getName() + " §c§lX §6" + inf.getWhoDied().getName() + " §7at §9" + inf.getTime());
                            }
                            p.sendMessage(index.getDivider());
                        } else {
                            p.sendMessage("§4§lFFA §cIncorrect value submitted.");
                            index.show(p);
                        }

                    } else {
                        p.sendMessage("§4§lFFA §cThat player is not online");
                    }
                }

            }
        }

        return true;
    }

}
