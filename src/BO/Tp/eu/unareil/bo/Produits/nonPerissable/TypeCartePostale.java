package BO.Tp.eu.unareil.bo.Produits.nonPerissable;

public enum TypeCartePostale {
    PAYSAGE("Paysage"), PORTRAIT("Portrait");
    public static String Paysage;
    public static String Portrait;
    private final String abreviation ;

    private TypeCartePostale(String abreviation) {
        this.abreviation = abreviation ;
    }

    public String getAbreviation() {
        return  this.abreviation ;
    }
    }
