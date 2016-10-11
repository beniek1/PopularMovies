package com.ojdudu.popularmovies;

/**
 * Represents movie and it's data.
 */

public class Movie {

    /**
     * Movie title.
     */
    private final String title;

    /**
     * Address for movie background picture.
     */
    private final String backdropAddress;


    public Movie(String title, String backdropAddress) {
        this.title = title;
        this.backdropAddress = backdropAddress;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", backdropAddress='" + backdropAddress + '\'' +
                '}';
    }

    /**
     * @return Movie background image url.
     */
    public String getBackdropAddress() {
        return backdropAddress;
    }

    /**
     * @return Movie title.
     */
    public String getTitle() {
        return title;
    }
}
