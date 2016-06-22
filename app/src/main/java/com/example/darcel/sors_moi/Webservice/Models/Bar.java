package com.example.darcel.sors_moi.Webservice.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bar {
    @SerializedName("IdBar")
    @Expose
    private String IdBar;
    @SerializedName("NomBar")
    @Expose
    private String NomBar;
    /*@SerializedName("LieuActivite")
    @Expose
    private String lieuActivite;
    @SerializedName("CategorieActivite")
    @Expose
    private String categorieActivite;*/
    /**
     *
     * @return
     * The IdBar
     */
    public String getIdBar() {
        return IdBar;
    }

    /**
     *
     * @param IdBar
     * The IdBar
     */
    public void setIdBar(String IdBar) {
        this.IdBar = IdBar;
    }
    /**
     *
     * @return
     * The NomBar
     */
    public String getNomBar() {
        return NomBar;
    }
    /**
     *
     * @param NomBar
     * The NomBar
     */
    public void setNomActivite(String NomBar) {
        this.NomBar = NomBar;
    }
    /**
     *
     * @return
     * The lieuActivite
     */
    /*public String getLieuActivite() {
        return lieuActivite;
    }
    /**
     *
     * @param lieuActivite
     * The LieuActivite
     */
    /*public void setLieuActivite(String lieuActivite) {
        this.lieuActivite = lieuActivite;
    }
    /**
     *
     * @return
     * The categorieActivite
     */
    /*public String getCategorieActivite() {
        return categorieActivite;
    }
    /**
     *
     * @param categorieActivite
     * The CategorieActivite
     */
    /*public void setCategorieActivite(String categorieActivite) {
        this.categorieActivite = categorieActivite;
    }*/
}