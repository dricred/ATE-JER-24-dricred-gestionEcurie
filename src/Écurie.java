import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Écurie {

    // Les couleurs d'affichages
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    private static final int NBRE_ROLES = 3;

    private String nom;
    private ArrayList<Employe> employes;
    private ArrayList<Véhicule> véhicules = new ArrayList<>();

    public Écurie(String nom, ArrayList<Employe> lesEmployes) {
        this.nom = nom;
        this.employes = lesEmployes;
    }

    public String getNom() {
        return nom;
    }

    public void setVéhicules(ArrayList<Véhicule> véhicules) {
        this.véhicules = véhicules;
    }

    /**
     * affiche tout les employés présent dans l'écurie
     */
    private void afficherToutEmployes() {
        for (int i = 0; i < employes.size(); i++) {
            System.out.print("[Employé : " + (i + 1) + "] ");
            System.out.print(employes.get(i));
            System.out.println();
        }
        System.out.println();
    }

    /**
     * affiche tout les pilotes présent dans l'écurie
     */
    private void afficherPilote() {
        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);

            if (employe instanceof Pilote) {
                System.out.print("[Pilote : " + (i + 1) + "] ");
                System.out.print(employe);
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * affiche tout les responsables technique présent dans l'écurie
     */
    private void afficherResponsableTechnique() {

        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);

            if (employe instanceof ResponsableTechnique) {
                System.out.print("[Responsable Technique : " + (i + 1) + "] ");
                System.out.print(employe);
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * affiche tout les ingénieurs présent dans l'écurie
     */
    private ArrayList<Ingenieur> afficherIngenieure() {
        ArrayList<Ingenieur> listeIngenieur = new ArrayList<>();

        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);

            if (employe instanceof Ingenieur) {
                System.out.print("[Ingénieur : " + (i + 1) + "] ");
                System.out.print(employe);
                listeIngenieur.add((Ingenieur) employe);
                System.out.println();
            }
        }
        System.out.println();
        return listeIngenieur;
    }

    public List<Employe> listePiloteDansEcurie() {
        List<Employe> listePilotes = new ArrayList<>();

        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);

            if (employe instanceof Pilote) {
                listePilotes.add(employe);
            }
        }
        return listePilotes;
    }

    public ArrayList<ResponsableTechnique> listeResponsableTechniqueDansEcurie() {
        ArrayList<ResponsableTechnique> listeResponsable = new ArrayList<>();

        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);

            if (employe instanceof ResponsableTechnique) {
                listeResponsable.add((ResponsableTechnique) employe);
            }
        }

        return listeResponsable;
    }

    public ArrayList<Ingenieur> listeIngenieurdansEcurie() {
        ArrayList<Ingenieur> listeIngenieur = new ArrayList<>();

        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);

            if (employe instanceof Ingenieur) {
                listeIngenieur.add((Ingenieur) employe);
            }
        }
        return listeIngenieur;
    }

    /**
     * Vérifie si la liste des employés est vide
     * @return si la liste est vide ou non
     */
    private boolean resteDesEmployes() {
        if (employes.isEmpty()) {
            System.out.println(RED + "-----!!! Il n'y a pas d'employé chez " + nom + " !!!-----" + RESET);
            return false;
        }
        return true;
    }

    /**
     * affiche un text qui nous demande de faire un choix et affiche les choix possible
     * @param messageIntroChoix le texte qui nous demande de faire un choix
     * @param listeMotAAfficher la liste des choix possible
     */
    private void affichagePlusieursChoix(String messageIntroChoix, String[] listeMotAAfficher) {
        System.out.println(messageIntroChoix);
        for (int i = 0; i < listeMotAAfficher.length; i++) {
            System.out.println(RED + (i + 1) + ") " + CYAN + listeMotAAfficher[i] + RESET);
        }
    }

    /**
     * Demande a l'utilisateur quelle type d'affiche il souhaite pour les employés
     * et les affiches en fonction du choix choisit
     */
    private void choixAffichageEmployes() {
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
            default: System.out.println(RED + "-----!!! Choix incorect !!!-----" + RESET);  break;
        }
    }

    /**
     * Supprime un employé de la liste des employés [virer]
     * @param indexEmployes l'index de l'employà à supprimer [virer]
     */
    private void virerUnEmployes(int indexEmployes) {
        if (indexEmployes > employes.size() - 1 || indexEmployes < 0) {
            System.out.println(RED + "-----!!! Le numéro de l'employé n'existe pas !!!-----" + RESET);
            return;
        }

        System.out.println("\nL'employé : " +
                employes.get(indexEmployes).prénom + " " + employes.get(indexEmployes).nom +
                " a été viré");

        employes.remove(indexEmployes);
    }

    /**
     * supprime un ou plusieurs employé(s) de la liste des employés en fonction de ce que l'utilisateur
     * entre comme donnée [Virer]
     */
    private void virerPlusieursEmployes() {
        afficherToutEmployes();

        if (!resteDesEmployes()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel(s) employé(s) voulez-vous virer ? [Séparez les par des espaces]");
        String reponseEmployesASupp = scanner.nextLine();
        String[] valeurIndex = reponseEmployesASupp.split(" ");

        List<Integer> indexASupprimer = new ArrayList<>();

        for (String value : valeurIndex) {
            int index = Integer.parseInt(value) - 1;
            if (index >= 0 && index < employes.size()) {
                indexASupprimer.add(index);
            }
        }

        Collections.sort(indexASupprimer, Collections.reverseOrder());

        for (int index : indexASupprimer) {
            virerUnEmployes(index);
        }
    }

    /**
     * Afficher un message comme quoi l'employé à bien été recruté
     */
    private void afficherMessageEmployesEstRecruter() {
        System.out.println("L'employé : " + employes.get(employes.size() - 1).prénom + " "
                + employes.get(employes.size() - 1).nom + " a été recruter");
    }

    /**
     * Ajouter un employé à la liste des employés en fonction du rôle que choissit l'utilisateur [recruter/embaucher]
     */
    private void recruterUnEmployes() {
        String[] listeChoix = {"Pilote", "Ingenieur", "Responsable technique"};

        affichagePlusieursChoix("Quelles types d'employés voulez-vous afficher ?", listeChoix);
        int choix = new java.util.Scanner(System.in).nextInt();

        if (choix < 1 || choix > NBRE_ROLES) {
            return;
        }

        switch (choix) {
            case 1:
                employes.add(new Pilote(Employe.genererNomAleatoire(), Employe.genererPrénomAleatoire(), 1000F));
                afficherMessageEmployesEstRecruter();
                break;
            case 2:
                employes.add(new Ingenieur(Employe.genererNomAleatoire(), Employe.genererPrénomAleatoire(), 1000F));
                afficherMessageEmployesEstRecruter();
                break;
            case 3:
                employes.add(new ResponsableTechnique(Employe.genererNomAleatoire(), Employe.genererPrénomAleatoire(), 1000F));
                afficherMessageEmployesEstRecruter();
                break;
        }
    }

    /**
     * gère tout ce qui concerne les employés
     */
    private void gereEmploye() {
        String[] listeChoixEmployes = {"Afficher", "Recruter", "Virer"};
        affichagePlusieursChoix("Gérer les employés", listeChoixEmployes);
        int choix = new java.util.Scanner(System.in).nextInt();

        switch (choix) {
            case 1: choixAffichageEmployes();   break;
            case 2: recruterUnEmployes();       break;
            case 3: virerPlusieursEmployes();   break;
            default: System.out.println(RED + "-----!!! Le choix numéro : " + choix +  " n'existe pas !!!-----" + RESET);
            break;
        }
    }

    /**
     * Vérifie si la liste des véhicules est vide
     * @return si la liste des véhicules est vide ou non
     */
    public boolean resteDesVéhicules() {
        if (véhicules.isEmpty()) {
            System.out.println(RED + "-----!!! Il n'y a pas/plus de véhicules chez " + nom + " !!!-----" + RESET);
            return false;
        }
        return true;
    }

    /**
     * affiche tout les véhicules présent dans l'écurie
     */
    private void afficherToutVéhicule() {
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

    /**
     * affiche les voitures présent dans l'écurie
     */
    private void afficherVoiture() {
        for (int i = 0; i < véhicules.size(); i++) {
            Véhicule véhicule = véhicules.get(i);

            if (véhicule instanceof Voiture) {
                System.out.print("[Voiture : " + (i + 1) + "] ");
                System.out.print(véhicule);
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * affiche les motos présent dans l'écurie
     */
    private void afficherMoto() {
        for (int i = 0; i < véhicules.size(); i++) {
            Véhicule véhicule = véhicules.get(i);

            if (véhicule instanceof Moto) {
                System.out.print("[Moto : " + (i + 1) + "] ");
                System.out.print(véhicule);
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Demande a l'utilisateur quelle type d'affiche il souhaite pour les véhicules
     * et les affiches en fonction du choix choisit
     */
    private void choixAffichageVéhicule() {
        String[] listeChoix = {"Tout les véhicules", "Les voitures", "Les motos"};
        affichagePlusieursChoix("Quelles types de véhicules voulez-vous afficher ?", listeChoix);
        int choix = new java.util.Scanner(System.in).nextInt();

        if (!resteDesVéhicules()) {
            return;
        }

        switch (choix) {
            case 1: afficherToutVéhicule();           break;
            case 2: afficherVoiture();                 break;
            case 3: afficherMoto();                    break;
            default: System.out.println(RED + "-----!!! Choix incorect !!!-----" + RESET);  break;
        }
    }

    /**
     *  Ajouter un véhicule à la liste des véhicules en fonction du type de véhicules (moto ou voiture)
     *  que choissit l'utilisateur [Construit]
     */
    private void construireVéhicule() {
        ArrayList<Ingenieur> listIngenieur = afficherIngenieure();

        if (listIngenieur.isEmpty()) {
            System.out.println(RED + "-----!!! Construction Impossible !!!-----\nVous n'avez pas/plus d'ingenieur" + RESET);
            return;
        }
        System.out.println("Ingénieur disponible : " + listIngenieur.size());
        listIngenieur.get(0).construireVéhicule(véhicules, this);
    }

    /**
     * Supprime un véhicule de la liste des véhicules [Détruire]
     * @param indexVéhicule l'index du véhicule à supprimer [Détruire]
     */
    private void détruireUnVéhicule(int indexVéhicule) {
        if (indexVéhicule > employes.size() - 1 || indexVéhicule < 0) {
            System.out.println(RED + "-----!!! Le numéro du véhicule n'existe pas !!!-----" + RESET);
            return;
        }

        System.out.println("\nLe véhicule : " +
                véhicules.get(indexVéhicule).getMarque() + " " + véhicules.get(indexVéhicule).getNom() +
                " a été détruie\n");

        employes.remove(indexVéhicule);
    }

    /**
     * Supprime un ou plusieurs véhicules de la liste des véhicules
     * en fonction de ce que l'utilisateur entre comme index [détruie]
     */
    private void détruirePlusieursVéhicules() {
        afficherToutVéhicule();
        afficherIngenieure();
        ArrayList<Ingenieur> listeIngenieur = listeIngenieurdansEcurie();
        if (!resteDesVéhicules() || listeIngenieur.isEmpty()) {
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

    /**
     * repare le véhicule que l'utilisateur choisit
     */
    private void reparerVéhicule() {
        afficherResponsableTechnique();
        ArrayList<ResponsableTechnique> listResponsable = listeResponsableTechniqueDansEcurie();
        System.out.println("Responsable technique disponible : " + listResponsable.size());

        if (listResponsable.isEmpty()) {
            System.out.println(RED + "-----!!! Construction Impossible !!!-----\nVous n'avez pas/plus d'ingenieur" + RESET);
            return;
        }

        afficherToutVéhicule();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nQuel est le véhicule que vous voulez réparer ?");
        int indexVéhicule = scanner.nextInt() - 1;


        if (indexVéhicule > employes.size() - 1 || indexVéhicule < 0) {
            System.out.println(RED + "-----!!! Le numéro du véhicule n'existe pas !!!-----" + RESET);
            return;
        }

        listResponsable.get(0).reparerVéhicule(véhicules.get(indexVéhicule));
    }

    /**
     * S'occupe de la gestion de tout ce qui concerne les véhicules
     */
    private void gereVehicule() {
        String[] listeChoixEmployes = {"Afficher", "Construire", "Réparer", "Détruire"};
        affichagePlusieursChoix("Gérer les véhicules", listeChoixEmployes);
        int choix = new java.util.Scanner(System.in).nextInt();

        switch (choix) {
            case 1: choixAffichageVéhicule();       break;
            case 2: construireVéhicule();           break;
            case 3: reparerVéhicule();              break;
            case 4: détruirePlusieursVéhicules();   break;
            default: System.out.println(RED + "-----!!! Le choix numéro : " + choix +  " n'existe pas !!!-----" + RESET);
            break;
        }
    }

    private void afficherLesCourses(ArrayList<Course> listeCourses) {
        if (listeCourses.isEmpty()) {
            return;
        }

        for (int i = 0; i < listeCourses.size(); i++) {
            System.out.print(listeCourses.get(i).toString());
            System.out.print(listeCourses.get(i));
            System.out.println();
        }
        System.out.println();
    }

    private void participerAUneCourses(ArrayList<Course> listeCourses) {
        afficherLesCourses(listeCourses);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoisissez la course que vous voulez faire : ");
        int indexCourse = scanner.nextInt() - 1;


        if (indexCourse > listeCourses.size() - 1 || indexCourse < 0) {
            System.out.println(RED + "-----!!! Le numéro de la course n'existe pas !!!-----" + RESET);
            return;
        }

        listeCourses.get(0).faireLaCourse(this);
    }

    /**
     * gère tout ce qui concerce une écuire
     */
    public void gestion(ArrayList<Course> listeCourses) {
        boolean[] eteindre = {false};
        String[] listeChoix = {"Gérer les employés", "Gérer les véhicules", "Participer à une course", "Éteindre"};
        do {
            affichagePlusieursChoix("Que voulez-vous faire : ", listeChoix);
            int choix = new java.util.Scanner(System.in).nextInt();

            switch (choix) {
                case 1: gereEmploye();                         break;
                case 2: gereVehicule();                        break;
                case 3: participerAUneCourses(listeCourses);   break;
                case 4: eteindre[0] = true;                    break;
                default: System.out.println(RED + "-----!!! Le choix numéro : " + choix +  " n'existe pas !!!-----" + RESET);
                break;
            }
        } while (!eteindre[0]);
    }
}