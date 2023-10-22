public class Militaerresept extends HvitResept{
    public Militaerresept(Legemiddel legemiddel, Lege lege, Pasient pasient) {
        super(legemiddel, lege, pasient, 3); 
        prisAaBetale = 0;
    }

    @Override
    public String toString() {
        return "Militaer Resept: " + " Pris aa Betale: " + prisAaBetale + " Legemiddel: " + legemiddel + ". Lege: " + lege + 
        ". Pasient ID: " + pasient + ". Reit: " + reit;
    }

}
