package com.pecpacker.countrydetailsapp.RetrofitAPI;

import com.pecpacker.countrydetailsapp.Model.CountryModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesApi {

    @GET("/rest/v2/all/")
    Call<CountryModel> getALLNames();

}
