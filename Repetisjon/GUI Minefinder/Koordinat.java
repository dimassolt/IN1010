import java.util.ArrayList;
import java.util.Arrays;
public class Koordinat{
    static int bredde;
    static int hoyde;
    private int x;
    private int y;
    /**
     * Klasse for å passe på posisjoner i feltet.
     * @param x hvilken posisjon langs x-aksen har Feltet?
     * @param y hvilken posisjon langs y-aksen har Feltet?
     */
    public Koordinat(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Returnerer x koordinatet
     * @return x koordinatet til feltet
     */
    public int hentX(){
        return this.x;
    }
    /**
     * Returnerer y koordinatet
     * @return y koordinatet til feltet
     */
    public int hentY(){
        return this.y;
    }
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
    @Override
    public boolean equals(Object o){
        boolean b = (o instanceof Koordinat);
        boolean bx = ((Koordinat)o).x == x ;
        boolean by = ((Koordinat)o).y == y ;
        return  b && bx && by;
    }
    
    @Override
    public int hashCode(){
        //Grunnen til at denne er her, er at vi lager koordinat objekter i
        //guien for hver knapp, og i modellen for hvert felt. Disse må
        //oppfattes som like av en hashmap, siden det er det vi lagrer feltene
        //i. HashCoden er som "indexen" i et objekt i en liste
        return x*bredde+y;
    }
    /**
     * returnerer en liste med gyldige nabo-koordinater.
     *
     * (Koordinator er en  skrivefeil jeg ble glad i etterhvert)
     * @param k koordinate vi vil ha nabokoordinatoen til
     * @return En liste med koordinater
     */

    public static ArrayList<Koordinat> naboKoordinator(Koordinat k){
        //Lag alle naboer, selv utenfor "brettet"
        ArrayList<Koordinat> naboer = new ArrayList<Koordinat>(
                Arrays.asList(
                new Koordinat(k.x - 1, k.y - 1),
                new Koordinat(k.x - 1, k.y),
                new Koordinat(k.x - 1, k.y + 1),
                new Koordinat(k.x,     k.y - 1),
                new Koordinat(k.x,     k.y + 1),
                new Koordinat(k.x + 1, k.y - 1),
                new Koordinat(k.x + 1, k.y),
                new Koordinat(k.x + 1, k.y + 1)
        ));
        //fjern om de er ugyldige
        naboer.removeIf(koord -> koord.x < 0);
        naboer.removeIf(koord -> koord.y < 0);
        naboer.removeIf(koord -> koord.x == bredde);
        naboer.removeIf(koord -> koord.y == hoyde);

        return naboer;
    }
}

