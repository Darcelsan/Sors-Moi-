package com.example.darcel.sors_moi.Webservice.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activite {
    @SerializedName("IdActivite")
    @Expose
    private String idActivite;
    @SerializedName("NomActivite")
    @Expose
    private String nomActivite;
    @SerializedName("LieuActivite")
    @Expose
    private String lieuActivite;
    @SerializedName("CategorieActivite")
    @Expose
    private String categorieActivite;
    /**
     *
     * @return
     * The idActivite
     */
    public String getIdActivite() {
        return idActivite;
    }

    /**
     *
     * @param idActivite
     * The IdActivite
     */
    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }
    /**
     *
     * @return
     * The nomActivite
     */
    public String getNomActivite() {
        return nomActivite;
    }
    /**
     *
     * @param nomActivite
     * The NomActivite
     */
    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }
    /**
     *
     * @return
     * The lieuActivite
     */
    public String getLieuActivite() {
        return lieuActivite;
    }
    /**
     *
     * @param lieuActivite
     * The LieuActivite
     */
    public void setLieuActivite(String lieuActivite) {
        this.lieuActivite = lieuActivite;
    }
    /**
     *
     * @return
     * The categorieActivite
     */
    public String getCategorieActivite() {
        return categorieActivite;
    }
    /**
     *
     * @param categorieActivite
     * The CategorieActivite
     */
    public void setCategorieActivite(String categorieActivite) {
        this.categorieActivite = categorieActivite;
    }
}