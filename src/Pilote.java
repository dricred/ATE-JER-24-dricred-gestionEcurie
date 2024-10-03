public class Pilote extends Employes {

    public Pilote(String nom, String prénom, float salaire) {
        super(nom, prénom, salaire);
    }

    public Pilote(float salaire) {
        super(genererNomAleatoire(), genererPrénomAleatoire(), salaire);
    }

    @Override
    public String getRoles() {
        return "Pilote";
    }
}
