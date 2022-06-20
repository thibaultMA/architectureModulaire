package BO.Tp.eu.unareil.bo.Perissable;

import BO.Tp.eu.unareil.bo.ProduitPerissable;

import java.time.LocalDate;


public class pain extends ProduitPerissable {
    private Integer Poid;

    public pain(Long refProd,  String marque, String libelle,Integer poid, Long qteStock, Float prixUnitaire ) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        setDateLimiteConso(LocalDate.now().plusDays(2L));
        setPoid(poid);
    }

    public pain(String marque, String libelle, Integer poid, Long qteStock, Float prixUnitaire) {
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
        final StringBuffer sb = new StringBuffer("pain{");
        super.toStringChild();
        sb.append("Poid=").append(Poid);
        sb.append('}');
        return sb.toString();
    }
}
