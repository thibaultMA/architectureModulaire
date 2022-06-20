package BO.Tp.eu.unareil.bo.Perissable;

import BO.Tp.eu.unareil.bo.ProduitPerissable;

import java.time.LocalDate;

public class Glace extends ProduitPerissable {
    private String parfum;
    private Integer temperatureConservation;

    public Glace(LocalDate dateLimiteConso, String marque, String libelle, Integer temperatureConservation, String parfum, Long qteStock, Float prixUnitaire) {
        super(dateLimiteConso, marque, libelle, qteStock, prixUnitaire);
        setParfum(parfum);
        setTemperatureConservation(temperatureConservation);

    }

    public Glace(Long refProd, LocalDate dateLimiteConso, String marque, String libelle, Long qteStock, Float prixUnitaire, String parfum, Integer temperatureConservation) {
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
        final StringBuffer sb = new StringBuffer("Glace{");
        super.toStringChild();
        sb.append("parfum='").append(parfum).append('\'');
        sb.append(", temperatureConservation=").append(temperatureConservation);
        sb.append('}');
        return sb.toString();
    }
}
