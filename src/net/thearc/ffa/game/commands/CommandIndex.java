package net.thearc.ffa.game.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class CommandIndex {

    private String label;

    private HashMap<String, String> index = new HashMap<String, String>();
    private HashMap<String, String> desc = new HashMap<String, String>();

    public CommandIndex(String label) {
        this.label = label;
    }

    public HashMap<String, String> getIndex() {
        return this.index;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDivider() {
        return "§6-----------------------------------------------------";
    }

    public Collection<String> getArguments() {
        return getIndex().values();
    }

    public void addAgument(String argument) {
        if (!contains(argument)) {
            Random r = new Random();
            int rand = r.nextInt(999999);
            this.index.put(argument, "Default command description. [ " + rand + " ]");
            this.desc.put("Default command description. [ " + rand + " ]", argument);
        }
    }

    public void addAgument(String argument, String description) {
        if (!contains(argument)) {
            this.index.put(argument, description);
            this.desc.put(description, argument);
        }
    }

    public void removeAgument(String argument) {
        if (contains(argument)) {
            this.index.remove(argument);
            this.desc.remove(getIndex().get(argument));
        }
    }

    public boolean contains(String argument) {
        return getIndex().containsKey(argument);
    }

    public void show(Player p) {
        p.sendMessage(getDivider());
        p.sendMessage("§a" + getLabel() + " Commands:");
        for (String arg : getArguments()) {
            p.sendMessage("§e/" + getLabel().toLowerCase() + " " + this.desc.get(arg) + " §b- " + arg + ".");
        }
        p.sendMessage(getDivider());
    }

    public void show(CommandSender s) {
        s.sendMessage(getDivider());
        s.sendMessage("§a" + getLabel() + " Commands:");
        for (String arg : getArguments()) {
            s.sendMessage("§e/" + getLabel().toLowerCase() + " " + this.desc.get(arg) + " §b- " + arg + ".");
        }
        s.sendMessage(getDivider());
    }

}