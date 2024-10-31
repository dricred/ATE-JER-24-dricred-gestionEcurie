public abstract class Véhicule {

    private String marque;
    private String nom;

    public Véhicule(String marque, String nom) {
        this.marque = marque;
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Type du véhicule : " + getType() + ". Nom du véhicule : " + nom + ". Marque : " + marque;
    }

    public abstract String getType();

}
