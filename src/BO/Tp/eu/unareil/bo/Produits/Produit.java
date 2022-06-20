package BO.Tp.eu.unareil.bo.Produits;

public abstract class Produit {
    private static Long tt =0L;
    private Long refProd;
    private String libelle;
    private String marque;
    private Float prixUnitaire;
    private Long qteStock;

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produits{");
        sb.append("refProd=").append(refProd);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", prixUnitaire=").append(prixUnitaire);
        sb.append(", qteStock=").append(qteStock);
        sb.append('}');
        return sb.toString();
    }


    public String  toStringChild() {
        final StringBuffer sb = new StringBuffer();
        sb.append("refProd=").append(refProd);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", prixUnitaire=").append(prixUnitaire);
        sb.append(", qteStock=").append(qteStock);
        return sb.toString();
    }
}
