package net.thearc.ffa.game.killstreaks;

import net.thearc.ffa.game.killstreaks.handlers.TestKS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class KSManager {

    private static Inventory menu;
    private static List<Killstreak> killstreakList = new ArrayList<Killstreak>();

    public static void createMenu() {
        if (getKillstreaks().size() <= 9) {
            menu = Bukkit.createInventory(null, 9, "§9§lFFA §8Killstreaks");
        } else if (getKillstreaks().size() <= 18 && getKillstreaks().size() > 9) {
            menu = Bukkit.createInventory(null, 18, "§9§lFFA §8Killstreaks");
        }
    }

    public static Inventory getMenu() {
        return menu;
    }

    public static List<Killstreak> getKillstreaks() {
        return killstreakList;
    }

    public static void registerKS(Killstreak killstreak) {
        killstreakList.add(killstreak);
    }

    public static void unregisterKS(Killstreak killstreak) {
        killstreakList.remove(killstreak);
    }

    public static void populateKillstreaks() {
        Killstreak test = new Killstreak("Test", new String[] {
                "This is just a test KS"
        }, 1, new TestKS(), Material.WEB);
    }

}
