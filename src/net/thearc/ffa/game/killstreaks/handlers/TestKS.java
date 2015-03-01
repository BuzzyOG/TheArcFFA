package net.thearc.ffa.game.killstreaks.handlers;

import net.thearc.ffa.game.killstreaks.KSManager;
import net.thearc.ffa.game.killstreaks.Killstreak;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TestKS implements Listener {

    public Killstreak ks;

    @EventHandler
    public void onPurchase(InventoryClickEvent e) {
        if (e.getInventory().getTitle() != KSManager.getMenu().getTitle()) return;
        e.setCancelled(true);

        if (e.getCurrentItem().getType() != ks.getMaterial()) return;

        Player p = (Player) e.getWhoClicked();
        p.sendMessage("§9§lFFA §8l» §7You have purchased the §a" + ks.getName() + " §7killstreak.");
        p.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
    }

}
