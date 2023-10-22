import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.HashMap;

public class Oblig5Del2A {
    public static void main(String[] args) {
        // Henter mappe 
        String path = args[0];
        File folder = new File(path);

        // Henter filer fra mappe
        File[] files = folder.listFiles();
        String[] filenames = new String[files.length];

        // Her navner vi hver enkel fil i mappe
        for (int i = 0; i < files.length; i++) {
            filenames[i] = files[i].getName();
        }

        int numberOfFiles = filenames.length;

        // Oppretter instansen av klasse Monitor1
        Monitor1 fellesMonitor = new Monitor1(new SubsekvensRegister("hovedprogram"));
        // Her skal vi telle alle filer i mappen
        CountDownLatch antallFiler = new CountDownLatch(numberOfFiles);

        // Loeper gjennom filer i folder og kaster metadata
        for (String file: filenames){
            String filePath = path + "/" + file;
            
            if(file.equals("metadata.csv")){
                break;
            }
            // Legger til kun en HashMap om gangen
            Thread beholder = new Thread(new LeseTrad(fellesMonitor,filePath,antallFiler));
            beholder.start();
            try{
                beholder.join();
            } 
            catch (InterruptedException e){
            }   
        }

        // Slaar sammen HashMap-er i en HashMap
        while(fellesMonitor.stoerrelse() > 1){
            HashMap<String, Subsekvens> hm1 = fellesMonitor.taUt(0);
            HashMap<String, Subsekvens> hm2 = fellesMonitor.taUt(0);
            HashMap<String, Subsekvens> slaattSammen = SubsekvensRegister.slaaSammenHashMaper(hm1, hm2);
            fellesMonitor.leggTilHashMap(slaattSammen);
        }
        // Finner subsekvensen som treffes flest
        Subsekvens stoerste = new Subsekvens(null,0);
        for(HashMap<String, Subsekvens> i: fellesMonitor.subsekvenser.hashBeholder){
            int antall = 0;
            for(Subsekvens sub:i.values()){
                if(sub.hentAntallForekomster()>antall){
                    stoerste = sub;
                    antall = stoerste.hentAntallForekomster();
                }
            }
            System.out.println("Subsekvensen som har flest forekomster: " +stoerste);
        }   
    }
}