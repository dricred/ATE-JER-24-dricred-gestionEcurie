public class Ingenieure extends Employes {

    public Ingenieure(String nom, String prénom, float salaire) {
        super(nom, prénom, salaire);
    }

    public Ingenieure(float salaire) {
        super(genererNomAleatoire(), genererPrénomAleatoire(), salaire);
    }

    @Override
    public String getRoles() {
        return "Ingénieure";
    }
}
