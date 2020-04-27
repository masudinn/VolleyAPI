package com.masudinn.dicodingmovie.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.masudinn.dicodingmovie.Fragment.MovieFragment;
import com.masudinn.dicodingmovie.Model.movie;
import com.masudinn.dicodingmovie.R;
import com.masudinn.dicodingmovie.communication;
import com.masudinn.dicodingmovie.detailFragment;

public class MainActivity extends AppCompatActivity implements communication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction().replace(R.id.container,new MovieFragment()).commit();
    }


    @Override
    public void sendData(movie movie) {
        //before klik, move the fragment details and get data in the fragment details
        Bundle bundle = new Bundle();
        bundle.putString("tittle",movie.getTittle());
        bundle.putString("date",movie.getDate());
        bundle.putString("type",movie.getType());
        bundle.putString("Image",movie.getImg());
        bundle.putString("rate",movie.getRate());
        bundle.putString("overview",movie.getImg());
        bundle.putString("id",movie.getId());
        detailFragment detailFragments = new detailFragment();
        detailFragments.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container,detailFragments).addToBackStack(null).commit();
    }
}
