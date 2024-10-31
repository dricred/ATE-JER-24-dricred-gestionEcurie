import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Écurie {

    // Les couleurs d'affichage
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    private static final int NBRE_ROLES = 3;

    private String nom;
    private ArrayList<Employes> employes;
    private ArrayList<Véhicule> véhicules = new ArrayList<>();

    public Écurie(String nom, ArrayList<Employes> lesEmployes) {
        this.nom = nom;
        this.employes = lesEmployes;
    }

    public String getNom() {
        return nom;
    }

    /**
     * affiche tout les employés présent dans l'écurie
     */
    public void afficherToutEmployes() {
        for (int i = 0; i < employes.size(); i++) {
            System.out.print("[Employé : " + (i + 1) + "] ");
            System.out.print(employes.get(i));
            System.out.println();
        }
        System.out.println();
    }

    /**
     * affiche les pilotes présent dans l'écurie
     */
    public void afficherPilote() {
        for (int i = 0; i < employes.size(); i++) {
            Employes employe = employes.get(i);

            if (employe instanceof Pilote) {
                System.out.print("[Pilote : " + (i + 1) + "] ");
                System.out.print(employe);
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * affiche les responsables technique présent dans l'écurie
     */
    public void afficherResponsableTechnique() {
        for (int i = 0; i < employes.size(); i++) {
            Employes employe = employes.get(i);

            if (employe instanceof ResponsableTechnique) {
                System.out.print("[Responsable Technique : " + (i + 1) + "] ");
                System.out.print(employe);
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * affiche les ingénieurs présent dans l'écurie
     */
    public ArrayList<Ingenieure> afficherIngenieure() {
        ArrayList<Ingenieure> listeIngenieur = new ArrayList<>();

        for (int i = 0; i < employes.size(); i++) {
            Employes employe = employes.get(i);

            if (employe instanceof Ingenieure) {
                System.out.print("[Ingénieur : " + (i + 1) + "] ");
                System.out.print(employe);
                listeIngenieur.add((Ingenieure) employe);
                System.out.println();
            }
        }
        System.out.println();
        return listeIngenieur;
    }

    /**
     * Vérifie si la liste des employes est vide
     * @return si la liste est vide ou non
     */
    private boolean resteDesEmployes() {
        if (employes.isEmpty()) {
            System.out.println(RED + "Il n'y a pas/plus d'employé chez " + nom + RESET);
            return false;
        }
        return true;
    }

    /**
     * Méthode qui affiche un text qui nous demande de faire un choix et les choix possible qui se trouve dans la liste
     * @param messageIntroChoix le texte qui nous demande de faire un choix
     * @param listeMotAAfficher les choix possible
     */
    public void affichagePlusieursChoix(String messageIntroChoix, String[] listeMotAAfficher) {
        System.out.println(messageIntroChoix);
        for (int i = 0; i < listeMotAAfficher.length; i++) {
            System.out.println(RED + (i + 1) + ") " + CYAN + listeMotAAfficher[i] + RESET);
        }
    }

    /**
     * Demande a l'utilisateur quelle type d'affiche il souhaite et ensuite, on l'affiche
     */
    public void choixAffichageEmployes() {
        String[] listeChoix = {"Tout les employés", "Les pilotes", "Les responsables technique", "Les ingénieurs"};
        affichagePlusieursChoix("Quelles types d'employés voulez-vous afficher ?", listeChoix);
        int choix = new java.util.Scanner(System.in).nextInt();

        if (!resteDesEmployes()) {
            return;
        }

        switch (choix) {
            case 1: afficherToutEmployes();           break;
            case 2: afficherPilote();                 break;
            case 3: afficherResponsableTechnique();   break;
            case 4: afficherIngenieure();             break;
            default: System.out.println(RED + "Choix incorect" + RESET);  break;
        }
    }

    /**
     * Suprime un employes de la liste (virer)
     * @param indexEmployes l'indexe de l'employes a supprimer/virer
     */
    public void virerUnEmployes(int indexEmployes) {
        if (indexEmployes > employes.size() - 1 || indexEmployes < 0) {
            System.out.println(RED + "!! Le numéro de l'employé n'existe pas !!" + RESET);
            return;
        }

        System.out.println("\nL'employé : " +
                employes.get(indexEmployes).prénom + " " + employes.get(indexEmployes).nom +
                " a été viré\n");

        employes.remove(indexEmployes);
    }

    /**
     * supprime (vire) un ou plusieurs employes de la liste en fonction de ce que l'utilisateur tape
     */
    public void virerPlusieursEmployes() {
        afficherToutEmployes();

        if (!resteDesEmployes()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quels employés voulez-vous virer ? Séparez les par des espaces");
        String reponseDesRelance = scanner.nextLine();
        String[] values = reponseDesRelance.split(" ");

        List<Integer> indicesASupprimer = new ArrayList<>();

        for (String value : values) {
            int index = Integer.parseInt(value) - 1;
            if (index >= 0 && index < employes.size()) {
                indicesASupprimer.add(index);
            }
        }

        Collections.sort(indicesASupprimer, Collections.reverseOrder());

        for (int index : indicesASupprimer) {
            virerUnEmployes(index);
        }
    }

    public void afficherMessageEmployesEstRecruter() {
        System.out.println("!! L'employé : " + employes.get(employes.size() - 1).prénom + " "
                + employes.get(employes.size() - 1).nom + " a été recruter !!");
    }

    /**
     * Ajouter un employe (embaucher) en fonction du role que choissit l'utilisateur
     */
    public void recruterUnEmployes() {
        String[] listeChoix = {"Pilote", "Ingenieur", "Responsable technique"};

        affichagePlusieursChoix("Quelles types d'employés voulez-vous afficher ?", listeChoix);
        int choix = new java.util.Scanner(System.in).nextInt();

        if (choix < 1 || choix > NBRE_ROLES) {
            return;
        }

        switch (choix) {
            case 1:
                employes.add(new Pilote(Employes.genererNomAleatoire(), Employes.genererPrénomAleatoire(), 1F));
                afficherMessageEmployesEstRecruter();
                break;
            case 2:
                employes.add(new Ingenieure(Employes.genererNomAleatoire(), Employes.genererPrénomAleatoire(), 1F));
                afficherMessageEmployesEstRecruter();
                break;
            case 3:
                employes.add(new ResponsableTechnique(Employes.genererNomAleatoire(), Employes.genererPrénomAleatoire(), 1F));
                afficherMessageEmployesEstRecruter();
                break;
        }
    }

    public void gereEmploye() {
        String[] listeChoixEmployes = {"Afficher", "Recruter", "Virer"};
        affichagePlusieursChoix("Gérer les employés", listeChoixEmployes);
        int choix = new java.util.Scanner(System.in).nextInt();

        switch (choix) {
            case 1: choixAffichageEmployes();   break;
            case 2: recruterUnEmployes();       break;
            case 3: virerPlusieursEmployes();   break;
            default: System.out.println(RED + "!!! Le choix numéro : " + choix +  " n'existe pas !!!" + RESET);  break;
        }
    }

    /**
     * Vérifie s'il la liste des véhicules est vide
     * @return si la liste des véhicules est vide ou non
     */
    public boolean resteDesVéhicules() {
        if (véhicules.isEmpty()) {
            System.out.println(RED + "Il n'y a pas/plus de véhicules chez " + nom + RESET);
            return false;
        }
        return true;
    }

    /**
     * affiche les véhicules présent dans l'écurie
     */
    public void affichageVéhicule() {
        if (!resteDesVéhicules()) {
            return;
        }
        for (int i = 0; i < véhicules.size(); i++) {
            System.out.print("[Véhicule : " + (i + 1) + "] ");
            System.out.print(véhicules.get(i));
            System.out.println();
        }
        System.out.println();
    }

    public void construireVéhicule() {
        ArrayList<Ingenieure> listIngenieur = afficherIngenieure();

        if (listIngenieur.isEmpty()) {
            System.out.println(RED + "!!! Construction Impossible !!!\nVous n'avez pas/plus d'ingenieur" + RESET);
            return;
        }
        System.out.println("Ingénieur disponible : " + listIngenieur.size());
        listIngenieur.get(0).construireVéhicule(véhicules, this);
    }

    public void détruireUnVéhicule(int indexVéhicule) {

        if (indexVéhicule > employes.size() - 1 || indexVéhicule < 0) {
            System.out.println(RED + "!!! Le numéro du véhicule n'existe pas !!!" + RESET);
            return;
        }

        System.out.println("\nLe véhicule : " +
                véhicules.get(indexVéhicule).getMarque() + " " + véhicules.get(indexVéhicule).getNom() +
                " a été détruie\n");

        employes.remove(indexVéhicule);
    }

    public void détruirePlusieursVéhicules() {
        affichageVéhicule();

        if (!resteDesVéhicules()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quels véhicules voulez-vous détruire ? Séparez les par des espaces");
        String reponseDesRelance = scanner.nextLine();
        String[] values = reponseDesRelance.split(" ");

        List<Integer> indicesASupprimer = new ArrayList<>();

        for (String value : values) {
            int index = Integer.parseInt(value) - 1;
            if (index >= 0 && index < véhicules.size()) {
                indicesASupprimer.add(index);
            }
        }

        Collections.sort(indicesASupprimer, Collections.reverseOrder());

        for (int index : indicesASupprimer) {
            détruireUnVéhicule(index);
        }
    }

    public void gereVehicule() {
        String[] listeChoixEmployes = {"Afficher", "Construire", "Détruire"};
        affichagePlusieursChoix("Gérer les véhicules", listeChoixEmployes);
        int choix = new java.util.Scanner(System.in).nextInt();

        switch (choix) {
            case 1: affichageVéhicule();            break;
            case 2: construireVéhicule();           break;
            case 3: détruirePlusieursVéhicules();   break;
            default: System.out.println(RED + "!!! Le choix numéro : " + choix +  " n'existe pas !!!" + RESET);  break;
        }
    }

    public void gestion() {
        boolean[] eteindre = {false};
        String[] listeChoix = {"Gérer les employés", "Gérer les véhicules", "Éteindre"};
        do {
            affichagePlusieursChoix("Que voulez-vous faire : ", listeChoix);
            int choix = new java.util.Scanner(System.in).nextInt();

            switch (choix) {
                case 1: gereEmploye();            break;
                case 2: gereVehicule();           break;
                case 3: eteindre[0] = true;       break;
                default: System.out.println(RED + "!!! Le choix numéro : " + choix +  " n'existe pas !!!" + RESET);  break;
            }
        } while (!eteindre[0]);
    }
}