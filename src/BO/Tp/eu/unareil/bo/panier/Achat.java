package BO.Tp.eu.unareil.bo.panier;

import BO.Tp.eu.unareil.bo.Produits.Produit;

import java.text.DecimalFormat;
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
        Montant = 0D;
        for (Ligne ligne : listAchat) {
            Montant += ligne.getPrix();
        }
    }
    public Ligne getLigne(Integer index) {
        return listAchat.get(index);
    }
    public void modifieLigne(Integer index,Integer nouvelleQte) {
        getLigne(index).setQuantite(nouvelleQte);
        calculMontant();
    }
    public void supprimeLigne(int index) {
        listAchat.remove(index);
        calculMontant();
    }
    private String formatDecimal(Double unformat){
        DecimalFormat o = new DecimalFormat("#0.00");
        return o.format(unformat);
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Achat{\n");
        sb.append("listAchat=").append(listAchat);
        sb.append(",\n Montant=").append(formatDecimal(Montant)).append("€");
        sb.append('}');
        return sb.toString();
    }
}
