package net.thearc.ffa.game.pvp.infraction;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class InfractionManager {

    private static List<Infraction> infractions = new ArrayList<Infraction>();

    public static List<Infraction> getInfractions() {
        return infractions;
    }

    public static void register(Infraction infraction) {
        infractions.add(infraction);
    }

    public static void unregister(Infraction infraction) {
        infractions.remove(infraction);
    }

    public static Infraction getLastest(Player player) {
        for (Infraction inf : getInfractions()) {
            if (inf.isKiller(player) || inf.isWhoDied(player)) {
                return inf;
            }
        }
        return null;
    }

    public static List<Infraction> getAll(Player player) {
        List<Infraction> infs = new ArrayList<Infraction>();
        for (Infraction inf : getInfractions()) {
            if (inf.isKiller(player) || inf.isWhoDied(player)) {
                infs.add(inf);
            }
        }
        return infs;
    }

}