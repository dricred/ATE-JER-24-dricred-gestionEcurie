public class Voiture extends Véhicule {

    public Voiture(String marque, String nom, EtatVéhicule etatVéhicule) {
        super(marque, nom, etatVéhicule);
    }

    @Override
    public String getType() {
        return "voiture";
    }
}
