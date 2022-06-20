package BO.Tp.eu.unareil.bo;

public class Ligne {
    private Produits p ;
    private Integer quantite;

    public Ligne(Produits p, Integer quantite) {
        setP(p);
        setQuantite(quantite);
    }

    public Produits getP() {
        return p;
    }
    public  Double getPrix(){
        return p.getPrixUnitaire().doubleValue() * getQuantite();
    }
    public void setP(Produits p) {
        this.p = p;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ligne{");
        sb.append("p=").append(p);
        sb.append(", quantite=").append(quantite);
        sb.append('}');
        return sb.toString();
    }
}
