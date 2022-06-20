package BO.Tp.eu.unareil.bo.panier;

import BO.Tp.eu.unareil.bo.Produits.Produit;

public class Ligne {
    private Produit Produit ;
    private Integer quantite;

    public Ligne(Produit p, Integer quantite) {
        setP(p);
        setQuantite(quantite);
    }

    public Produit getProduit() {
        return Produit;
    }
    public  Double getPrix(){
        return Produit.getPrixUnitaire().doubleValue() * getQuantite();
    }
    public void setP(Produit p) {
        this.Produit = p;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ligne {");
        sb.append("Produit=").append(Produit);
        sb.append(", quantite=").append(quantite);
        sb.append('}');
        return sb.toString();
    }
}
