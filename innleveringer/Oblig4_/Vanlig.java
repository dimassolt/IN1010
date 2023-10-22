public class Vanlig extends Legemiddel{
    
    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff);
    }

    public String toString() {
        super.toString();
        return super.toString() + " ID: " + id;
}
}