package org.kent;

import java.util.ArrayList;
import java.util.List;

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
     * Print details of all the tracks.
     */
    public void printList() {
    }

    /**
     * Print details of all the tracks of the given artist.
     *
     * @param artist The artist to look for.
     */
    public void printTracksBy(String artist) {
    }

    /**
     * Print all the tracks with a given string in the title.
     *
     * @param substring The string to look for in the track's title.
     */
    public void printTracksWith(String substring) {
    }

    /**
     * Print the publication years of all the songs in the library, in order.
     */
    public void printYears() {
    }

    /**
     * Return a total track time of all tracks by a given artist.
     *
     * @param artist The artist to look for
     * @return The total playing time (in seconds) of all songs of this artist
     */
    public int getTimeByArtist(String artist) {
        return 0;
    }

    // ==============  PART II ===============

    /**
     * Get all tracks that are newer than a given year.
     *
     * @param year The minimum year to look for (inclusive)
     * @return A list of Tracks, all published in or after the year
     */
    public List<Track> getNewerThan(int year) {
        return null;
    }

    /**
     * Find the longest song.
     *
     * @return The track with the longest playing time.
     */
    public Track getLongestSong() {
        return null;
    }

    /**
     * Remove all songs from the track list with a rating below 3.
     */
    public void removeUnwanted() {
    }
}