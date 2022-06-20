package BO.Tp.eu.unareil.bo.panier;

import BO.Tp.eu.unareil.bo.Produits.Produit;

import java.util.ArrayList;
import java.util.List;

public class Achat {
    private List<Ligne> listAchat = new ArrayList<>();
    private Double Montant=0d;

    public Achat(Ligne listAchat) {
        ajouteLigne(listAchat);
        calculMontant();
    }

    public List<Ligne> getLignes() {
        return listAchat;
    }

    public void ajouteLigne(Ligne ligne) {
        listAchat.add(ligne);
        calculMontant();
    }
    public void ajouteLigne(Produit p , Integer qte) {
        listAchat.add(new Ligne(p,qte));
        calculMontant();
    }

    public void setMontant(Double montant) {
        Montant = montant;
    }

    public Double getMontant() {
        return Montant;
    }

    private void calculMontant() {
        for (Ligne ligne : listAchat) {
            Montant += ligne.getPrix();
        }
    }
    public Ligne getLigne(Integer index) {
        return listAchat.get(index);
    }
    public void modifieLigne(Integer index,Integer nouvelleQte) {
        getLigne(index).setQuantite(nouvelleQte);
    }
    public void supprimeLigne(int index) {
        listAchat.remove(index);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Achat{");
        sb.append("listAchat=").append(listAchat);
        sb.append(", Montant=").append(Montant);
        sb.append('}');
        return sb.toString();
    }
}
