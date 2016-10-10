package com.ojdudu.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.GridView;

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

    //TODO: Backupthread to connect to movie DB to download data
    //TODO: TEST #1:
    //TODO: ● Upon launch, present the user with an grid arrangement of movie posters.

}
