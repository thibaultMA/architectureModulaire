package BO.cours.db.DAO;

public class ElementChimique {
    private long id;
    private String nom;
    private String symbole;
    private int numAtomique;
    private float masseAtomique;

    // Constructor
    public ElementChimique() {
        super();
    }

    public ElementChimique(long id, String nom, String symbole, int numAtomique, float masseAtomique) {
        this.setId(id);
        this.setNom(nom);
        this.setSymbole(symbole);
        this.setNumAtomique(numAtomique);
        this.setMasseAtomique(masseAtomique);
    }

    public ElementChimique(String nom, String symbole, int numAtomique, float masseAtomique) {
        this(0, nom, symbole, numAtomique, masseAtomique);
    }

    // Getter & Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public int getNumAtomique() {
        return numAtomique;
    }

    public void setNumAtomique(int numAtomique) {
        this.numAtomique = numAtomique;
    }

    public float getMasseAtomique() {
        return masseAtomique;
    }

    public void setMasseAtomique(float masseAtomique) {
        this.masseAtomique = masseAtomique;
    }

    // Methode

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (id == 0) {
            sb.append("ElementChimique [");
        } else {
            sb.append("ElementChimique [id=");
            sb.append(id);
        }
        sb.append(",nom='").append(nom).append('\'');
        sb.append(", symbole='").append(symbole).append('\'');
        sb.append(", numAtomique=").append(numAtomique);
        sb.append(", masseAtomique=").append(masseAtomique);
        sb.append('}');
        return sb.toString();
    }
}
