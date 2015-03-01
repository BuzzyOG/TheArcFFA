package net.thearc.ffa.utility.npc;

import net.thearc.ffa.Main;
import net.thearc.ffa.utility.common.UtilVector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class NPC implements Listener {

    private LivingEntity entity;
    private EntityType type;

    private Location loc;

    private String name;
    private String cmdLabel;
    private String msg;

    private boolean stationary;
    private boolean damageable;

    public NPC(EntityType entityType) {
        this.type = entityType;
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
        NPCManager.register(this);
    }

    private void keepInPlace() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                if (getEntity().isDead()) return;
                if (!isStationary()) return;
                getEntity().setVelocity(UtilVector.getNullVector());

                if (getType() == EntityType.WITHER) {
                    Wither w = (Wither) getEntity();
                    w.setTarget(null);
                }
            }

        }, 0L, 1L);
    }

    public void spawn(Location location) {
        this.loc = location;

        this.entity = (LivingEntity) location.getWorld().spawnEntity(getLocation(), getType());
        keepInPlace();
    }

    public void kill() {
        this.loc = null;

        getEntity().setHealth(0D);
        this.entity = null;
    }

    public LivingEntity getEntity() {
        return this.entity;
    }

    public EntityType getType() {
        return this.type;
    }

    public Location getLocation() {
        return this.loc;
    }

    public String getName() {
        return this.name;
    }

    public String getCommandLabel() {
        return this.cmdLabel;
    }

    public String getMessage() {
        return this.msg;
    }

    public void move(Location location) {
        getEntity().teleport(location);
        this.loc = location;
    }

    public void setName(String name) {
        this.entity.setCustomName(name);
        this.name = name;
    }

    public void setCommandLabel(String commandLabel) {
        this.cmdLabel = commandLabel;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public void setStationary(boolean value) {
        this.stationary = value;
    }

    public void setDamageable(boolean value) {
        this.damageable = value;
    }

    public boolean isStationary() {
        return this.stationary;
    }

    public boolean isDamageable() {
        return this.damageable;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity().getUniqueId() != getEntity().getUniqueId()) return;
        if (isDamageable()) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Entity en = e.getRightClicked();
        if (en.getUniqueId() == getEntity().getUniqueId()) {
            p.sendMessage(getMessage());

            if (getType() == EntityType.VILLAGER ||
                    getType() == EntityType.HORSE) e.setCancelled(true);

            if (getCommandLabel() == null) return;

            p.performCommand(getCommandLabel());

        }
    }

}