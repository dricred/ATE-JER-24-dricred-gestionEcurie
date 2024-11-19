import java.util.Random;

public class Course {

    private String nom;
    private int nbrParticipant;

    public Course(String nom, int nbrParticipant) {
        this.nom = nom;
        this.nbrParticipant = nbrParticipant;
    }

    @Override
    public String toString() {
        return "Course " + nom + ". Nombre de participant autorisé : " + nbrParticipant;
    }

    private boolean peutParticiper(Écurie écurie) {
        if (!écurie.resteDesVéhicules()
                || écurie.listePiloteDansEcurie().isEmpty()
                || écurie.listeResponsableTechniqueDansEcurie().isEmpty()
                || écurie.listeIngenieurdansEcurie().isEmpty()
                || nbrParticipant < 2) {
            return false;
        }
        return true;
    }

    private int placeEcurieJoueur(Écurie écurie) {
        if (!peutParticiper(écurie)) {
            return 0;
        }

        Random random = new Random();
        return random.nextInt((nbrParticipant + 1)) + 1;
    }


    public void faireLaCourse(Écurie écurie) {
        if (placeEcurieJoueur(écurie) == 0) {
            System.out.println("Vous ne pouvez pas participer à cette course");
            return;
        }
        System.out.println("Vous avez terminé à la place : " + placeEcurieJoueur(écurie));
    }
}
