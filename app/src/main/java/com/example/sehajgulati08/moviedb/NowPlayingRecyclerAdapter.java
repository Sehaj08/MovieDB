package com.example.sehajgulati08.moviedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sehaj.gulati08 on 29-07-2017.
 */

public class NowPlayingRecyclerAdapter extends RecyclerView.Adapter<NowPlayingRecyclerAdapter.NowPlayingMoviesViewHolder> {

    private Context mContext;
    private ArrayList<NowPlayingMovies> mNowPlayingMovies;
    private NowPlayingMoviesClickListener mListener;

    public interface NowPlayingMoviesClickListener {
        void onItemClick(View view, int position);
    }

    public NowPlayingRecyclerAdapter(Context context, ArrayList<NowPlayingMovies> NowPlayingMovies, NowPlayingMoviesClickListener listener) {
        mContext = context;
        mNowPlayingMovies = NowPlayingMovies;
        mListener = listener;
    }

    @Override
    public NowPlayingMoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_item_now_playing, parent, false);
        return new NowPlayingMoviesViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(NowPlayingMoviesViewHolder holder, int position) {

        NowPlayingMovies nowPlayingMovies = mNowPlayingMovies.get(position);
        holder.releaseYearTextView.setText(nowPlayingMovies.getRelease_date());
        holder.movieNameTextView.setText(nowPlayingMovies.getOriginal_title());
//        holder.genreTextView.setText(nowPlayingMovies.getGenre());
        holder.voteAverageTextView.setText(nowPlayingMovies.getVote_average() + "");
    }

    @Override
    public int getItemCount() {
        return mNowPlayingMovies.size();
    }

    public static class NowPlayingMoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView moviePosterImageView;
        TextView releaseYearTextView;
        TextView movieNameTextView;
        TextView genreTextView;
        TextView voteAverageTextView;
        NowPlayingMoviesClickListener mNowPlayingMoviesClickListener;

        public NowPlayingMoviesViewHolder(View itemView, NowPlayingMoviesClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            moviePosterImageView = itemView.findViewById(R.id.poster_path);
            releaseYearTextView = itemView.findViewById(R.id.releaseYearTextView);
            movieNameTextView = itemView.findViewById(R.id.movieNameTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
            voteAverageTextView = itemView.findViewById(R.id.voteAverageTextView);
            mNowPlayingMoviesClickListener = listener;

        }

        @Override
        public void onClick(View view) {
            int id = view.getId();
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                if (id == R.id.layout_item_now_playing) {
                    mNowPlayingMoviesClickListener.onItemClick(view, position);
                }
            }
        }
    }
}
