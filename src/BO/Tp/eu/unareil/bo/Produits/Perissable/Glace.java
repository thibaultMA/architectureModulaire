package BO.Tp.eu.unareil.bo.Produits.Perissable;

import BO.Tp.eu.unareil.bo.Produits.ProduitPerissable;

import java.time.LocalDate;

public class Glace extends ProduitPerissable {
    private String parfum;
    private Integer temperatureConservation;

    public Glace(LocalDate dateLimiteConso, String marque, String libelle, Integer temperatureConservation, String parfum, long qteStock, Float prixUnitaire) {
        super(dateLimiteConso, marque, libelle, qteStock, prixUnitaire);
        setParfum(parfum);
        setTemperatureConservation(temperatureConservation);

    }

    public Glace(Long refProd, LocalDate dateLimiteConso, String marque, String libelle, long qteStock, Float prixUnitaire, String parfum, Integer temperatureConservation) {
        super(refProd, dateLimiteConso, marque, libelle, qteStock, prixUnitaire);
        setParfum(parfum);
        setTemperatureConservation(temperatureConservation);
    }

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public Integer getTemperatureConservation() {
        return temperatureConservation;
    }

    public void setTemperatureConservation(Integer temperatureConservation) {
        this.temperatureConservation = temperatureConservation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Glace{\n");
        sb.append(super.toStringChild());
        sb.append("             parfum='").append(parfum).append(",\n");
        sb.append("             temperatureConservation=").append(temperatureConservation).append(",\n");
        sb.append("     }");
        return sb.toString();
    }
}
