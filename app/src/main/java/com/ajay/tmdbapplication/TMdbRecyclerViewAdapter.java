package com.ajay.tmdbapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajay.tmdbapplication.databinding.PopularMovieDisplayBinding;
import com.bumptech.glide.Glide;

import java.util.List;

public class TMdbRecyclerViewAdapter extends RecyclerView.Adapter<TMdbRecyclerViewAdapter.MyViewholder> {

private Context context;
private List<PopularMovieResultsPOJO> list;

    public TMdbRecyclerViewAdapter(Context context, List<PopularMovieResultsPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       PopularMovieDisplayBinding binding=PopularMovieDisplayBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyViewholder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        String imagePoster = Utility.IMAGE_BASE_URL + list.get(position).getPosterPath();
        String imageBackground = Utility.IMAGE_BASE_URL + list.get(position).getBackDropPath();
        holder.binding.tvMovieTitle.setText(list.get(position).getOriginalTitle());
        holder.binding.tvOriginalLanguage.setText("Original Language :  "+list.get(position).getOriginalLanguage());
        holder.binding.tvReleaseDate.setText("Release Date :  "+list.get(position).getReleaseDate());
        holder.binding.tvVoteCount.setText("Vote Count : "+list.get(position).getVoteCount());
        holder.binding.tvVoteAvg.setText("Vote Avg. : " + list.get(position).getVoteAverage());
        holder.binding.tvOverview.setText("Overview :"+ "\n"+ list.get(position).getOverView());
        holder.binding.tvPopularity.setText("Popularity : " + list.get(position).getPopularity());

//        //TODO: Glide use to set image
        Glide.with(context).load(imageBackground).into(holder.binding.imageViewPosterPath);
        Glide.with(context).load(imagePoster).into(holder.binding.imageViewBackdrop);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
       //TODO: Create binding here of  Layout 'popular_movies_dispaly'
        PopularMovieDisplayBinding binding;

        public MyViewholder(PopularMovieDisplayBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
