package be.koencorp.bookApp.tools;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * ConsolePrintTool
 * For special console printing needs
 *
 * @version 2.0.1 , 10-may-2020
 */
public final class ConsolePrintTool {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private ConsolePrintTool() {
    }

    public static void printTitle(String title, char type) {
        System.out.println(title);
        System.out.println(String.valueOf(type).repeat(title.length()));
    }

    public static void printTitle(String title) {
        printTitle(title, '-');
    }


    public static String formatTime(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(millis);

    }

    public static void printHeading() {
        System.out.println(ANSI_YELLOW + String.format("%15s |%20s|%14s|%10s|%10s|%5s",
                "Title", "Author", "ISBN", "Revision", "Type", "Fiction") + ANSI_RESET);
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public static void printEnter() {
        System.out.println("\r");
    }
}
