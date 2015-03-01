package net.thearc.ffa.game.spawns.command;

import net.thearc.ffa.game.FFA;
import net.thearc.ffa.game.commands.CommandIndex;
import net.thearc.ffa.game.spawns.SpawnManager;
import net.thearc.ffa.utility.common.UtilMath;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCmd implements CommandExecutor {

    private static CommandIndex index;

    public static void registerArgs() {
        index = new CommandIndex("Spawn");
        index.addAgument("add", "Adds a new spawn to the list");
        index.addAgument("[number]", "Teleport to spawn #[number]");
        index.addAgument("set [number]", "Set spawn #[number] to your location");
        index.addAgument("remove [number]", "Remove a spawn from the list");
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (s instanceof Player) {
                Player p = (Player) s;

                if (args.length == 0) {
                    index.show(p);
                } else if (args.length == 1) {
                    String id = args[0];
                    if (id.equalsIgnoreCase("add")) {
                        SpawnManager.addSpawn(p.getLocation());
                        p.sendMessage(FFA.getPrefix() + "Created §enew spawn §7at your location");
                    } else if (id.equalsIgnoreCase("main")) {
                        p.teleport(SpawnManager.getMainSpawn());
                        p.sendMessage(FFA.getPrefix() + "Teleported to the §emain §7spawn");
                    } else if (UtilMath.isInteger(id)) {
                        p.teleport(SpawnManager.getSpawn(Integer.valueOf(id)));
                        p.sendMessage(FFA.getPrefix() + "Teleported to the spawn §e#" + Integer.valueOf(id));
                    } else {
                        p.sendMessage("§4§lFFA §cIncorrect value submitted.");
                        index.show(p);
                    }

                } else if (args.length == 2) {
                    String funct = args[0];
                    String id = args[1];
                    if (funct.equalsIgnoreCase("set")) {
                        if (id.equalsIgnoreCase("main")) {
                            SpawnManager.setMainSpawn(p.getLocation());
                            p.sendMessage(FFA.getPrefix() + "Set the §emain spawn §7to your location");
                        } else if (UtilMath.isInteger(id)) {
                            SpawnManager.setSpawn(Integer.valueOf(id), p.getLocation());
                            p.sendMessage(FFA.getPrefix() + "Set spawn §e#" + id + " §7to your location");
                        } else {
                            p.sendMessage("§4§lFFA §cIncorrect value(s) submitted");
                            index.show(p);
                        }
                    } else if (funct.equalsIgnoreCase("remove")) {
                        if (UtilMath.isInteger(id)) {
                            SpawnManager.removeSpawn(Integer.valueOf(id));
                            p.sendMessage(FFA.getPrefix() + "Removed spawn §e#" + id + " §7from the list");
                        } else {
                            p.sendMessage("§4§lFFA §cIncorrect value submitted.");
                            index.show(p);
                        }
                    }

                } else {
                    p.sendMessage("§4§lFFA §cIncorrect number of arguments");
                }

            } else {
                s.sendMessage("§cConsole cannot do this");
            }
        }

        return true;
    }

}
