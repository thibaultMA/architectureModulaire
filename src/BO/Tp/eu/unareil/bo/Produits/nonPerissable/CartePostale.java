package BO.Tp.eu.unareil.bo.Produits.nonPerissable;

import BO.Tp.eu.unareil.bo.Produits.Produit;

import java.util.ArrayList;
import java.util.List;

public class CartePostale extends Produit {

    private List<Auteur> lesAuteurs = new ArrayList<>();
    private String type;

    public CartePostale(Long refProd, String marque, String libelle, long qteStock, Float prixUnitaire, List<Auteur> lesAuteurs, String type) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        setLesAuteurs(lesAuteurs);
        this.type = type;

    }


    public CartePostale(String marque, String libelle, long qteStock, Float prixUnitaire, List<Auteur> lesAuteurs, String type) {
        super(marque, libelle, qteStock, prixUnitaire);
        setLesAuteurs(lesAuteurs);
        this.type = type;
    }

    public List<Auteur> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(List<Auteur> lesAuteurs) {
        this.lesAuteurs.addAll(lesAuteurs);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CartePostale{\n");
        sb.append(super.toStringChild());
        sb.append("             les Auteurs =").append(lesAuteurs).append("\n");
        sb.append(",             type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
