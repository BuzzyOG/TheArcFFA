package net.thearc.ffa.utility.common;

import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.*;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkUtil {

    public static void launchRandomFirework(Location location) {
        FireworkEffect.Builder builder = FireworkEffect.builder();

        if (RandomUtils.nextInt(3) == 0) {
            builder.withTrail();
        } else if (RandomUtils.nextInt(2) == 0) {
            builder.withFlicker();
        }

        builder.with(org.bukkit.FireworkEffect.Type.values()[RandomUtils.nextInt(org.bukkit.FireworkEffect.Type.values().length)]);

        int colorCount = 17;

        builder.withColor(Color.fromRGB(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));

        while (RandomUtils.nextInt(colorCount) != 0) {
            builder.withColor(Color.fromRGB(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));
            colorCount--;
        }

        Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
        FireworkMeta data = firework.getFireworkMeta();
        data.addEffects(new FireworkEffect[]{builder.build()});
        data.setPower(RandomUtils.nextInt(3));
        firework.setFireworkMeta(data);
    }

    public static Firework getRandomFirework(Location location) {
        FireworkEffect.Builder builder = FireworkEffect.builder();

        if (RandomUtils.nextInt(3) == 0) {
            builder.withTrail();
        } else if (RandomUtils.nextInt(2) == 0) {
            builder.withFlicker();
        }

        builder.with(org.bukkit.FireworkEffect.Type.values()[RandomUtils.nextInt(org.bukkit.FireworkEffect.Type.values().length)]);

        int colorCount = 17;

        builder.withColor(Color.fromRGB(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));

        while (RandomUtils.nextInt(colorCount) != 0) {
            builder.withColor(Color.fromRGB(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));
            colorCount--;
        }

        Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
        FireworkMeta data = firework.getFireworkMeta();
        data.addEffects(new FireworkEffect[]{builder.build()});
        data.setPower(RandomUtils.nextInt(3));
        firework.setFireworkMeta(data);
        return firework;
    }

    public static void launchBlankFirework(Location location) {
        if (Bukkit.getWorlds().contains(location.getWorld()))
            location.getWorld().spawn(location, Firework.class);
    }

}