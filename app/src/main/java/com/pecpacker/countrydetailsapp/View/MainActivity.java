package com.pecpacker.countrydetailsapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pecpacker.countrydetailsapp.Model.CountryModel;
import com.pecpacker.countrydetailsapp.R;
import com.pecpacker.countrydetailsapp.RetrofitAPI.CountriesApi;
import com.pecpacker.countrydetailsapp.RetrofitAPI.CountriesService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CountriesAdapter";
    private CountriesAdapter adapter;
    private RecyclerView recyclerView;
    private List<CountryModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


        CountriesApi service = CountriesService.getRetrofitInstance().create(CountriesApi.class);
        Call<List<CountryModel>> call = service.getALLNames();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                Log.d("countries", "onResponse: " + response.body());
                arrayList = response.body();
                adapter = new CountriesAdapter(arrayList, MainActivity.this);
                //countryRecyclerView(response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


}

