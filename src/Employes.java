import java.util.Random;

public abstract class Employes {
    // Les couleurs d'affichage
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public String nom;
    public String prénom;
    public float salaire;

    public Employes(String nom, String prénom, float salaire) {
        this.nom = nom;
        this.prénom = prénom;
        this.salaire = salaire;
    }

    public String toString() {
        return "Je suis " + CYAN + prénom + " " + nom + RESET + ". Mon rôle est "
                + CYAN + getRoles() + RESET + " et j'ai un salaire de "
                + CYAN + salaire + " CHF." + RESET;
    }

    public abstract String getRoles();

    private static String[] prenoms = {
            "Paul", "Maxime", "Gabriel", "Lucas", "Nathan", "Hugo", "Ethan", "Léo", "Mathis", "Tom",
            "Noah", "Théo", "Raphaël", "Enzo", "Antoine", "Louis", "Adam", "Jules", "Arthur", "Sacha",
            "Clément", "Benjamin", "Alexandre", "Axel", "Liam", "Romain", "Eliott", "Timéo", "Valentin", "Maël",
            "Oscar", "Gaspard", "Victor", "Martin", "Léna", "Eva", "Camille", "Adrien", "Bastien", "Esteban", "Nolan"
    };

    private static String[] noms = {
            "Dupont", "Martin", "Bernard", "Thomas", "Petit", "Durand", "Leroy", "Moreau", "Simon", "Laurent",
            "Lefebvre", "Michel", "Garcia", "David", "Bertrand", "Roux", "Vincent", "Fournier", "Girard", "Bonnet",
            "Dupuis", "Moulin", "Perrot", "Blanc", "Renard", "Gauthier", "Perrin", "Marchand", "Lemoine", "Gaillard",
            "Brun", "Clément", "Barbier", "Maillard", "Garnier", "Chauvet", "Caron", "Bouchet", "Morin", "Langlois"
    };

    /**
     * genere un nom aléatoire en prenant aléatoirement un nom de la liste
     * @return le nom prit aléatoirement
     */
    public static String genererNomAleatoire() {
        Random random = new Random();
        return noms[random.nextInt(noms.length)];
    }

    /**
     * genere un prénom aléatoire en prenant aléatoirement un prénom de la liste
     * @return le prénom prit aléatoirement
     */
    public static String genererPrénomAleatoire() {
        Random random = new Random();
        return prenoms[random.nextInt(noms.length)];
    }
}
