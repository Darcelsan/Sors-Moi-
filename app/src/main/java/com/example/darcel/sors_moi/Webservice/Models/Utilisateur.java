package com.example.darcel.sors_moi.Webservice.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Utilisateur {
    @SerializedName("IdUtilisateur")
    @Expose
    private String idUtilisateur;
    @SerializedName("NomUtilisateur")
    @Expose
    private String nomUtilisateur;
    @SerializedName("PrenomUtilisateur")
    @Expose
    private String prenomUtilisateur;
    @SerializedName("MailUtilisateur")
    @Expose
    private String mailUtilisateur;
    @SerializedName("VilleUtilisateur")
    @Expose
    private String villeUtilisateur;
    @SerializedName("CodePostalUtilisateur")
    @Expose
    private String codePostalUtilisateur;
    @SerializedName("RoleUtilisateur")
    @Expose
    private String roleUtilisateur;
    @SerializedName("MotDePasse")
    @Expose
    private String motDePasse;

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String mailUtilisateur, String villeUtilisateur, String codePostalUtilisateur, String motDePasse) {
        this.idUtilisateur = "69696969";
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.villeUtilisateur = villeUtilisateur;
        this.codePostalUtilisateur = codePostalUtilisateur;
        this.roleUtilisateur = "Utilisateur";
        this.motDePasse = motDePasse;
    }

    public Utilisateur(String ID, String nomUtilisateur, String prenomUtilisateur, String mailUtilisateur, String villeUtilisateur, String codePostalUtilisateur, String motDePasse) {
        this.idUtilisateur = ID;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.villeUtilisateur = villeUtilisateur;
        this.codePostalUtilisateur = codePostalUtilisateur;
        this.roleUtilisateur = "Utilisateur";
        this.motDePasse = motDePasse;
    }


    /**
     *
     * @return
     * The idUtilisateur
     */
    public String getIdUtilisateur() {
        return idUtilisateur;
    }
    /**
     *
     * @param idUtilisateur
     * The IdUtilisateur
     */
    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    /**
     *
     * @return
     * The nomUtilisateur
     */
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    /**
     *
     * @param nomUtilisateur
     * The NomUtilisateur
     */
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    /**
     *
     * @return
     * The prenomUtilisateur
     */
    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }
    /**
     *
     * @param prenomUtilisateur
     * The PrenomUtilisateur
     */
    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }
    /**
     *
     * @return
     * The mailUtilisateur
     */
    public String getMailUtilisateur() {
        return mailUtilisateur;
    }
    /**
     *
     * @param mailUtilisateur
     * The MailUtilisateur
     */
    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }
    /**
     *
     * @return
     * The villeUtilisateur
     */
    public String getVilleUtilisateur() {
        return villeUtilisateur;
    }
    /**
     *
     * @param villeUtilisateur
     * The VilleUtilisateur
     */
    public void setVilleUtilisateur(String villeUtilisateur) {
        this.villeUtilisateur = villeUtilisateur;
    }
    /**
     *
     * @return
     * The codePostalUtilisateur
     */
    public String getCodePostalUtilisateur() {
        return codePostalUtilisateur;
    }
    /**
     *
     * @param codePostalUtilisateur
     * The CodePostalUtilisateur
     */
    public void setCodePostalUtilisateur(String codePostalUtilisateur) {
        this.codePostalUtilisateur = codePostalUtilisateur;
    }
    /**
     *
     * @return
     * The roleUtilisateur
     */
    public String getRoleUtilisateur() {
        return roleUtilisateur;
    }
    /**
     *
     * @param roleUtilisateur
     * The RoleUtilisateur
     */
    public void setRoleUtilisateur(String roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }
    /**
     *
     * @return
     * The motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }
    /**
     *
     * @param motDePasse
     * The MotDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}