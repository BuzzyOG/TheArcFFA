package net.thearc.ffa.game.formatting;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chatting implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.getPlayer().getName().equalsIgnoreCase("Zyraun")) {
            e.setFormat("§6[FFA] §8| §5Dev §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("duhniinja")) {
            e.setFormat("§6[FFA] §8| §4Owner §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("sipofjava")) {
            e.setFormat("§6[FFA] §8| §4Owner §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("statix")) {
            e.setFormat("§6[FFA] §8| §5Dev §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("nightmarefuel")) {
            e.setFormat("§6[FFA] §8| §4Owner §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("xkryptonic")) {
            e.setFormat("§6[FFA] §8| §5Dev §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("prophetofanger")) {
            e.setFormat("§6[FFA] §8| §bBeta §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
        if (e.getPlayer().getName().equalsIgnoreCase("prophetofmtndew")) {
            e.setFormat("§6[FFA] §8| §bBeta §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
        } else
            e.setFormat("§6[FFA] §7" + e.getPlayer().getName() + " §8» §f" + e.getMessage());
    }

}
