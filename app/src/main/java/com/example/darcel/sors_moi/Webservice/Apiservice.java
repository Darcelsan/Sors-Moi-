package com.example.darcel.sors_moi.Webservice;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by Darcel on 31/05/2016.
 */
public interface Apiservice {

    public static final String ENDPOINT = "http://sors-moi.api.montpellier.epsi.fr/api";

    Apiservice apiService = new RestAdapter.Builder()
            .setEndpoint(Apiservice.ENDPOINT)
            .build()
            .create(Apiservice.class);

    @GET("/Activites")
    void listActivitesAsync(Callback<List<Activites>> callback);

}
