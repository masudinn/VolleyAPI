package com.masudinn.dicodingmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masudinn.dicodingmovie.Model.movie;
import com.masudinn.dicodingmovie.R;
import com.masudinn.dicodingmovie.communication;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class recycle_adapter extends RecyclerView.Adapter<recycle_adapter.holder> {

    ArrayList<movie> movies;
    Context context;
    public recycle_adapter(ArrayList<movie>movies,Context context){
        this.movies = movies;
        this.context=context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        holder holder = new holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tittle.setText(movies.get(position).getTittle());
        holder.rate.setText(movies.get(position).getRate());
        holder.date.setText(movies.get(position).getDate());
        holder.type.setText("Adult "+movies.get(position).getType());
        holder.overview.setText(movies.get(position).getOverview());

        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w185"+movies.get(position).getImg())
                .placeholder(R.drawable.movi)
                .into(holder.imgmovie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        TextView tittle,rate,date,type,overview;
        ImageView imgmovie;
        public holder(View itemView){
            super(itemView);
            tittle = (TextView) itemView.findViewById(R.id.txttittle);
            rate = (TextView) itemView.findViewById(R.id.like);
            date = (TextView) itemView.findViewById(R.id.txtdate);
            type = (TextView) itemView.findViewById(R.id.type);
            overview = (TextView) itemView.findViewById(R.id.txtdes);
            imgmovie = (ImageView) itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    communication com =(communication) context;
                    int position = getAdapterPosition();
                    com.sendData(movies.get(position));
                }
            });
        }
    }
}
