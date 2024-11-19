import java.util.*;

public class Main {
    /**
     * Créer une écurie avec le nom engg fonction de ce que l'utilisateur a tapez
     * @return une écurie avec des employes de base et le nom donner par l'utilisateur
     */
    private static Écurie CreationEcurie() {
        System.out.println("Bienvenue dans Gestion-Ecurie : ");
        System.out.println("Comment voulez-vous appeller votre écurie : ");
        Scanner scanNomEcurie = new Scanner(System.in);

        return new Écurie(scanNomEcurie.nextLine(), employesDeBase());
    }

    /**
     * Créer une liste d'employés de base
     * @return une liste d'employés de base
     */
    private static ArrayList<Employe> employesDeBase() {
        ArrayList<Employe> listeEmployes = new ArrayList<>();

        listeEmployes.add(new Pilote(1750));
        listeEmployes.add(new Pilote(2250));
        listeEmployes.add(new Ingenieur(1500));
        listeEmployes.add(new Ingenieur(1900));
        listeEmployes.add(new ResponsableTechnique(2350));
        listeEmployes.add(new ResponsableTechnique(2320));

        return listeEmployes;
    }

    /**
     * Créer une liste de véhicule de base
     * @return une liste de véhicule de base
     */
    private static ArrayList<Véhicule> véhiculeDeBase(Écurie écurie) {
        ArrayList<Véhicule> listeVéhicule = new ArrayList<>();

        listeVéhicule.add(new Voiture(écurie.getNom(), "canard-mobile", Véhicule.EtatVéhicule.PAS_OUF));
        listeVéhicule.add(new Voiture(écurie.getNom(), "la voiture clown", Véhicule.EtatVéhicule.MAUVAIS));
        listeVéhicule.add(new Moto(écurie.getNom(), "le deux roues", Véhicule.EtatVéhicule.BON));

        return listeVéhicule;
    }

    private static ArrayList<Course> lesCoursesDisponible() {
        ArrayList<Course> listeCourses = new ArrayList<>();

        listeCourses.add(new Course("Course-1", 3));
        listeCourses.add(new Course("Course-2", 1));
        listeCourses.add(new Course("Course-3", 10));
        listeCourses.add(new Course("Course-4", 100));
        listeCourses.add(new Course("Course-5", 0));

        return listeCourses;
    }

    public static void main(String[] args) {
        Écurie écurieUtilisateur = CreationEcurie();
        écurieUtilisateur.setVéhicules(véhiculeDeBase(écurieUtilisateur));
        écurieUtilisateur.gestion(lesCoursesDisponible());
    }
}