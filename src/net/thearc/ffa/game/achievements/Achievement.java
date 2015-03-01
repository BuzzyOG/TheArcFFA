package net.thearc.ffa.game.achievements;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.thearc.ffa.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Achievement {

    private String name;
    private String desc;
    private int reward;
    private Listener handler;
    private List<UUID> completed = new ArrayList<UUID>();

    public Achievement(String name, String desc, int reward, Listener handler) {
        this.name = name;
        this.desc = desc;
        this.reward = reward;
        this.handler = handler;

        register();
    }

    public void register() {
        Main.getInstance().getServer().getPluginManager().registerEvents(getHandler(), Main.getInstance());
        AchieveManager.achievements.add(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.desc;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public int getReward() {
        return this.reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public Listener getHandler() {
        return this.handler;
    }

    public void setHandler(Listener handler) {
        this.handler = handler;
    }

    public List<UUID> getCompleted() {
        return this.completed;
    }

    public void addCompleted(Player p) {
        this.completed.add(p.getUniqueId());
    }

    public boolean hasCompleted(Player p) {
        return getCompleted().contains(p);
    }

    public void showRecieve(Player p) {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);

        p.sendMessage(" ");
        p.sendMessage("§7● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ●");
        p.sendMessage(" §e§lAchievement Recieved!");
        p.sendMessage(" ");
        p.sendMessage("  §a" + getName() + " §7- §f" + getDescription());
        p.sendMessage("  §6You have recieved §e" + getReward() + " monies!");
        p.sendMessage("§7● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ●");
    }

    public void give(Player p) {
        addCompleted(p);
        showRecieve(p);

//      vp.addStars(getReward(), "Achievement");
    }

}