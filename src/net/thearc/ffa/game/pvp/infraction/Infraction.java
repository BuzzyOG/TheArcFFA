package net.thearc.ffa.game.pvp.infraction;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Infraction {

    private Player dead;
    private Player killer;
    private ItemStack weap;
    private String time;

    public Infraction(Player dead, Player killer, ItemStack weapon, String time) {
        this.dead = dead;
        this.killer = killer;
        this.weap = weapon;
        this.time = time;

        InfractionManager.register(this);
    }

    public Player getWhoDied() {
        return this.dead;
    }

    public Player getKiller() {
        return this.killer;
    }

    public ItemStack getWeapon() {
        return this.weap;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isWhoDied(Player player) {
        return player == getWhoDied();
    }

    public boolean isKiller(Player player) {
        return player == getKiller();
    }

    public boolean isWeapon(ItemStack item) {
        return item == getWeapon();
    }

}
