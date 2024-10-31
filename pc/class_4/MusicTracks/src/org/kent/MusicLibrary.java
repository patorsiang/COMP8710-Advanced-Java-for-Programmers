package org.kent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Some functions on a music track library.
 * Tracks are defined in a Track class; this class processes the library using
 * some of the track details.
 * <p>
 * Starting point for class exercises for CO871, University of Kent.
 *
 * @author (fill in your name)
 * @version 0.1
 */
public class MusicLibrary {
    private final ArrayList<Track> tracks;

    /**
     * Create an AnimalMonitor.
     */
    public MusicLibrary() {
        this.tracks = new ArrayList<>();
        addTracks("tracks.csv");
    }

    /**
     * Add the tracks stored in the given filename to the current list.
     *
     * @param filename A CSV file of Track records.
     */
    public final void addTracks(String filename) {
        var reader = new TrackReader();
        tracks.addAll(reader.getTracks(filename));
    }

    // ==============  PART I ===============

    public void formatPrintList(List<Track> tracks) {
        if (tracks.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
            System.out.printf("| %-40s | %-30s | %4s | %4s | %10s | %6s |%n", "Title", "Artist", "Year", "Time", "Play Count", "Rating");
            System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
            for (var track : tracks) {
                System.out.printf("| %-40s | %-30s | %4s | %4s | %10s | %6s |%n", track.title(), track.artist(), track.year(), track.time(), track.playCount(), track.rating());
            }
            System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
        }
    }

    /**
     * Print details of all the tracks.
     */
    public void printList() {
        formatPrintList(tracks);
    }

    /**
     * Print details of all the tracks of the given artist.
     *
     * @param artist The artist to look for.
     */
    public void printTracksBy(String artist) {
        List<Track> tracksByArtist = tracks.stream().filter(track -> track.artist().equals(artist)).toList();
        formatPrintList(tracksByArtist);
    }

    /**
     * Print all the tracks with a given string in the title.
     *
     * @param substring The string to look for in the track's title.
     */
    public void printTracksWith(String substring) {
        System.out.println("Search " + '"' + substring + '"' + ":");
        List<Track> tracksWithSubstring = tracks.stream().filter(track -> track.title().contains(substring)).toList();
        formatPrintList(tracksWithSubstring);
    }

    /**
     * Print the publication years of all the songs in the library, in order.
     */
    public void printYears() {
        System.out.printf("-------%n");
        System.out.printf("| %4s | %n", "Year");
        System.out.printf("-------%n");
        tracks.stream().map(Track::year).collect(Collectors.toSet()).stream().sorted().forEach(year -> System.out.printf("| %4d | %n", year));
        System.out.printf("-------%n");
    }

    /**
     * Return a total track time of all tracks by a given artist.
     *
     * @param artist The artist to look for
     * @return The total playing time (in seconds) of all songs of this artist
     */
    public int getTimeByArtist(String artist) {
        return tracks.stream().filter(track -> track.artist().equals(artist)).mapToInt(Track::time).sum();
    }

    // ==============  PART II ===============

    /**
     * Get all tracks that are newer than a given year.
     *
     * @param year The minimum year to look for (inclusive)
     * @return A list of Tracks, all published in or after the year
     */
    public List<Track> getNewerThan(int year) {
        return tracks.stream().filter(track -> track.year() >= year).toList();
    }

    /**
     * Find the longest song.
     *
     * @return The track with the longest playing time.
     */
    public Track getLongestSong() {
        return tracks.stream().max(Comparator.comparingInt(Track::time)).orElse(null);
    }

    /**
     * Remove all songs from the track list with a rating below 3.
     */
    public void removeUnwanted() {
        tracks.removeIf(track -> track.rating() < 3);
    }

    public void printOldAndShort(int year, int maxTime) {
        var list = tracks.stream().filter(track -> track.year() <= year && track.time() <= maxTime).toList();

        formatPrintList(list);
    }

    public int getFirstYearOf(String artist) {
        var first = tracks.stream().filter(track -> track.artist().equals(artist)).min(Comparator.comparingInt(Track::year));
        return first.map(Track::year).orElse(-1);
    }

    public void printThreeOf(String artist) {
        formatPrintList(tracks.stream().filter(track -> track.artist().equals(artist)).sorted(Comparator.comparingInt(Track::year)).limit(3).toList());
    }

    public int getMaxPlayCount() {
       return tracks.stream().max(Comparator.comparingInt(Track::playCount)).map(Track::playCount).orElse(-1);
    }

    void printFirstWith(String substring) {
        formatPrintList(tracks.stream().filter(track -> track.title().startsWith(substring)).toList());
    }

    long countNewerThan(int year) {
        return tracks.stream().filter(track -> track.year() >= year).count();
    }
}