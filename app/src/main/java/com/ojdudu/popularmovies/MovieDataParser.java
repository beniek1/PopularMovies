package com.ojdudu.popularmovies;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * DESCRIPTION:JSON parser class.
 * PURPOSE:Parse JSON into Movie object.
 * ====================
 * @author: Przemek
 * Create Date: 10/10/2016
 */
public class MovieDataParser {

    /**
     * TAG for logging purposes.
     */
    private static final String LOG_TAG = MovieDataParser.class.getSimpleName();

    /**
     * Constants for parsing The Movie Database JSON String.
     */
    private static final String RESULTS = "results";
    private static final String BACKDROP_PATH = "backdrop_path";
    private static final String TITLE = "title";

    /**
     * Formats rec
     * @param movieJSONResponse
     * @return
     */
    public static List<Movie> getMoviesFromJson(String movieJSONResponse)
        throws Exception{

        if(movieJSONResponse == null){
            String msg = "Null JSON response received!";
            Log.e(LOG_TAG, msg);
            throw new IllegalArgumentException(msg);
        }

        JSONObject json = new JSONObject(movieJSONResponse);
        JSONArray results = json.getJSONArray(RESULTS);

        return parseMovies(results);

    }

    /**
     * Parses movie data.
     * @param movies JSON array of movies.
     * @return List of parsed movies.
     */
    private static List<Movie> parseMovies(JSONArray movies) {

        List<Movie> result = new ArrayList<>();

        //Iterate through available movies
        for(int i = 0; i < movies.length(); i++){
            try {
                JSONObject movie = movies.getJSONObject(i);
                result.add(getMovieDataFromJSON(movie));

            } catch (JSONException e) {
                Log.e(LOG_TAG, String.format("Movie parsing failed for movie at index: %s", String
                        .valueOf(i)));
            }
        }

        return result;
    }

    /**
     * Parses single movie from JSON into Movie object.
     */
    private static Movie getMovieDataFromJSON(JSONObject movie) throws JSONException {

        String backdropPath = movie.getString(BACKDROP_PATH);
        String title = movie.getString(TITLE);


        Log.v(LOG_TAG, String.format("Creating new movie object: %s / %s", title, backdropPath));
        return new Movie(title, backdropPath);


    }
}