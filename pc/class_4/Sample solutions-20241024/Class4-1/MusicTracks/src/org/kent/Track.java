package org.kent;

/**
 * Details of a track in our music library.
 *
 * @author Yang He
 * @version Sept 2022
 */
public record Track(
        // The track's artist.
        String artist,
        // The track title.
        String title,
        // Year of publication.
        int year,
        // Running time (in seconds).
        int time,
        // Total playCount.
        int playCount,
        // Personal rating (1..5).
        int rating) {

    /**
     * Return a string containing details of the animal, the number seen,
     * where they were seen, who spotted them and when.
     *
     * @return A string giving details of the sighting.
     */
    @Override
    public String toString() {

        return artist +
               ": " + title +
               " (" + year +
               ") " + time +
               " seconds, " + playCount +
               " plays, rating: " + rating;
    }
}