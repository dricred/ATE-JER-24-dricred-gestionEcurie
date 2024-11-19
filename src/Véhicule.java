public abstract class Véhicule {
    public enum EtatVéhicule {
        MAUVAIS("mauvais"),
        PAS_OUF("pas fou (bientôt en mauvais état)"),
        CORRECTE("correct"),
        BON("bonne"),
        EXCELLANT("excellant");

        private final String nomÉtat;

        EtatVéhicule (String nom) {
            this.nomÉtat = nom;
        }


        @Override
        public String toString() {
            return "État du véhicule: " + nomÉtat;
        }
    }

    private String marque;
    private String nom;
    private EtatVéhicule etatVéhicule;

    public Véhicule(String marque, String nom, EtatVéhicule etatVéhicule) {
        this.marque = marque;
        this.nom = nom;
        this.etatVéhicule = etatVéhicule;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public EtatVéhicule getEtatVéhicule() {
        return etatVéhicule;
    }

    public void setEtatVéhicule(EtatVéhicule etatVéhicule) {
        this.etatVéhicule = etatVéhicule;
    }

    @Override
    public String toString() {
        return "Type du véhicule : " + getType() + ". Nom du véhicule : " + nom + ". Marque : " + marque + " " + etatVéhicule;
    }

    public abstract String getType();

}
