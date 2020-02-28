package com.pecpacker.countrydetailsapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pecpacker.countrydetailsapp.Model.CountryModel;
import com.pecpacker.countrydetailsapp.R;
import com.pecpacker.countrydetailsapp.RetrofitAPI.CountriesApi;
import com.pecpacker.countrydetailsapp.RetrofitAPI.CountriesService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CountriesAdapter";
    private CountriesAdapter adapter;
    ProgressDialog progressDoalog;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading.....");
        progressDoalog.show();

        CountriesApi service = CountriesService.getRetrofitInstance().create(CountriesApi.class);
        Call<CountryModel> call = service.getALLNames();
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                progressDoalog.dismiss();
                countryRecyclerView(response.body());
                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    private void countryRecyclerView(CountryModel mNamel) {
        Log.d(TAG, "countryRecyclerView: country recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        CountriesAdapter adapter = new CountriesAdapter(mNamel, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}

