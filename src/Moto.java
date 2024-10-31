public class Moto extends Véhicule {

    public Moto(String marque, String nom) {
        super(marque, nom);
    }

    @Override
    public String getType() {
        return "moto";
    }
}
