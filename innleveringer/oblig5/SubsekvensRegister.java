import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SubsekvensRegister{
    // Deklarerer variabler
    public String navn;
    public ArrayList<HashMap<String,Subsekvens>> hashBeholder;

    // Konstruktor
    public SubsekvensRegister(String navn){
        hashBeholder = new ArrayList<HashMap<String,Subsekvens>>();
        this.navn = navn;
    }
    // Metode til aa legge til en ny HashMap inni beholder
    public void leggTilHashMap(HashMap<String,Subsekvens> ny){
        hashBeholder.add(ny);
    }
    // Ta ut HashMap som kreves
    public HashMap<String, Subsekvens> taUt(int indeks){
        if(hashBeholder.size() == 0 || indeks> stoerrelse()){
            return null;
        }
        else{
            return hashBeholder.remove(indeks);
        }
    } 

    // Henter beholder
    public HashMap<String, Subsekvens> hentBeholder(){
            return hashBeholder.get(0);
    } 

    // Sjekker beholders stoerrelse
    public int stoerrelse(){
        return hashBeholder.size();
    }

    // Lesbar form for beholder
    public String toString(){
        String str = "\n";
        for(HashMap<String, Subsekvens> i:hashBeholder){
            str = str+ "\n" + i.values() + "\n"+ "\n";
        } 
        return "Her er gitte subsekvenser for: "+ navn +str;
    }

    // Leser subsekvenser fra gitt fil
    public static HashMap<String,Subsekvens> lesFil(String filnavn) throws IOException{

        HashMap<String, Subsekvens> subsek = new HashMap<String, Subsekvens>();
        BufferedReader lesLinje = new BufferedReader(new FileReader(filnavn));
        String linje;
        while ((linje = lesLinje.readLine()) != null) {
            for (int i = 0; i < linje.length() - 2; i++) {
                String subsekvens = linje.substring(i, i + 3);
                subsek.put(subsekvens, new Subsekvens(subsekvens,1));
            }
        }
        lesLinje.close();
        return subsek;
    }

    // Skal slaa sammen to HashMap som ble opprettet i forrige metode
    public static HashMap<String,Subsekvens> slaaSammenHashMaper(HashMap<String,Subsekvens> hm1, HashMap<String,Subsekvens> hm2) {
        HashMap<String,Subsekvens> sammenslaattHashMap = new HashMap<String,Subsekvens>();

        // Setter inn verdier fra hm1
        for(String i: hm1.keySet()){ 
            Subsekvens subsek =hm1.get(i);
            sammenslaattHashMap.put(i, new Subsekvens(subsek.subsekvens,subsek.leggTilAntallForekomser()));
        }

        // Setter inn verdier fra hm2
        for(String i: hm2.keySet()){ 
            Subsekvens subsek =hm2.get(i);
            if (sammenslaattHashMap.containsKey(i)) {  
                Subsekvens frafoer =sammenslaattHashMap.get(i);
                int forantall = frafoer.hentAntallForekomster();
                int naaant = subsek.hentAntallForekomster();
                frafoer.endreAntallForekomster(forantall+naaant);
            }
            else{
                sammenslaattHashMap.put(i, new Subsekvens(subsek.subsekvens,subsek.leggTilAntallForekomser()));
            }
        }
        return sammenslaattHashMap;

    }

    // Henter data fra den gitte mappen
    public HashMap<String, Subsekvens> taDataUtFraMappe(String mappeNavn){
        HashMap<String, Subsekvens> hmMappe = new HashMap<String, Subsekvens>();
        String folderPath = "./"+ mappeNavn +"/";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        String[] filenames = new String[files.length];

        // Naa finner vi riktig fil blant de som er i mappen
        for (int i = 0; i < files.length; i++) {
            filenames[i] = files[i].getName();
        }
        // Her leser vi referanser til filer fra metadata
        for (String file: filenames) {
            if(file.equals("metadata.csv")){
                try {
                File fil = new File(folderPath+"metadata.csv");
                Scanner innlesning;                
                innlesning = new Scanner(fil);        

                // Her leser vi hvert fil og fyler paa hashBeholder
                try{             
                    String linje = innlesning.nextLine();
                    while(linje != null){
                        String trengteFilnavn =linje;
                        hmMappe = lesFil(folderPath + trengteFilnavn);
                        hashBeholder.add(hmMappe);
                        linje = innlesning.nextLine();                    
                    }                        
                    if(linje == null){
                        innlesning.close();
                    }
                } catch (FileNotFoundException e) {
                 System.out.println("Klarte ikke aa finne filen!");
                }
                    }
                    catch (Exception InvalidParameterException){
                         
                    }                    
            }           
        }
        return hmMappe;
    }
}



