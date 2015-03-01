package net.thearc.ffa.game.pvp;

import net.thearc.ffa.game.items.GameInventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class BattleHandler implements Listener {

    @EventHandler
    public void onRespawn(final PlayerRespawnEvent e) {
        GameInventory.give(e.getPlayer());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setKeepInventory(true);
        e.setKeepLevel(true);
        e.getEntity().getInventory().clear();
        e.getEntity().getKiller().setLevel(e.getEntity().getKiller().getLevel());
        e.getEntity().setLevel(0);
        GameInventory.give(e.getEntity().getKiller());

        e.setDeathMessage("§c[DEATH] §7" + e.getEntity().getKiller().getName() + " §6has slain §7" + e.getEntity().getName());
        e.getEntity().sendMessage("§c[INFO] §7Your killer had §e10.0 hearts");
    }

}
