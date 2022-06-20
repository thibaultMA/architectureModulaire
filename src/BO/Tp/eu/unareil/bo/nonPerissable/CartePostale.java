package BO.Tp.eu.unareil.bo.nonPerissable;

import BO.Tp.eu.unareil.bo.Produits;

import java.util.ArrayList;
import java.util.List;

public class CartePostale extends Produits {
    private List<Auteurs> lesAuteurs = new ArrayList<>();
    private String type;

    public CartePostale(Long refProd, String marque, String libelle, Long qteStock, Float prixUnitaire, List<Auteurs> lesAuteurs, String type) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        this.lesAuteurs = lesAuteurs;
        setLesAuteurs(lesAuteurs);
        this.type = type;

    }

    public CartePostale(String marque, String libelle, Long qteStock, Float prixUnitaire, List<Auteurs> lesAuteurs, String type) {
        super(marque, libelle, qteStock, prixUnitaire);
        setLesAuteurs(lesAuteurs);
        this.type = type;
    }

    public List<Auteurs> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(List<Auteurs> lesAuteurs) {
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
        final StringBuffer sb = new StringBuffer("CartePostale{");
        super.toStringChild();
        sb.append("lesAuteurs=").append(lesAuteurs);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
