import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Modell{
    private Object kontroll; 
    private boolean erFerdig = false;
    private HashMap<Koordinat, Tilstand> koordinaterSomOppdateres;

    private HashMap<Koordinat, Felt> felter
        = new HashMap<Koordinat,Felt>();
    /**
     * Modell-klassen har ansvar for å håndtere den indre tilstanden i minesveiper.
     * @param bredde hvor mange ruter horisontalt.
     * @param hoyde hvor mange ruter vertikalt.
     * @param antallMiner hvor mange miner som lages.
     * @author Hilmar Elverhøy
     */
    public Modell(int bredde, int hoyde, int antallMiner){
        Koordinat.bredde = bredde;
        Koordinat.hoyde = hoyde;

        HashMap<Koordinat, Felt> miner = new HashMap<>();

        //fortsetter helt til riktig antal miner er laget.
        while(miner.size()< antallMiner){
            Random r = new Random();
            int x = r.nextInt(bredde);
            int y = r.nextInt(hoyde);
            Koordinat k = new Koordinat(x,y);
            miner.putIfAbsent(k,new MineFelt(this, k));
        }

        /*
         * Her kommer det noen skumle noen.
         * Først legger vi alle minene i hashmappen med alle feltene våre.
         * Så går vi gjennom alle minene.
         * For hver mine, finner vi naboene, og lager nabofelter
         * disse blir lagt i hashmapen med alle feltene våre
         */
        miner.forEach((minekoordinat, minefelt) ->
                felter.put(minekoordinat,minefelt));

        miner.forEach((minekoordinat, minefelt) ->{
            Koordinat.naboKoordinator(minekoordinat).forEach(
                    (nabo) -> {
                        felter.putIfAbsent(nabo, new NaboFelt(this,nabo));
                    });
        });
        // legger på plass alle felter som ikke er miner eller naboer
        for (int x = 0; x < bredde; x++){
            for (int y = 0; y < hoyde; y++){
                Koordinat k = new Koordinat(x,y);
                felter.putIfAbsent(k,new TomtFelt(this,k));
            }

        }
        /*
         * Enda en rakker. Vi skal jobbe gjennom alle feltene
         * Hvert felt skal få naboer.
         * vi finner nabokoordinatene og gjør dem til en "stream"
         * vi gjør hvert nabokoordinat fra et koordinat til det tilsvarende
         * feltet, vet å slå opp i felter map-et
         * collect tar det fra "stream" tilbake til liste
         * Så er naboene satt!
         */
        felter.forEach((koordinat, felt) ->{
            felt.settNaboer(
                Koordinat.naboKoordinator(koordinat)
                    .stream()
                    .map(naboKoordinat -> felter.get(naboKoordinat))
                    .collect(Collectors.toList()));
        });

    }




    /**
     * Hver gang et felt blir funnet, kalles denne og vi queuer en oppdatering
     * av det. Dette blir så sendt til gui-en, og den fikser resten.
     * @param koordinat koordinatet til feltet som skal oppdateres
     * @param tilstand tilstanden feltet settes til.
     */

    public void skalOppdateres(Koordinat koordinat, Tilstand tilstand){
        koordinaterSomOppdateres.put(koordinat, tilstand);
    }

    /** 
     * Brukes ikke:). spillFerdig() kalles når man trykker på et minefelt.  Så
     * lagrer modellen en boolean, kan fortelle kontroll at
     * spillet er over, og at brukeren er en n00b.
     *
     */
    public void spillFerdig(){
        erFerdig = true;
    }

    /**
     * Kontroll kaller denne funksjonen for å finneut hva som skal skje.
     * ja, navnet er er ikke helt perfekt. Men dette er ikke
     * en perfekt verden.
     * @param koordinat koordinatet som ble trykket på av gui-en
     * @return En Hashmap Med koordinat
     */

    public HashMap<Koordinat, Tilstand> regn(Koordinat koordinat){
        //Glem oppdateringer som har blitt håndtert
        koordinaterSomOppdateres = new HashMap<Koordinat,Tilstand>();
        Felt start = felter.get(koordinat);
        start.finn(null);
        // Felt.finn() har nå lagt koordinatene som skal oppdateres. sendes til gui
        return koordinaterSomOppdateres;
    }
    /**
     * Den brukes ikke i programmet, men var kjekk da jeg skrev den ene testen min
     * @param k koordinatet til feltet du vil ha ut.
     * @return feltet som ligger på koordinatet k
     */
    public Felt hentFelt(Koordinat k){
        return felter.get(k);
    }
}
