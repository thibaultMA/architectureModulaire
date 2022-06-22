package BO.Tp.eu.unareil.bo.Produits;

import BO.Tp.eu.unareil.bo.Produits.nonPerissable.Auteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends Produit{
    private LocalDate dateLimiteConso;
    private Integer Poid;
    private String parfum;
    private Integer temperatureConservation;
    private String couleur;
    private String typeMine;
    private List<Auteur> lesAuteurs = new ArrayList<>();
    private String type;
    private String typeProduits;

    public ProduitDAO(Long refProd, String marque, String libelle, long qteStock, Float prixUnitaire, LocalDate dateLimiteConso, Integer poid, String parfum, Integer temperatureConservation, String couleur, String typeMine, List<Auteur> lesAuteurs, String type, String typeProduits) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);

        setDateLimiteConso(dateLimiteConso);
        setPoid(poid);

        setParfum(parfum);
        setTemperatureConservation(temperatureConservation);
        setCouleur(couleur);
        setTypeMine(typeMine);
        setLesAuteurs(lesAuteurs);
        setTypeCarte(type);
        setTypeProduits(typeProduits);
    }

    public LocalDate getDateLimiteConso() {
        return dateLimiteConso;
    }

    public void setDateLimiteConso(LocalDate dateLimiteConso) {
        this.dateLimiteConso = dateLimiteConso;
    }

    public Integer getPoid() {
        return Poid;
    }

    public void setPoid(Integer poid) {
        Poid = poid;
    }

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public Integer getTemperatureConservation() {
        return temperatureConservation;
    }

    public void setTemperatureConservation(Integer temperatureConservation) {
        this.temperatureConservation = temperatureConservation;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getTypeMine() {
        return typeMine;
    }

    public void setTypeMine(String typeMine) {
        this.typeMine = typeMine;
    }

    public List<Auteur> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(List<Auteur> lesAuteurs) {
        this.lesAuteurs = lesAuteurs;
    }

    public String getType() {
        return type;
    }

    public void setTypeCarte(String type) {
        this.type = type;
    }

    public String getTypeProduits() {
        return typeProduits;
    }

    public void setTypeProduits(String typeProduits) {
        this.typeProduits = typeProduits;
    }
}
