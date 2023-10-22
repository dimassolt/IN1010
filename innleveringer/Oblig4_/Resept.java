public abstract class Resept {
    Legemiddel legemiddel;
    public final Pasient pasient;
    Lege lege;
    public int reit;
    public final int id;
    public static int gyldigId = 0;

    public Resept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        this.legemiddel = legemiddel;
        this.lege = lege;
        this.pasient = pasient;
        this.reit = reit;
        id = gyldigId;
        gyldigId++;
    }

    public String toString() {
        return  legemiddel + ". Lege som har skrevet resepten ut: " + lege + 
            ". Pasient ID: " + pasient + ". Reit: " + reit;
    }    

    public int hentId(){
        return id;
    }    

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return lege;
    }

    public Pasient hentpasient(){
        return pasient;
    }

    public int hentReit(){
        return reit;
    }

    public boolean bruk(){
        if (reit > 0) {
            reit--;
            return true;
        }return false;
    }

    abstract public String farge();
    abstract public int prisAaBetale();
}
