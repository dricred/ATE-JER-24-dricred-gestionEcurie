import java.util.ArrayList;
import java.util.Scanner;

public class Écurie {
    private static final int NBRE_ROLES = 3;

    private String nom = "Mon écurie";
    private ArrayList<Employes> employes;

    public Écurie(String nom) {
        this.nom = nom;
    }

    public Écurie(String nom, ArrayList<Employes> lesEmployes) {
        this.nom = nom;
        this.employes = lesEmployes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void affichageEmployes() {
        for (int i = 0; i < employes.size(); i++) {
            System.out.print("[Employé(e) : " + (i + 1) + "] ");
            System.out.print(employes.get(i));
            System.out.println();
        }
        System.out.println();
    }

    public void virerUnEmployes(int indexEmployes) {
        if (employes.isEmpty()) {
            System.out.println("Il n'y a plus d'employé(e) chez " + nom);
            return;
        } else if (indexEmployes > employes.size() - 1 || indexEmployes < 0) {
            System.out.println("!! Le numéro de l'employé(e) n'existe pas !!");
            return;
        }

        System.out.println("\nL'employé(e) : " +
                employes.get(indexEmployes).prénom + " " + employes.get(indexEmployes).nom +
                " a été viré\n");

        employes.remove(indexEmployes);
    }

    public void recruterUnEmployes() {
        System.out.println("Quel rôle voules-vous recruter : ");
        System.out.println("1) Pilote");
        System.out.println("2) Ingenieur");
        System.out.println("3) Responsable technique");
        int choix = new java.util.Scanner(System.in).nextInt();
        if (choix < 1 || choix > NBRE_ROLES) {
            return;
        }

        switch (choix) {
            case 1:
                employes.add(new Pilote(Employes.genererNomAleatoire(), Employes.genererPrénomAleatoire(), 1F));
                System.out.println("!! L'employé(e) : " + employes.get(employes.size() - 1).prénom + " "
                        + employes.get(employes.size() - 1).nom + " a été recruter !!");
                break;
            case 2:
                employes.add(new Ingenieure(Employes.genererNomAleatoire(), Employes.genererPrénomAleatoire(), 1F));
                System.out.println("!! L'employé(e) : " + employes.get(employes.size() - 1).prénom + " "
                        + employes.get(employes.size() - 1).nom + " a été recruter !!");
                break;
            case 3:
                employes.add(new ResponsableTechnique(Employes.genererNomAleatoire(), Employes.genererPrénomAleatoire(), 1F));
                System.out.println("!! L'employé(e) : " + employes.get(employes.size() - 1).prénom + " "
                        + employes.get(employes.size() - 1).nom + " a été recruter !!");
                break;
        }
    }
}
