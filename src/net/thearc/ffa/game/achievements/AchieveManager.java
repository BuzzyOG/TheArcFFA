package net.thearc.ffa.game.achievements;

import java.util.ArrayList;
import java.util.List;

public class AchieveManager {

    public static List<Achievement> achievements = new ArrayList<Achievement>();

    public static List<Achievement> getAchievements() {
        return achievements;
    }

    public static void register() {
        // ...
    }

}