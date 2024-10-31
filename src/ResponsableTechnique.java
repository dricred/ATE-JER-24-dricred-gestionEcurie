import java.util.ArrayList;

public class ResponsableTechnique extends Employes {

    public ResponsableTechnique(String nom, String prénom, float salaire) {
        super(nom, prénom, salaire);
    }

    public ResponsableTechnique(float salaire) {
        super(genererNomAleatoire(), genererPrénomAleatoire(), salaire);
    }

    @Override
    public String getRoles() {
        return "Responsable technique";
    }
}
