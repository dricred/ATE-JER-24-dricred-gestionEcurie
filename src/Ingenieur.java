import java.util.ArrayList;

public class Ingenieur extends Employe {

    // Les couleurs d'affichage
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    private static final int NBR_TYPE_VEHICULES= 2;

    public Ingenieur(String nom, String prénom, float salaire) {
        super(nom, prénom, salaire);
    }

    public Ingenieur(float salaire) {
        super(genererNomAleatoire(), genererPrénomAleatoire(), salaire);
    }

    @Override
    public String getRoles() {
        return "Ingénieure";
    }

    public void construireVéhicule(ArrayList<Véhicule> véhicules, Écurie écurie) {
        System.out.println("Quelle véhicule voulez-vous construire ?");
        System.out.println(RED + "1) " + CYAN + "Voiture" + RESET);
        System.out.println(RED + "2) " + CYAN + "Moto" + RESET);
        int choix = new java.util.Scanner(System.in).nextInt();

        if (choix < 1 || choix > NBR_TYPE_VEHICULES) {
            System.out.println(RED + "Choix invalide" + RESET);
            return;
        }

        switch (choix) {
            case 1:
                véhicules.add(new Voiture(écurie.getNom(), "voiture v-" + (véhicules.size() + 1), Véhicule.EtatVéhicule.EXCELLANT));
                break;
            case 2:
                véhicules.add(new Moto(écurie.getNom(), "moto v-" + (véhicules.size() + 1), Véhicule.EtatVéhicule.EXCELLANT));
                break;
        }

        System.out.println("Construction en cours ...");
        System.out.println("Le véhicule a bien été construite\n");
    }
}
