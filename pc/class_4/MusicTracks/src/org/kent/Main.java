package org.kent;

/**
 * Test harness for MusicLibrary.
 *
 * @author mik
 */
public class Main {
    public static void main(String[] args) {
        var lib = new MusicLibrary();

        // ==============  PART I ===============

        System.out.println("==== Full list ===");
        lib.printList();

        System.out.println("==== By Tom Waits ===");
        lib.printTracksBy("Tom Waits");

        System.out.println("==== Tracks with 'Henry' and 'Love' ===");
        lib.printTracksWith("Henry");
        lib.printTracksWith("Love");

        System.out.println("==== All years ===");
        lib.printYears();

        System.out.println("==== Total time ===");
        System.out.println("Total time by Etta James: " + lib.getTimeByArtist("Etta James"));
        System.out.println("Total time by Traveling Wilburys: " + lib.getTimeByArtist("Traveling Wilburys"));

        // ==============  PART II ===============
        System.out.println("==== List songs newer than... ===");
        var newTracks = lib.getNewerThan(1990);
        System.out.println("Songs newer than 1990: ");
        lib.formatPrintList(newTracks);

        System.out.println("==== Longest song ===");
        System.out.println("Longest song: " + lib.getLongestSong());

        System.out.println("==== Remove songs with rating below 3 ===");
        lib.removeUnwanted();
        lib.printList();

        System.out.println("==== All Tracks in or older than 1967 and a running time not more than 200 ===");
        lib.printOldAndShort(1967, 200);

        System.out.println("==== Get the publication year of the first track found by Etta James");
        System.out.println(lib.getFirstYearOf("Etta James"));

        System.out.println("==== 3 Tracks by Etta James ====");
        lib.printThreeOf("Etta James");

        System.out.println("==== The highest play count of any tracks ====");
        System.out.println(lib.getMaxPlayCount());

        System.out.println("==== Tracks with starting \"I\" ====");
        lib.printFirstWith("I");

        System.out.println("==== the number of Tracks which published in or after 2000 ====");
        System.out.println(lib.countNewerThan(1970));
    }

}