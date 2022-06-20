package BO.Tp.eu.unareil.bo.Produits.nonPerissable;

import BO.Tp.eu.unareil.bo.Produits.Produit;

public class Stylo extends Produit {
    private String couleur;
    private String typeMine;

    public Stylo(Long refProd, String marque, String libelle, long qteStock, Float prixUnitaire, String couleur, String typeMine) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        setCouleur(couleur);
        setTypeMine(typeMine);
    }

    public Stylo(String marque, String libelle, long qteStock, Float prixUnitaire, String couleur, String typeMine) {
        super(marque, libelle, qteStock, prixUnitaire);

        setCouleur(couleur);
        setTypeMine(typeMine);

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stylo{\n");
        sb.append(super.toStringChild());
        sb.append("             couleur='").append(couleur).append("',\n");
        sb.append("             typeMine='").append(typeMine).append("',\n");
        sb.append("           }");
        return sb.toString();
    }
}
