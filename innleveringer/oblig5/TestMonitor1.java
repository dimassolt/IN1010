import java.util.HashMap;
import java.util.Scanner;

public class TestMonitor1 {
    public static void main(String[] args) {
            
            // Opretter objekt av klassen SubsekvensRegister
           Monitor1 subsekvenser = new Monitor1(new SubsekvensRegister("testMon1"));
            
            // Henter data fra valgt mappe
            System.out.println("Tast inn mappenavn fra hvor du onsker aa lese data fra: ");
             try (Scanner scanner = new Scanner(System.in)) {
                String mappeNavn = scanner.nextLine();
                
            subsekvenser.taDataUtFraMappe(mappeNavn);
            } 
                // While lokke som bruker slaaSammen metode frem til at det beholdes kun 1 element i subsekvens beholder
            while(subsekvenser.stoerrelse() > 1){
                HashMap<String, Subsekvens> forFil1 = subsekvenser.taUt(0);
                HashMap<String, Subsekvens> forFil2 = subsekvenser.taUt(0);
            
                HashMap<String, Subsekvens> slaattSammen = SubsekvensRegister.slaaSammenHashMaper(forFil1, forFil2);
                subsekvenser.leggTilHashMap(slaattSammen);
            }

            // Her kan vi sjekke inn data om subsekvenser i beholder
            System.out.println(subsekvenser);
            System.out.println("Lengde til registeren: " + subsekvenser.stoerrelse());
            
    

            // Her skal vi finne subsekvensen som har flest forekomster
            Subsekvens stoerste = new Subsekvens(null,0);
            for(HashMap<String, Subsekvens> i: subsekvenser.subsekvenser.hashBeholder){
        
                int antall = 0;
                for(Subsekvens sub:i.values()){
                    if(sub.hentAntallForekomster()>antall){
                        stoerste = sub;
                        antall = stoerste.hentAntallForekomster();
                    }
                }
            }

            System.out.println("Subsekvensen som har flest forekomster: " +stoerste);
    }
}
       

    

