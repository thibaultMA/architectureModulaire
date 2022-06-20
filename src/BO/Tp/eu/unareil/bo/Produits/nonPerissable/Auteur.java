package BO.Tp.eu.unareil.bo.Produits.nonPerissable;

public class Auteur {
    private String nom;
    private String prenom;

    public Auteur(String nom, String prenom) {

        setNom(nom);
        setPrenom(prenom);

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auteurs{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
