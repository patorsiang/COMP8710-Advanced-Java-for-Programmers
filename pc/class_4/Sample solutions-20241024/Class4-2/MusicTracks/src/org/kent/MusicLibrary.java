package org.kent;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

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

    /**
     * Filter the tracks by a given Predicate     *
     */
    private List<Track> filterTracksBy(Predicate<Track> predicate) {

        var list = new ArrayList<Track>();
        for (var t: tracks) {
            if (predicate.test(t)) {
                list.add(t);
            }
        }
        return list;
    }

    /**
     * print a filtered list by a give Predicate
     */
    private void printTracksFilterBy(Predicate<Track> predicate) {

        var list = filterTracksBy(predicate);
        for (var track: list) {
            System.out.println(track);
        }
    }

    /**
     * Print details of all the tracks.
     */
    public void printList() {

        printTracksFilterBy(t -> true);
    }

    /**
     * Print details of all the tracks of the given artist.
     *
     * @param artist The artist to look for.
     */
    public void printTracksBy(String artist) {

        printTracksFilterBy(t -> t.artist().equals(artist));
    }

    /**
     * Print all the tracks with a given string in the title.
     *
     * @param substring The string to look for in the track's title.
     */
    public void printTracksWith(String substring) {

        printTracksFilterBy(t -> t.title().contains(substring));
    }

    /**
     * Print the publication years of all the songs in the library, in order.
     */
    public void printYears() {

        tracks.sort(Comparator.comparing(Track::year));
        tracks.forEach(t -> System.out.println(t.year()));
    }

    /**
     * Return a total track time of all tracks by a given artist.
     *
     * @param artist The artist to look for
     * @return The total playing time (in seconds) of all songs of this artist
     */
    public int getTimeByArtist(String artist) {

        var list = filterTracksBy(t -> t.artist().equals(artist));

        var total = new AtomicInteger();
        list.forEach(t -> total.addAndGet(t.time()));
        return total.get();
    }

    // ==============  PART II ===============

    /**
     * Get all tracks that are newer than a given year.
     *
     * @param year The minimum year to look for (inclusive)
     * @return A list of Tracks, all published in or after the year
     */
    public List<Track> getNewerThan(int year) {

        return filterTracksBy(t -> t.year() >= year);
    }

    /**
     * Find the longest song.
     *
     * @return The track with the longest playing time.
     */
    public Track getLongestSong() {

        tracks.sort(Comparator.comparing(Track::time).reversed());
        return tracks.get(0);
    }

    /**
     * Remove all songs from the track list with a rating below 3.
     */
    public void removeUnwanted() {

        tracks.removeIf(t -> t.rating() < 3);
    }
}