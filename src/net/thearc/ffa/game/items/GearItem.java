package net.thearc.ffa.game.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GearItem {

    private String name;
    private String[] lore;
    private Material mat;
    private Enchantment ench;

    public GearItem(Material material, String name, String[] lore) {
        this.mat = material;
        this.name = name;
        this.lore = lore;
        this.ench = null;
    }

    public GearItem(Material material, String name, String[] lore, Enchantment enchantment) {
        this.mat = material;
        this.name = name;
        this.lore = lore;
        this.ench = enchantment;
    }

    public ItemStack asItemStack() {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        if (ench != null)
        meta.addEnchant(ench, 1, true);

        if (lore != null) {
            List<String> list = new ArrayList<String>();
            for (String s : lore) {
                list.add(" §7" + s);
            }

            meta.setLore(list);
        }

        item.setItemMeta(meta);
        return item;
    }

}
