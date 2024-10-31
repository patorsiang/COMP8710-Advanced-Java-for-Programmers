package org.kent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class to read CSV-style records of music tracks.
 *
 * @author Michael Kölling
 * @version 2015.10.13
 */
public class TrackReader {
    // How many fields are expected.
    private static final int NUMBER_OF_FIELDS = 6;
    // Index values for the fields in each record.
    private static final int ARTIST = 0,
            TRACK = 1,
            YEAR = 2,
            TIME = 3,
            PLAYCOUNT = 4,
            RATING = 5;

    /**
     * Create a TrackReader.
     */
    public TrackReader() {
    }

    /**
     * Read tracks in CSV format from the given file.
     * Return an ArrayList of Track objects created from
     * the information in the file.
     *
     * @param filename The file to be read - should be in CSV format.
     * @return A list of Tracks.
     */
    public ArrayList<Track> getTracks(String filename) {
        // Create a Track from a CSV input line.
        Function<String, Track> createTrack =
                record -> {
                    String[] parts = record.split(",");
                    if (parts.length == NUMBER_OF_FIELDS) {
                        try {
                            String artist = parts[ARTIST].trim();
                            String title = parts[TRACK].trim();
                            int year = Integer.parseInt(parts[YEAR].trim());
                            int time = Integer.parseInt(parts[TIME].trim());
                            int playCount = Integer.parseInt(parts[PLAYCOUNT].trim());
                            int rating = Integer.parseInt(parts[RATING].trim());
                            return new Track(artist, title, year, time, playCount, rating);
                        } catch (NumberFormatException e) {
                            System.out.println("Track record has a malformed integer: " + record);
                            return null;
                        }
                    } else {
                        System.out.println("Track record has the wrong number of fields: " + record);
                        return null;
                    }
                };
        ArrayList<Track> tracks;
        try {
            tracks = Files.lines(Paths.get(filename))
                    .filter(record -> record.length() > 0 && record.charAt(0) != '#')
                    .map(createTrack)
                    .filter(sighting -> sighting != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("Unable to open " + filename);
            tracks = new ArrayList<>();
        }
        return tracks;
    }
}