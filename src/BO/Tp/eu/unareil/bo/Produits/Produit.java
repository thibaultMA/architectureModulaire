package BO.Tp.eu.unareil.bo.Produits;

import java.text.DecimalFormat;

public abstract class Produit {
    private static Long tt =0L;
    private Long refProd;
    private String libelle;
    private String marque;
    private Float prixUnitaire;
    private Long qteStock;
    private final String type = String.valueOf(this.getClass());

    public Produit(Long refProd, String marque , String libelle, long qteStock, Float prixUnitaire ) {
        setRefProd(refProd);
        setLibelle(libelle);
        setMarque(marque);
        setPrixUnitaire(prixUnitaire);
        setQteStock(qteStock);
    }

    public Produit(String marque, String libelle , Long qteStock, Float prixUnitaire) {
        ++tt;
        setRefProd(tt);
        setLibelle(libelle);
        setMarque(marque);
        setPrixUnitaire(prixUnitaire);
        setQteStock(qteStock);
    }

    public Long getRefProd() {
        return refProd;
    }

    public void setRefProd(Long refProd) {

        this.refProd = refProd;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Long getQteStock() {
        return qteStock;
    }

    public void setQteStock(Long qteStock) {
        this.qteStock = qteStock;
    }
    private String formatDecimal(float unformat){
        DecimalFormat o = new DecimalFormat("#0.00");
        return o.format(unformat);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\nProduits{");
        sb.append("refProd=").append(refProd);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", prixUnitaire=").append(formatDecimal(prixUnitaire)).append("€");
        sb.append(", qteStock=").append(qteStock);
        sb.append('}');
        return sb.toString();
    }

    public String  toStringChild() {

        final StringBuffer sb = new StringBuffer('\n');
        sb.append("             refProd=").append(refProd).append(",\n");
        sb.append("             libelle='").append(libelle).append("',\n");
        sb.append("             marque='").append(marque).append("',\n");
        sb.append("             prixUnitaire= ").append(formatDecimal(prixUnitaire)).append("€ ,\n");
        sb.append("             qteStock=").append(qteStock).append(", \n");
        return sb.toString();
    }
}
