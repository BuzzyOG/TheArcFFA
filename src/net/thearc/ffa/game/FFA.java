package net.thearc.ffa.game;

public class FFA {

    private static String pre;
    private static boolean online;

    public static String getPrefix() {
        return pre;
    }

    public static void setPrefix(String prefix) {
        pre = prefix;
    }

    public static void setOnline(boolean value) {
        online = value;
    }

    public static boolean isOnline() {
        return online;
    }

}
