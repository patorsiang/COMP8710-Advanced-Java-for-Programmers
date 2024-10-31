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
    int rating) {}