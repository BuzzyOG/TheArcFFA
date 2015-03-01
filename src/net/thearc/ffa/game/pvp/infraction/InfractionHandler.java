package net.thearc.ffa.game.pvp.infraction;

import net.thearc.ffa.Main;
import net.thearc.ffa.utility.common.UtilTime;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class InfractionHandler implements Listener {

    private static int infractionsCount = 0;

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Infraction inf = new Infraction(e.getEntity(), e.getEntity().getKiller(), e.getEntity().getKiller().getItemInHand(), UtilTime.now());
        infractionsCount++;
    }

    public static void startRelay() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                System.out.println("[ArcFFA]: Infractions > Logged (" + infractionsCount + ") in the last 10 minutes.");
                infractionsCount = 0;
            }

        }, 20L, 10 * 20 * 60); // 10 minutes
    }

}