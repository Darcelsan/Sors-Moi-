package com.example.darcel.sors_moi.Webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Darcel on 31/05/2016.
 */
public interface Apiservice {
    @GET("Activites")//http://localhost:64059/api/Activites/
    Call<List<Activites>> listActivites();
}