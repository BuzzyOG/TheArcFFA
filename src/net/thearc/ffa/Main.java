package net.thearc.ffa;

import net.thearc.ffa.game.FFA;
import net.thearc.ffa.game.formatting.Chatting;
import net.thearc.ffa.game.formatting.Hunger;
import net.thearc.ffa.game.formatting.JoinQuit;
import net.thearc.ffa.game.items.GameInventory;
import net.thearc.ffa.game.killstreaks.KSManager;
import net.thearc.ffa.game.moderation.BanCmd;
import net.thearc.ffa.game.pvp.BattleHandler;
import net.thearc.ffa.game.pvp.infraction.InfractionHandler;
import net.thearc.ffa.game.pvp.infraction.command.PvplogCmd;
import net.thearc.ffa.game.spawns.command.SpawnCmd;
import net.thearc.ffa.utility.npc.NPCManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    public static Main main;
    public static Plugin getInstance() { return main; }

    @Override
    public void onEnable() {
        main = this;
        loadConfig("ArcFFA");

        FFA.setOnline(true);
        FFA.setPrefix("§9§lFFA §8§l» §7");
        GameInventory.prepare();

        KSManager.populateKillstreaks();
        KSManager.createMenu();

        NPCManager.spawnAll();
        InfractionHandler.startRelay();

        getServer().getPluginManager().registerEvents(new Hunger(), this);
        getServer().getPluginManager().registerEvents(new JoinQuit(), this);
        getServer().getPluginManager().registerEvents(new Chatting(), this);
        getServer().getPluginManager().registerEvents(new BattleHandler(), this);
        getServer().getPluginManager().registerEvents(new InfractionHandler(), this);

        BanCmd.registerArgs();
        SpawnCmd.registerArgs();
        PvplogCmd.registerArgs();

        getCommand("ban").setExecutor(new BanCmd());
        getCommand("spawn").setExecutor(new SpawnCmd());
        getCommand("pvplog").setExecutor(new PvplogCmd());
    }

    @Override
    public void onDisable() {
        NPCManager.killall();
    }

    public static void loadConfig(String name) {
        new File("plugins/" + name).mkdir();

        File file = new File("plugins/" + name + "/config.yml");

        if (!file.exists())
            try {
                file.createNewFile();
                System.out.println("");
                System.out.println("[" + name + "]: " + ChatColor.GOLD + "Successfully created config.yml file!");

                Main.getInstance().getConfig().options().copyDefaults(true);
                Main.getInstance().saveConfig();

                System.out.println("[" + name + "]: " + ChatColor.GOLD + "Copied default configuration settings.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("");
                System.out.println("[" + name + "]: " + ChatColor.DARK_RED + "Could not create config file! The error is above.");
            }
    }

}
