package com.ojdudu.popularmovies;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainMovieActivity extends AppCompatActivity {

    GridView moviePosterGridView;

    BaseAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_movie);

        moviePosterGridView = (GridView) findViewById(R.id.movie_posters_view);

        movieAdapter = new ImageAdapter(this);
        moviePosterGridView.setAdapter(movieAdapter);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_refresh){
            new MovieDataDownloader().execute();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Used for downloading movie information separate from UI thread.
     */
    class MovieDataDownloader extends AsyncTask<Void, Void, List<Movie>>{


        private final String LOG_TAG = MovieDataDownloader.class.getSimpleName();

        @Override
        protected List<Movie> doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String movieJSONResponse = null;

            try {
                urlConnection = getHttpURLConnection(urlConnection);


                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    movieJSONResponse = null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                //For easier JSON reading.
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    movieJSONResponse = null;
                }
                movieJSONResponse = buffer.toString();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error while downloading movie data", e);

                movieJSONResponse = null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }

            try {
                  Log.v(LOG_TAG, String.format("JSON Response:%s", movieJSONResponse));
                  return MovieDataParser.getMoviesFromJson(movieJSONResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;


        }

        /**
         * Generates and connects HttpURLConnection to The Movie Database.
         */
        private HttpURLConnection getHttpURLConnection(HttpURLConnection urlConnection) throws IOException {
            //Creates URL with query for The Movie Database
            URL url = generateQueryURL();

            // Create the request to Movie, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            return urlConnection;
        }

        /**
         * Generates connection URL to The Movie DB.
         */
        private URL generateQueryURL() throws MalformedURLException {

            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http")
                    .authority("api.themoviedb.org")
                    .appendPath("3")
                    .appendPath("movie")
                    .appendPath("popular")
                    .appendQueryParameter("api_key", MovieAPIKey.API_KEY)
                    .appendQueryParameter("language", "en-US");

            String url = uriBuilder.build().toString();
            return new URL(url);

        }
    }

}
