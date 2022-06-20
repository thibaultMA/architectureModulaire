package BO.Tp.eu.unareil.bo;

import java.time.LocalDate;


public abstract class ProduitPerissable extends Produits{
    private LocalDate dateLimiteConso;

    public ProduitPerissable(Long refProd, LocalDate dateLimiteConso, String marque, String libelle, Long qteStock, Float prixUnitaire) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(dateLimiteConso);
    }

    public ProduitPerissable( LocalDate dateLimiteConso ,String marque, String libelle, Long qteStock, Float prixUnitaire) {
        super(marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(dateLimiteConso);
    }

    public ProduitPerissable(Long refProd, String marque, String libelle, Long qteStock, Float prixUnitaire) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
    }

    public ProduitPerissable(String marque, String libelle, Long qteStock, Float prixUnitaire) {
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
        sb.append("dateLimiteConso=").append(dateLimiteConso);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public String toStringChild() {
        final StringBuffer sb = new StringBuffer("ProduitPerissable{");
        super.toStringChild();
        sb.append("dateLimiteConso=").append(dateLimiteConso);
        sb.append('}');
        return sb.toString();
    }
}
