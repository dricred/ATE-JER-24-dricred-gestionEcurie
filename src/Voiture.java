public class Voiture extends Véhicule {

    public Voiture(String marque, String nom) {
        super(marque, nom);
    }

    @Override
    public String getType() {
        return "voiture";
    }
}
