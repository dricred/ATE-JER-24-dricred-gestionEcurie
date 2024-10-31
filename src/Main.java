import java.util.*;

public class Main {
    public static final int NBR_CHOIX = 7;

    // Les couleurs d'affichage
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    /**
     * Créer une écurie avec le nom engg fonction de ce que l'utilisateur a tapez
     * @return une écurie avec des employes de base et le nom donner par l'utilisateur
     */
    public static Écurie CreationEcurie() {
        System.out.println("Bienvenue dans Gestion-Ecurie : ");
        System.out.println("Comment voulez-vous appeller votre écurie : ");
        Scanner scanNomEcurie = new Scanner(System.in);

        return new Écurie(scanNomEcurie.nextLine(), employesDeBase());
    }

    /**
     * Créer une liste d'employés de base
     * @return une liste d'employés de base
     */
    public static ArrayList<Employes> employesDeBase() {
        ArrayList<Employes> listeEmployes = new ArrayList<>();
        listeEmployes.add(new Pilote(100));
        listeEmployes.add(new Pilote(200));
        listeEmployes.add(new Ingenieure(400));
        listeEmployes.add(new Ingenieure(800));
        listeEmployes.add(new ResponsableTechnique(1600));
        listeEmployes.add(new ResponsableTechnique(3200));
        return listeEmployes;
    }

    public static void main(String[] args) {
        Écurie écurieUtilisateur = CreationEcurie();

        écurieUtilisateur.gestion();
    }
}