package com.spencer.danny.myfilmapp;

import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class DetailMovie extends AppCompatActivity {

    ImageView Poster;
    TextView Judul, Rating, Tgl, Overview;

    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView)findViewById(R.id.judul);
        Tgl = (TextView)findViewById(R.id.tgl);
        Rating = (TextView)findViewById(R.id.rating);
        Overview = (TextView)findViewById(R.id.overview);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);

        Picasso.with(DetailMovie.this)
                .load("http://image.tmdb.org/t/p/w185/"+result.getPosterPath())
                .into(Poster);
        Judul.setText("Judul Film : \n"+result.getTitle());
        Rating.setText("\nRating : "+Double.toString(result.getVoteAverage()));
        Tgl.setText("\nTanggal Rilis : "+result.getReleaseDate());
        Overview.setText("\nOverview : \n"+result.getOverview());

    }
}
