package BO.Tp.eu.unareil.bo.Produits.Perissable;

import BO.Tp.eu.unareil.bo.Produits.ProduitPerissable;

import java.time.LocalDate;


public class Pain extends ProduitPerissable {
    private Integer Poid;

    public Pain(Long refProd,  String marque, String libelle,Integer poid, long qteStock, Float prixUnitaire ) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(LocalDate.now().plusDays(2L));
        setPoid(poid);
    }

    public Pain(String marque, String libelle, Integer poid, long qteStock, Float prixUnitaire) {
        super(marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(LocalDate.now().plusDays(2L));
        setPoid(poid);
    }

    public Integer getPoid() {
        return Poid;
    }

    public void setPoid(Integer poid) {
        Poid = poid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("pain{\n");
        sb.append(super.toStringChild());
        sb.append("             Poid=").append(Poid);
        sb.append('}');
        return sb.toString();
    }

}
