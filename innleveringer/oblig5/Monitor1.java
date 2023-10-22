import java.util.HashMap;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {
    // Deklarerer variabler
    private Lock laas = new ReentrantLock();
    SubsekvensRegister subsekvenser;

    // Konstruktor som tar inn objekt fra klassen SubsekvensRegister
    public Monitor1(SubsekvensRegister subsekvenser){

    this.subsekvenser = subsekvenser;
    }

    // Legg til en HashMap om gangen
    public void leggTilHashMap(HashMap<String,Subsekvens> ny){
        laas.lock();
        try{
            subsekvenser.leggTilHashMap(ny);
        }
        finally{
            laas.unlock();
        }
    }

    // taUt fra SubsekvensRegister
    public HashMap<String, Subsekvens> taUt(int indeks){
        return subsekvenser.taUt(indeks);
    } 

    // hent fra SubsekvensRegister
    public HashMap<String, Subsekvens> hentBeholder(){
        return subsekvenser.hentBeholder();
    } 

    // Sjekker beholders stoerrelse
    public int stoerrelse(){
        return subsekvenser.stoerrelse();
    }

    // Lesbar form for beholder
    public String toString(){
        
        return subsekvenser.toString();
    }

    // Leser subsekvenser fra gitt fil
    public static HashMap<String,Subsekvens> lesFil(String filnavn) throws IOException{
        return SubsekvensRegister.lesFil(filnavn);
    }

    // Slaa sammen to HashMap som ble opprettet i forrige metode
    public static HashMap<String,Subsekvens> slaaSammenHashMaper(HashMap<String,Subsekvens> hm1, HashMap<String,Subsekvens> hm2) {
        return SubsekvensRegister.slaaSammenHashMaper(hm1,hm2);
    }

    // Henter data fra den gitte mappen
    public HashMap<String, Subsekvens> taDataUtFraMappe(String mappeNavn){
        return subsekvenser.taDataUtFraMappe(mappeNavn);
    }
}
    
    
    
    

