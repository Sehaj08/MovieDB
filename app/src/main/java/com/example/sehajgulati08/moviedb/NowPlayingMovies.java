package com.example.sehajgulati08.moviedb;

import java.util.ArrayList;

/**
 * Created by sehaj.gulati08 on 29-07-2017.
 */

public class NowPlayingMovies {
    public NowPlayingMovies(String release_date, String original_title, float vote_average) {
        this.release_date = release_date;
        this.original_title = original_title;
        this.vote_average = vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public float getVote_average() {
        return vote_average;
    }

    String release_date;
    String original_title;
    float vote_average;
    public static ArrayList<NowPlayingMovies> getRandomMovies(int noOfMovies){
        ArrayList<NowPlayingMovies> nowPlayingArrayList = new ArrayList<>();
        for(int i = 0;i<noOfMovies;i++){
            NowPlayingMovies nowPlayingMovies = new NowPlayingMovies(""+i,""+i,i);
            nowPlayingArrayList.add(nowPlayingMovies);
        }
        return nowPlayingArrayList;
    }
}
