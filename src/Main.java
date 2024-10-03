import java.util.*;

public class Main {
    // Les couleurs d'affichage
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public static final int CHOIX_PLUS_GRAND = 4;

    public static String obtenirInformationUtilisateur(String prompt) {
        Scanner scanPseudo = new Scanner(System.in);
        System.out.println(prompt);
        return scanPseudo.nextLine();
    }

    public static ArrayList<Employes> employesDeBase() {
        ArrayList<Employes> listeEmployes = new ArrayList<>();
        listeEmployes.add(new Pilote(1));
        listeEmployes.add(new Pilote(1.25F));
        listeEmployes.add(new Ingenieure(1.5F));
        listeEmployes.add(new ResponsableTechnique(1.75F));

        return listeEmployes;
    }

    public static int numeroEmployesAVirer() {
        System.out.println("Quel " + RED + "employé(e) " + RESET + "voulez vous virer : ");
        int employesAVrirer = new Scanner(System.in).nextInt() - 1;
        return employesAVrirer;
    }

    public static void virerUnEmployes(Écurie écurie) {
        écurie.affichageEmployes();
        écurie.virerUnEmployes(numeroEmployesAVirer());
    }

    public static void choixAction(Écurie écurie, boolean[] journeeFin) {
        System.out.println("Que souhaitez vous faire : ");
        System.out.println(RED + "1) " + CYAN + "Afficher les employés" + RESET);
        System.out.println(RED + "2) " + CYAN + "Virer un employé(e)" + RESET);
        System.out.println(RED + "3) " + CYAN + "Recruter un employé(e)" + RESET);
        System.out.println(RED + "4) " + CYAN + "Fin de la journée" + RESET);
        int choix = new java.util.Scanner(System.in).nextInt();

        if (choix < 1 || choix > CHOIX_PLUS_GRAND) {
            return;
        }

        switch (choix) {
            case 1: écurie.affichageEmployes();   break;
            case 2: virerUnEmployes(écurie);      break;
            case 3: écurie.recruterUnEmployes();  break;
            case 4: journeeFin[0] = true;         break;
        }
    }

    public static Écurie CreationEcurie() {
        System.out.println("Bienvenue dans Gestion-Ecurie : ");
        String nomEcurie = obtenirInformationUtilisateur("Comment voulez-vous appeller votre écurie : ");

        return new Écurie(nomEcurie, employesDeBase());
    }

    public static void main(String[] args) {
        Écurie écurieUtilisateur = CreationEcurie();
        boolean[] journeeFini = {false};

        do {
           choixAction(écurieUtilisateur, journeeFini);
        } while (!journeeFini[0]);
    }
}