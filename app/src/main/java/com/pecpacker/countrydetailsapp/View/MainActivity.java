package com.pecpacker.countrydetailsapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;

import com.pecpacker.countrydetailsapp.Model.CountryModel;
import com.pecpacker.countrydetailsapp.R;
import com.pecpacker.countrydetailsapp.RetrofitAPI.CountriesApi;
import com.pecpacker.countrydetailsapp.RetrofitAPI.CountriesService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CountriesAdapter";
    private CountriesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        CountriesApi service = CountriesService.getRetrofitInstance().create(CountriesApi.class);


    }

}

