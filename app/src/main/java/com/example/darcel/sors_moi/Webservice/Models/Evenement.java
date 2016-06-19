package com.example.darcel.sors_moi.Webservice.Models;
import com.google.gson.annotations.*;

public class Evenement {
    @SerializedName("IdEvenement")
    @Expose
    private String idEvenement;
    @SerializedName("HeureDebut")
    @Expose
    private String heureDebut;
    @SerializedName("HeureFin")
    @Expose
    private String heureFin;
    @SerializedName("JourDebut")
    @Expose
    private String jourDebut;
    @SerializedName("JourFin")
    @Expose
    private String jourFin;
    @SerializedName("Description")
    @Expose
    private String description;
    /**
     *
     * @return
     * The idEvenement
     */
    public String getIdEvenement() {
        return idEvenement;
    }
    /**
     *
     * @param idEvenement
     * The IdEvenement
     */
    public void setIdEvenement(String idEvenement) {
        this.idEvenement = idEvenement;
    }
    /**
     *
     * @return
     * The heureDebut
     */
    public String getHeureDebut() {
        return heureDebut;
    }
    /**
     *
     * @param heureDebut
     * The HeureDebut
     */
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }
    /**
     *
     * @return
     * The heureFin
     */
    public String getHeureFin() {
        return heureFin;
    }
    /**
     *
     * @param heureFin
     * The HeureFin
     */
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
    /**
     *
     * @return
     * The jourDebut
     */
    public String getJourDebut() {
        return jourDebut;
    }
    /**
     *
     * @param jourDebut
     * The JourDebut
     */
    public void setJourDebut(String jourDebut) {
        this.jourDebut = jourDebut;
    }
    /**
     *
     * @return
     * The jourFin
     */
    public String getJourFin() {
        return jourFin;
    }
    /**
     *
     * @param jourFin
     * The JourFin
     */
    public void setJourFin(String jourFin) {
        this.jourFin = jourFin;
    }
    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }
    /**
     *
     * @param description
     * The Description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}