package BO.Tp.eu.unareil.bo.Produits;

import java.time.LocalDate;


public abstract class ProduitPerissable extends Produit {
    private LocalDate dateLimiteConso;

    public ProduitPerissable(long refProd, LocalDate dateLimiteConso, String marque, String libelle, long qteStock, Float prixUnitaire) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(dateLimiteConso);
    }

    public ProduitPerissable( LocalDate dateLimiteConso ,String marque, String libelle, long qteStock, Float prixUnitaire) {
        super(marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(dateLimiteConso);
    }

    public ProduitPerissable(long refProd, String marque, String libelle, long qteStock, Float prixUnitaire) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
    }

    public ProduitPerissable(String marque, String libelle, long qteStock, Float prixUnitaire) {
        super(marque, libelle, qteStock, prixUnitaire);
    }

    public LocalDate getDateLimiteConso() {
        return dateLimiteConso;
    }

    public void setDateLimiteConso(LocalDate dateLimiteConso) {
        this.dateLimiteConso = dateLimiteConso;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProduitPerissable{");
        sb.append(super.toStringChild());
        sb.append("dateLimiteConso =").append(dateLimiteConso).append("\n");
        sb.append('}');
        return sb.toString();
    }
    @Override
    public String  toStringChild() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toStringChild());
        sb.append("             dateLimiteConso= ").append(dateLimiteConso).append(",\n");
        return sb.toString();
    }
}
