import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable{
    // Deklarerer variabler
    public Monitor1 beholder;
    public String filnavn;
    public CountDownLatch antallFiler;

    // Konstruktor
    public LeseTrad(Monitor1 beholder, String filnavn, CountDownLatch antallFiler){
        this.beholder = beholder;
        this.filnavn = filnavn;
        this.antallFiler = antallFiler;
    }

    // Metode run som leser fil og legger HashMap i beholder
    @Override
    public void run(){        
        HashMap<String,Subsekvens> hm = new HashMap<String,Subsekvens>();
        try {
            hm = Monitor1.lesFil(filnavn);
        } catch (IOException e) {
            System.out.println("Det oppsto feil ved bruk av run metode LeseTrad");
        }
        beholder.leggTilHashMap(hm);
        antallFiler.countDown();
    }        
}
