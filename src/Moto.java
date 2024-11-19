public class Moto extends Véhicule {

    public Moto(String marque, String nom, EtatVéhicule etatVéhicule) {
        super(marque, nom, etatVéhicule);
    }

    @Override
    public String getType() {
        return "moto";
    }
}
