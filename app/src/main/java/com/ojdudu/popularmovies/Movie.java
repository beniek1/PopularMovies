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
     * Address for movie posterpicture.
     */
    private final String posterURL;


    public Movie(String title, String backdropAddress) {
        this.title = title;
        this.posterURL = backdropAddress;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", posterURL='" + posterURL + '\'' +
                '}';
    }

    /**
     * @return Movie background image url.
     */
    public String getPosterURL() {
        return posterURL;
    }

    /**
     * @return Movie title.
     */
    public String getTitle() {
        return title;
    }
}
