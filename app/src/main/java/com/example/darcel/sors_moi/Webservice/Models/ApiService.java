package com.example.darcel.sors_moi.Webservice.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    /**
     * Activite
     */
    @GET("Activites")
    Call<List<Activite>> listActivity();
    @POST("Activites")
    Call<Activite> createActivity(@Body Activite monActivite);
    @DELETE("Activite")
    Call<Activite> deleteActivity(@Query("id") int IdActivite);
    /**
     * Evenement
     */
    @GET("Evenement")
    Call<List<Evenement>> listEvent();
    @POST("Evenement")
    Call<Evenement> createEvent(@Body Evenement monEvent);
    @DELETE("Evenement")
    Call<Evenement> deleteEvent(@Query("id") int IdEvenement);
    /**
     * Utilisateur
     */
    @GET("Utilisateur")
    Call<List<Utilisateur>> listUser();
    @POST("Utilisateur")
    Call<Utilisateur> createUser(@Body Utilisateur monUser);
    @DELETE("Utilisateur")
    Call<Utilisateur> deleteUser(@Query("id") int IdUtilisateur);
}