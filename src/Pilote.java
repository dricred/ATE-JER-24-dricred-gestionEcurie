public class Pilote extends Employes {

    private Véhicule véhicule;

    public Pilote(String nom, String prénom, float salaire) {
        super(nom, prénom, salaire);
    }

    public Pilote(String nom, String prénom, float salaire, Véhicule véhicule) {
        super(genererNomAleatoire(), genererPrénomAleatoire(), salaire);
        setVéhicule(véhicule);
    }

    public Pilote(float salaire) {
        super(genererNomAleatoire(), genererPrénomAleatoire(), salaire);
    }

    public void setVéhicule(Véhicule véhicule) {
        this.véhicule = véhicule;
    }

    @Override
    public String getRoles() {
        return "Pilote";
    }
}
