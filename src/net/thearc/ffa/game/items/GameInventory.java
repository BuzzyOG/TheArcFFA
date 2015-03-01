package net.thearc.ffa.game.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GameInventory {

    private static ItemStack sword;
    private static ItemStack rod;
    private static ItemStack steel;
    private static ItemStack bow;

    private static ItemStack ks;
    private static ItemStack hub;
    private static ItemStack arrow;

    private static ItemStack helm;
    private static ItemStack chest;
    private static ItemStack legs;
    private static ItemStack boot;

    public static void prepare() {
        sword = new GearItem(Material.IRON_SWORD, "§6Sword", null).asItemStack();
        rod = new GearItem(Material.FISHING_ROD, "§6Fishing Rod", null).asItemStack();
        steel = new GearItem(Material.FLINT_AND_STEEL, "§6Flint n' Steel", null).asItemStack();
        bow = new GearItem(Material.BOW, "§6Bow", null, Enchantment.ARROW_INFINITE).asItemStack();
        ks = new GearItem(Material.BOOK, "§cKillstreak", new String[] {
                "Click to open killstreak menu"
        }).asItemStack();
        hub = new GearItem(Material.getMaterial(347), "§4Return to Hub", new String[] {
                "Click to warp back to the hub"
        }).asItemStack();
        arrow = new GearItem(Material.ARROW, "§7Arrow", null).asItemStack();

        helm = new GearItem(Material.CHAINMAIL_HELMET, "§eWarrior's Helm", null).asItemStack();
        chest = new GearItem(Material.IRON_CHESTPLATE, "§eTunic of Power", null).asItemStack();
        legs = new GearItem(Material.IRON_LEGGINGS, "§eBreezy Knees", null).asItemStack();
        boot = new GearItem(Material.IRON_BOOTS, "§eTitan's Nikes", null).asItemStack();
    }

    public static void give(Player player) {
        PlayerInventory inv = player.getInventory();

        inv.setItem(0, sword);
        inv.setItem(1, rod);
        inv.setItem(2, steel);
        inv.setItem(3, bow);
        inv.setItem(7, ks);
        inv.setItem(8, hub);
        inv.setItem(9, arrow);

        inv.setHelmet(helm);
        inv.setChestplate(chest);
        inv.setLeggings(legs);
        inv.setBoots(boot);
    }

}