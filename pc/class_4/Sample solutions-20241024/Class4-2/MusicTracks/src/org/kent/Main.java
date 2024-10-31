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
        System.out.println("Songs newer than 1990: " + newTracks);

        System.out.println("==== Longest song ===");
        System.out.println("Longest song: " + lib.getLongestSong());

        System.out.println("==== Remove songs with rating below 3 ===");
        lib.removeUnwanted();
        lib.printList();
    }
}