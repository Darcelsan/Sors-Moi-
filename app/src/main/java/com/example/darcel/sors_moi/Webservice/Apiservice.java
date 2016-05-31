package com.example.darcel.sors_moi.Webservice;

import retrofit2.http.GET;

/**
 * Created by Darcel on 31/05/2016.
 */
public interface Apiservice {
    @GET("TattooSalonTables")//http://localhost:64059/api/Utilisateurs/
    Call<List<TatooSalon>> listTatooSalon();
}
