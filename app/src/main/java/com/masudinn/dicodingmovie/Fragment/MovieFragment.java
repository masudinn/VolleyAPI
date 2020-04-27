package com.masudinn.dicodingmovie.Fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.masudinn.dicodingmovie.Model.movie;
import com.masudinn.dicodingmovie.R;
import com.masudinn.dicodingmovie.adapter.recycle_adapter;
import com.masudinn.dicodingmovie.communication;
import com.masudinn.dicodingmovie.volley.volleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements communication {
    RecyclerView recyclerView;
    recycle_adapter recycleAdapter;
    Context con;
    ArrayList<movie> data = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    String url="https://api.themoviedb.org/3/movie/popular?api_key=90b54a38972894350ba0831c5b17aad0";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view,@NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataFromApi();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        con = getActivity();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void getDataFromApi(){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            data=Parsing_JSON(response+"");
                            recycleAdapter = new recycle_adapter(data,con);
                            recyclerView.setAdapter(recycleAdapter);
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setHasFixedSize(true);
                            Toast.makeText(getActivity(),data.size()+"",
                                    Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        volleySingleton.getInstance(getActivity()).addToRequestQueue(request);
    }

    public ArrayList<movie> Parsing_JSON(String Json) throws JSONException {
        ArrayList<movie> moves = new ArrayList<>();

        JSONObject root = new JSONObject(Json);
        JSONArray results = root.getJSONArray("results");

        for(int i=0; i<results.length(); i++){
            JSONObject movie = results.getJSONObject(i);
            movie newMOVIE  = new movie(
                    movie.getString("id"),
                    movie.getString("original_title"),
                    movie.getString("poster_path"),
                    movie.getString("overview"),
                    movie.getString("release_date"),
                    movie.getString("vote_average"),
                    movie.getString("adult")
            );
            moves.add(newMOVIE);
        }
        return moves;
    }

    public void sendData(movie movie){
        Toast.makeText(con,movie.getTittle(),Toast.LENGTH_SHORT).show();
    }
}
