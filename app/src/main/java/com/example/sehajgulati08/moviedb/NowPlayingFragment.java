package com.example.sehajgulati08.moviedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sehaj.gulati08 on 29-07-2017.
 */

public class NowPlayingFragment extends Fragment {

    RecyclerView nowPlayingRecyclerView;
    NowPlayingRecyclerAdapter mNowPlayingRecyclerAdapter;
    ArrayList<NowPlayingMovies> mNowPlayingMoviesArrayList;
    NowPlayingMoviesFragmentListItemClick mListener;
//
    void  setNowPlayingFragmentListItemClick(NowPlayingMoviesFragmentListItemClick listener){
        this.mListener = listener;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_now_playing, container, false);
        nowPlayingRecyclerView =  v.findViewById(R.id.nowPlayingRecyclerView);
        mNowPlayingMoviesArrayList = NowPlayingMovies.getRandomMovies(3);
        mNowPlayingRecyclerAdapter = new NowPlayingRecyclerAdapter(getActivity(), mNowPlayingMoviesArrayList, new NowPlayingRecyclerAdapter.NowPlayingMoviesClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(mListener!=null){
                    mListener.onListItemClicked(mNowPlayingMoviesArrayList.get(position));
                }
            }
        });


        return v;
    }
        interface NowPlayingMoviesFragmentListItemClick{
        void onListItemClicked(NowPlayingMovies nowPlayingMovies);
    }

}
