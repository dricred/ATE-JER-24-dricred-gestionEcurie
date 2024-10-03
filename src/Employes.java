import java.util.Random;

public abstract class Employes {
    public String nom;
    public String prénom;
    public float salaire;

    public Employes(String nom, String prénom, float salaire) {
        this.nom = nom;
        this.prénom = prénom;
        this.salaire = salaire;
    }

    public String toString() {
        return "Je suis " + prénom + " " + nom + ". Mon rôle est "
                + getRoles() + " et j'ai un salaire de "
                + salaire + ".-";
    }

    public abstract String getRoles();

    private static String[] prenoms = {
            "Alexandre", "Maxime", "Gabriel", "Lucas", "Nathan", "Hugo", "Ethan", "Léo", "Mathis", "Tom",
            "Noah", "Théo", "Raphaël", "Enzo", "Antoine", "Louis", "Adam", "Jules", "Arthur", "Sacha"
    };

    private static String[] noms = {
            "Dupont", "Martin", "Bernard", "Thomas", "Petit", "Durand", "Leroy", "Moreau", "Simon", "Laurent",
            "Lefebvre", "Michel", "Garcia", "David", "Bertrand", "Roux", "Vincent", "Fournier", "Girard", "Bonnet"
    };

    public static String genererNomAleatoire() {
        Random random = new Random();
        return noms[random.nextInt(noms.length)];
    }

    public static String genererPrénomAleatoire() {
        Random random = new Random();
        return prenoms[random.nextInt(noms.length)];
    }
}
