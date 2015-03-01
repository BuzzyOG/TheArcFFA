package net.thearc.ffa.game.achievements;

import net.thearc.ffa.game.achievements.handlers.KillAchieve;

public class Running {

    public static Achievement kill = new Achievement("Get a Kill", "Take your first victim!", 100, new KillAchieve());

}
