package net.thearc.ffa.game.spawns;

import net.thearc.ffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Random;

public class SpawnManager {

    public static int getSpawnCount() {
        return Main.getInstance().getConfig().getConfigurationSection("spawns").getKeys(false).size();
    }

    public static Location getMainSpawn() {
        if (Main.getInstance().getConfig().getConfigurationSection("spawns." + "main") == null) return null;
        World w = Bukkit.getWorld(Main.getInstance().getConfig().getString("spawns." + "main" + ".world"));
        double x = Main.getInstance().getConfig().getDouble("spawns." + "main" + ".x");
        double y = Main.getInstance().getConfig().getDouble("spawns." + "main" + ".y");
        double z = Main.getInstance().getConfig().getDouble("spawns." + "main" + ".z");
        int pitch = Main.getInstance().getConfig().getInt("spawns." + "main" + ".pitch");
        int yaw = Main.getInstance().getConfig().getInt("spawns." + "main" + ".yaw");
        return new Location(w, x, y, z, pitch, yaw);
    }

    public static Location getSpawn(int indexID) {
        if (Main.getInstance().getConfig().getConfigurationSection("spawns." + indexID) == null) return null;
        World w = Bukkit.getWorld(Main.getInstance().getConfig().getString("spawns." + indexID + ".world"));
        double x = Main.getInstance().getConfig().getDouble("spawns." + indexID + ".x");
        double y = Main.getInstance().getConfig().getDouble("spawns." + indexID + ".y");
        double z = Main.getInstance().getConfig().getDouble("spawns." + indexID + ".z");
        int pitch = Main.getInstance().getConfig().getInt("spawns." + indexID + ".pitch");
        int yaw = Main.getInstance().getConfig().getInt("spawns." + indexID + ".yaw");
        return new Location(w, x, y, z, pitch, yaw);
    }

    public static void addSpawn(Location location) {
        Main.getInstance().getConfig().set("spawns." + (getSpawnCount() + 1) + ".world", location.getWorld().getName());
        Main.getInstance().getConfig().set("spawns." + (getSpawnCount() + 1) + ".x", location.getX());
        Main.getInstance().getConfig().set("spawns." + (getSpawnCount() + 1) + ".y", location.getY());
        Main.getInstance().getConfig().set("spawns." + (getSpawnCount() + 1) + ".z", location.getZ());
        Main.getInstance().getConfig().set("spawns." + (getSpawnCount() + 1) + ".pitch", location.getPitch());
        Main.getInstance().getConfig().set("spawns." + (getSpawnCount() + 1) + ".yaw", location.getYaw());
        Main.getInstance().saveConfig();
        System.out.println("[ArcFFA]: Spawns > Added new spawn in world " + location.getWorld().getName());
    }

    public static void removeSpawn(int indexID) {
        if (Main.getInstance().getConfig().getConfigurationSection("spawns." + indexID) == null) return;
        Main.getInstance().getConfig().set("spawns." + indexID, null);
        Main.getInstance().saveConfig();
        System.out.println("[ArcFFA]: Spawns > Removed spawn. Spawn index = " + indexID);
    }

    public static void setMainSpawn(Location location) {
        Main.getInstance().getConfig().set("spawns." + "main" + ".world", location.getWorld().getName());
        Main.getInstance().getConfig().set("spawns." + "main" + ".x", location.getX());
        Main.getInstance().getConfig().set("spawns." + "main" + ".y", location.getY());
        Main.getInstance().getConfig().set("spawns." + "main" + ".z", location.getZ());
        Main.getInstance().getConfig().set("spawns." + "main" + ".pitch", location.getPitch());
        Main.getInstance().getConfig().set("spawns." + "main" + ".yaw", location.getYaw());
        Main.getInstance().saveConfig();
        System.out.println("[ArcFFA]: Spawns > Set main spawn in world " + location.getWorld().getName());
    }

    public static void setSpawn(int indexID, Location location) {
        Main.getInstance().getConfig().set("spawns." + indexID + ".world", location.getWorld().getName());
        Main.getInstance().getConfig().set("spawns." + indexID + ".x", location.getX());
        Main.getInstance().getConfig().set("spawns." + indexID + ".y", location.getY());
        Main.getInstance().getConfig().set("spawns." + indexID + ".z", location.getZ());
        Main.getInstance().getConfig().set("spawns." + indexID + ".pitch", location.getPitch());
        Main.getInstance().getConfig().set("spawns." + indexID + ".yaw", location.getYaw());
        Main.getInstance().saveConfig();
        System.out.println("[ArcFFA]: Spawns > Set spawn " + indexID + " in world " + location.getWorld().getName());
    }

    public static Location getRandomSpawn() {
        Random r = new Random();
        return getSpawn(r.nextInt(getSpawnCount() + 1));
    }

}
