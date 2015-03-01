package net.thearc.ffa.game.killstreaks;

import net.thearc.ffa.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Killstreak {

    private String name;
    private String[] desc;
    private int price;

    private Listener handle;
    private Material mat;

    public Killstreak(String name, String[] description, int price, Listener handler) {
        this.name = name;
        this.desc = description;
        this.price = price;
        this.handle = handler;

        this.mat = Material.EXP_BOTTLE;

        Main.getInstance().getServer().getPluginManager().registerEvents(getHandler(), Main.getInstance());
        KSManager.registerKS(this);
    }

    public Killstreak(String name, String[] description, int price, Listener handler, Material material) {
        this.name = name;
        this.desc = description;
        this.price = price;
        this.handle = handler;

        this.mat = material;

        Main.getInstance().getServer().getPluginManager().registerEvents(getHandler(), Main.getInstance());
        KSManager.registerKS(this);
    }

    public String getName() {
        return this.name;
    }

    public String[] getDescription() {
        return this.desc;
    }

    public int getPrice() {
        return this.price;
    }

    public Listener getHandler() {
        return this.handle;
    }

    public Material getMaterial() {
        return this.mat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String[] description) {
        this.desc = description;
    }

    public void setPrice(int amount) {
        this.price = amount;
    }

    public void setHandler(Listener handler) {
        this.handle = handler;
    }

    public void setMaterial(Material material) {
        this.mat = material;
    }

    public void purchase(Player player) {
        if (!(player.getLevel() >= getPrice())) return;
        player.setLevel(player.getLevel() - getPrice());
    }

}