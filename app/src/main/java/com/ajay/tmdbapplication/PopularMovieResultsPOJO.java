package com.ajay.tmdbapplication;

import com.google.gson.annotations.SerializedName;

public class PopularMovieResultsPOJO {

    //TODO: Background Poster
    @SerializedName("backdrop_path")
    private String BackDropPath;

    @SerializedName("original_language")
    private String OriginalLanguage;

    @SerializedName("original_title")
    private String OriginalTitle;

    @SerializedName("overview")
    private String OverView;

    @SerializedName("popularity")
    private String Popularity;


    //TODO: Poster Image
    @SerializedName("poster_path")
    private String PosterPath;

    @SerializedName("release_date")
    private String ReleaseDate;

    //TODO: Rating
    @SerializedName("vote_average")
    private double VoteAverage;

    @SerializedName("vote_count")
    private int VoteCount;


    public PopularMovieResultsPOJO(String backDropPath, String originalLanguage, String originalTitle, String overView, String popularity, String posterPath, String releaseDate, double voteAverage, int voteCount) {
        BackDropPath = backDropPath;
        OriginalLanguage = originalLanguage;
        OriginalTitle = originalTitle;
        OverView = overView;
        Popularity = popularity;
        PosterPath = posterPath;
        ReleaseDate = releaseDate;
        VoteAverage = voteAverage;
        VoteCount = voteCount;
    }

    public String getBackDropPath() {
        return BackDropPath;
    }

    public String getOriginalLanguage() {
        return OriginalLanguage;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public String getOverView() {
        return OverView;
    }

    public String getPopularity() {
        return Popularity;
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public double getVoteAverage() {
        return VoteAverage;
    }

    public int getVoteCount() {
        return VoteCount;
    }
}
