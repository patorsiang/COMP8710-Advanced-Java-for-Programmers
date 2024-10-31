package org.kent;

import java.util.*;

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

        for (var track: tracks) {
            System.out.println(track);
        }
    }

    /**
     * Print details of all the tracks of the given artist.
     *
     * @param artist The artist to look for.
     */
    public void printTracksBy(String artist) {

        for (var track: tracks) {
            if (track.artist().equals(artist)) {
                System.out.println(track);
            }
        }
    }

    /**
     * Print all the tracks with a given string in the title.
     *
     * @param substring The string to look for in the track's title.
     */
    public void printTracksWith(String substring) {

        for (var track: tracks) {
            if (track.title().contains(substring)) {
                System.out.println(track);
            }
        }
    }

    /**
     * Print the publication years of all the songs in the library, in order.
     */
    public void printYears() {

        var comparator = new Comparator<Track>() {
            @Override
            public int compare(Track t1, Track t2) {

                return t1.year() - t2.year();
            }
        };

        tracks.sort(comparator);
        for (var track: tracks) {
            System.out.println(track.year());
        }
    }

    /**
     * Return a total track time of all tracks by a given artist.
     *
     * @param artist The artist to look for
     * @return The total playing time (in seconds) of all songs of this artist
     */
    public int getTimeByArtist(String artist) {

        var total = 0;
        for (var t: tracks) {
            if (t.artist().equals(artist)) {
                total += t.time();
            }
        }
        return total;
    }

    // ==============  PART II ===============

    /**
     * Get all tracks that are newer than a given year.
     *
     * @param year The minimum year to look for (inclusive)
     * @return A list of Tracks, all published in or after the year
     */
    public List<Track> getNewerThan(int year) {

        var list = new ArrayList<Track>();
        for (var t: tracks) {
            if (t.year() >= year) {
                list.add(t);
            }
        }
        return list;
    }

    /**
     * Find the longest song.
     *
     * @return The track with the longest playing time.
     */
    public Track getLongestSong() {

        var max = 0;
        Track track = null;
        for (var t: tracks) {
            if (t.time() > max) {
                max = t.time();
                track = t;
            }
        }
        return track;
    }

    /**
     * Remove all songs from the track list with a rating below 3.
     */
    public void removeUnwanted() {

        var it = tracks.iterator();
        while (it.hasNext()) {
            if (it.next().rating() < 3) {
                it.remove();
            }
        }
    }
}