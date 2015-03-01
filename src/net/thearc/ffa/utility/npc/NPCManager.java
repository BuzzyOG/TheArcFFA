package net.thearc.ffa.utility.npc;

import java.util.ArrayList;
import java.util.List;

public class NPCManager {

    private static List<NPC> npcs = new ArrayList<NPC>();

    public static List<NPC> getNPCs() {
        return npcs;
    }

    public static void register(NPC npc) {
        npcs.add(npc);
    }

    public static void unregister(NPC npc) {
        npcs.remove(npc);
    }

    public static void spawnAll() {
        // ...
    }

    public static void killall() {
        for (NPC npc : getNPCs()) {
            unregister(npc);
            npc.kill();
        }
        System.out.println("[ArcFFA]: NPC > Killed all living NPCs.");
    }

}
