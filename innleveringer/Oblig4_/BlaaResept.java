public class BlaaResept extends Resept{
    public BlaaResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        super(legemiddel, lege, pasient, reit);
    }   

    @Override
    public String toString() {
        return "Blaa resept: " + " Pris aa Betale: " + (int)Math.round(legemiddel.pris*0.25) +" "+ super.toString();
    }
    @Override
    public String farge() {
        return "blaa";
    }
    //Teller riktig pris for blaae resepter
    public int prisAaBetale() {
        return (int)Math.round(legemiddel.pris*0.25);
    }
}
