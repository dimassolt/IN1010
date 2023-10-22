public class HvitResept extends Resept {
    // Deklarerer ny variabel for aa endre pris paa militaere resepter og p-piller
    public int prisAaBetale;

    //Konstruktoer
    public HvitResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        super(legemiddel, lege, pasient, reit);
        prisAaBetale = legemiddel.pris;
    }
    @Override
    public String farge() {
        return "Hvit";
    }
    @Override
    public int prisAaBetale() {
        return prisAaBetale;
    }

    @Override
    public String toString() {
        return "Hvit resept: " + legemiddel + ". Lege som har skrevet resepten ut: " + lege + 
        ". Pasient ID: " + pasient + ". Reit: " + reit + " Pris: " + prisAaBetale; 
    } 
}
