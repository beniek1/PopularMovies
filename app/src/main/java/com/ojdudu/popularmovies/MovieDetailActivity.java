package com.ojdudu.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent callingIntent = getIntent();
        Movie movie = callingIntent.getParcelableExtra(MOVIE);

        //Load Movie data into views
        ((TextView) findViewById(R.id.detail_title)).setText(movie.getTitle());
        ((TextView) findViewById(R.id.detail_overview)).setText(movie.getOverview());
        ((TextView) findViewById(R.id.detail_ranking)).setText(String.valueOf(movie.getRanking()));
        ((TextView) findViewById(R.id.detail_release)).setText(movie.getReleaseDate());
        Picasso.with(this).load(movie.getPosterURL()).into((ImageView)findViewById(R.id.detail_poster));

    }
}
