package com.ojdudu.popularmovies;

/**
 * Represents movie and it's data.
 */

public class Movie {

    private final String name;


    public Movie(String name) {
        this.name = name;
    }

    /**
     * @return Movie name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}
