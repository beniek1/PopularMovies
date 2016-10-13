package com.ojdudu.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents movie and it's data.
 */

public class Movie implements Parcelable {

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



    public Movie(String title, String posterURL, String overview, String releaseDate, double ranking) {
        this.title = title;
        this.posterURL = posterURL;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.ranking = ranking;
    }

    /**
     * Create object from parcel.
     * @param in Parcel
     */
    public Movie(Parcel in) {
        this.title = in.readString();
        this.posterURL = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.ranking = in.readDouble();
    }

    //Unused
    @Override
    public int describeContents() {
        return 0;
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //Write order needs to match read order!
        dest.writeString(this.title);
        dest.writeString(this.posterURL);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeDouble(this.ranking);

    }

    /**
     * Source: https://developer.android.com/reference/android/os/Parcelable.html
     */
    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
