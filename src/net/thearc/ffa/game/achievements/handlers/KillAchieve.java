package net.thearc.ffa.game.achievements.handlers;

import net.thearc.ffa.game.achievements.Running;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillAchieve implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getKiller();
        if (Running.kill.hasCompleted(p)) return;
        Running.kill.give(p);
    }

}
