package com.ajay.tmdbapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.ajay.tmdbapplication.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   private ActivityMainBinding binding;
   private ProgressDialog dialog;
   private TMdbRecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.idRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dialog=new ProgressDialog(this);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        dialog.show();

        TMdbApi apiName=TMDBRetrofitAPI.getInstance(TMdbApi.class);
        Call<ResponseModel> call=apiName.getpopularmovies(Utility.KEY);
                call.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                        if(response.isSuccessful() && response.code() == 200) {
                            ResponseModel popularMovieList =  response.body();
                            for (PopularMovieResultsPOJO popularMovie : popularMovieList.getPopularMoviesResult()) {
                                dialog.dismiss();
                                adapter = new TMdbRecyclerViewAdapter(MainActivity.this, popularMovieList.getPopularMoviesResult());
                                binding.idRecyclerView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();

                                Log.d("Popular Movie", "onResponse: " + popularMovie.getOriginalTitle());
                            }
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                     dialog.hide();
                     Utility.showLongToast(MainActivity.this,t.getMessage());

                    }
                });
    }
}