package com.masudinn.dicodingmovie;


import android.app.Fragment;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class detailFragment extends Fragment {


    public detailFragment() {
        // Required empty public constructor
    }

    TextView tittle,date,rate;
    ImageView posterImage,backImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        tittle = (TextView) view.findViewById(R.id.Ttitle);
        tittle.setText(bundle.getString("tittle"));
        date = (TextView) view.findViewById(R.id.Tdate);
        date.setText(bundle.getString("date"));
        rate = (TextView) view.findViewById(R.id.Trate);
        rate.setText(bundle.getString("rate"));

        return view;
    }

}
