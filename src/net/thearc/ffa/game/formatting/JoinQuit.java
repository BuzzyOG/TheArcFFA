package net.thearc.ffa.game.formatting;

import net.thearc.ffa.game.items.GameInventory;
import net.thearc.ffa.game.spawns.SpawnManager;
import net.thearc.ffa.utility.common.FireworkUtil;
import net.thearc.ffa.utility.common.PacketUtil;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("§6[FFA]  §7" + e.getPlayer().getName() + " §ehas joined.");
        e.getPlayer().teleport(SpawnManager.getMainSpawn());
        FireworkUtil.launchRandomFirework(SpawnManager.getMainSpawn());
        PacketUtil.sendTitle(e.getPlayer(), "§6§lThe Arc", "§7You are now playing Free-For-All", 1, 2, 1);
        PacketUtil.sendHeaderAndFooter(e.getPlayer(), "§6The Arc Network   §eFree-For-All", "§7Visit §6www.TheArcMC.net §7for Forums, News, and Shop");
        GameInventory.give(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("§6[FFA]  §7" + e.getPlayer().getName() + " §ehas left.");
    }

}
