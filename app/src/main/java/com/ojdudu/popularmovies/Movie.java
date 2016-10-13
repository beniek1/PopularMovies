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
     * Movie poster picture address.
     */
    private final String posterURL;

    /**
     * Movie plot synopsis.
     */
    private final String overview;

    /**
     * Movie release date.
     */
    private final String releaseDate;

    /**
     * Movie average user ranking.
     */
    private final double ranking;



    public Movie(String title, String backdropAddress, String overview, String releaseDate, double ranking) {
        this.title = title;
        this.posterURL = backdropAddress;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.ranking = ranking;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", ranking=" + ranking +
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

    /**
     * @return Movie plot synopsis (overview)
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @return String representation of movie release date.
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @return Movie average ranking.
     */
    public double getRanking() {
        return ranking;
    }
}
