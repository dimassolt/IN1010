public abstract class Rute {
    // Deklarerer variabler
    int antRader;
    int antKolonner;
    Rute lab[][];
    Rute[] naboer = new Rute[4];
    boolean sjekke = false;

    // Konstruktor
    public Rute(int rad, int kol, Rute[][] lab){
        antRader = rad;
        antKolonner = kol;
        this.lab = lab;

    }
    // Deklarerer metode finn() som skal brukes videre 
    abstract void finn(Rute fra);
}
