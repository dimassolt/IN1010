import java.io.File;
import java.util.Scanner;

public class Labyrint {
    // Deklarerer variabler
    Rute[][] lab;
    int antRader;
    int antKolonner;
    String filnavn;

    public Labyrint(String filnavn){
        String linje;

        // Her leser vi data fra fil og setter hver enkel verdi
        try {
        File fil = new File(filnavn);
        Scanner leserLinje = new Scanner(fil);

        // Finner ut antall rader og kolonner
        linje = leserLinje.nextLine();
        antRader = Integer.parseInt(linje.split(" ")[0]);
        antKolonner = Integer.parseInt(linje.split(" ")[1]);
        lab = new Rute[antRader][antKolonner];
        

        // Setter char tegn for hver rute
        while(linje!= null){

            for (int rad = 0; rad < antRader; rad++){
                String linja = leserLinje.nextLine();
                for (int kol = 0; kol < antKolonner; kol++){
                    char c = linja.charAt(kol);
                    if(c == '.' && ( rad == 0 || kol==0 || rad==antRader-1 || kol==antKolonner-1)){
                        lab[rad][kol] = new Aapning(rad,kol,lab);
                    } 
                    else if (c == '.'){
                        lab[rad][kol] = new HvitRute(rad,kol,lab);
                    }
                    else if(c == '#'){
                        lab[rad][kol] = new SortRute(rad,kol,lab);
                    } 
                }
            }       
        }
        leserLinje.close();    

        }
        catch (Exception FileNotFoundException){
        }

        // Setter naboer til den gitte ruten
        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                Rute denne = lab[rad][kol];
                
                try{
                    if(denne!=null && lab[rad-1][kol] != null && !(lab[rad-1][kol] instanceof SortRute)){
                        denne.naboer[0] = lab[rad-1][kol];
                }
                }
                catch (IndexOutOfBoundsException e){    
                }
                try{
                    if(denne!=null && lab[rad+1][kol] != null && !(lab[rad+1][kol] instanceof SortRute)){
                    denne.naboer[1] = lab[rad+1][kol]; 
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                try {
                    if(denne!=null && lab[rad][kol-1] != null && !(lab[rad][kol-1] instanceof SortRute)){
                    denne.naboer[2] = lab[rad][kol-1];
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                try{
                    if(denne!=null && lab[rad][kol+1] != null && !(lab[rad][kol+1] instanceof SortRute)){
                    denne.naboer[3] = lab[rad][kol+1];
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
            }
        }                       
    }

    // Finner veien ut for de gitte koordinater 
    public void finnUtVei(int r, int k){
        Rute rute = lab[r][k];
        if(rute.toString().equals(".")){
            rute.finn(null); 
        }
        else{
            System.out.println("Oppgi koordinater for hvit rute!");
        }
            
    }
    
    // Skrive ut labyrint
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rute[] rad : lab) {
            for (Rute rute : rad) {
                sb.append(rute);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}