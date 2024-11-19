import java.util.ArrayList;

public class ResponsableTechnique extends Employe {

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

    public void reparerVéhicule(Véhicule véhicule) {
        véhicule.setEtatVéhicule(Véhicule.EtatVéhicule.values() [véhicule.getEtatVéhicule().ordinal() + 1]);
        System.out.println(véhicule);
    }
}
