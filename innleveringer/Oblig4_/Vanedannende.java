public class Vanedannende extends Legemiddel {
    public final int styrke;

    //Konstruktoer
    public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }
    public String toString() {
        super.toString();
        return super.toString() + " Styrke: " + styrke + " ID: " + id;
    }
}
