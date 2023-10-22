public class Presept extends HvitResept {
    //Fast rabatt
    private final int rabatt = 108; 

    public Presept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        super(legemiddel, lege, pasient, reit);
        prisAaBetale = legemiddel.pris - rabatt; 

        //Prisen kan ikke være mindre enn null:
        if (prisAaBetale < 0){
            prisAaBetale = 0;
    }    
}
    @Override
    public String toString() {
        return "P-Resept" + ". Pris aa Betale: " + prisAaBetale + " Legemiddel: " + legemiddel + 
        ". Lege: " + lege + ". Pasient ID: " + pasient + ". Reit: " + reit;
    }
    
}
