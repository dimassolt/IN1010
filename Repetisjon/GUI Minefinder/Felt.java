import java.util.List;
/**
 * Klassen felt representerer hver rute i Minesveiper.
 * Den kan være tom, være nabo til en mine, eller har en mine i seg
 */
public abstract class Felt {
    protected Modell modell;
    protected boolean erKlikket = false;
    protected List<Felt> naboer = null;
    protected Koordinat koordinat;
    /**
     * Representerer det du trykker på.
     * modellreferansen er der slik at vi kan lagre om det har skjedd noe med denne ruten
     * Koordinatet identifiserer denne ruten
     * @param m modellen 
     * @param k koordinatet til feltet 
     */
    public Felt(Modell m, Koordinat k){
        this.modell = m;
        this.koordinat = k;
    }
    /**
     * Denne metoden finner alt rundt som skal oppdateres når ruten klikkes på.
     * @param forrige ruten som kallte på finn. er altid "this", bortsett fra første gang
     */
    public abstract void finn(Felt forrige);

    /**
     * Er dette feltet en mine?.
     * @return om feltet er en mine eller ikke
     */
    public boolean erMine(){
        return false;
    }

    /**
     * setter listen med naboer. Genereres i konsturktøren til Modell.
     *  Her brukes list, ikke arraylist, fordi vi gjør en "toList" i modell sin
     *  konstruktør. Da vet vi ikke hva slags liste dette faktisk er!
     *  @param n liste med naboer
     */
    public void settNaboer(List<Felt> n){
        naboer = n;
    }
    /**
     * Vanlig hentemetode.
     * @return koordinatet til feltet
     */
    public Koordinat hentKoordinat(){
        return koordinat;
    }
}
