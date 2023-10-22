public class KontrollVerden {

    // Kostruktor sammen med variabler
    public View utsyn;
    public  int genNr;
    public ModellRutenett rutenett;    
             
    public KontrollVerden (int antRader, int antKolonner){
        utsyn = new View(this);
        rutenett = new ModellRutenett(antRader,antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        genNr = 0;
    }

    // Metode tegn som tegner rutenett
    public void tegn(){
        rutenett.tegnRutenett();    
        System.out.println("Antall generasjon: " + Integer.toString(genNr));
    }

    // Oppretter en ny generasjon 
    public void oppdatering(){
        for(int r = 0; r < rutenett.antRader; r +=1){
            for(int k = 0; k < rutenett.antKolonner; k +=1){
                rutenett.rutene[r][k].tellLevendeNaboer();
            }
        }
        for(int r = 0; r < rutenett.antRader; r +=1){
            for(int k = 0; k < rutenett.antKolonner; k +=1){
                rutenett.rutene[r][k].oppdaterStatus();
            }
        }
        genNr +=1;
        }
    
    // Starter spillet
    public void startSpillet(){
        utsyn.visStatus();
        visCelle();
    }
    // Avslutter spillet
    public void avsluttSpillet(){
        System.exit(0);
    }

    // Metoden skal registrere brukerens valg for aa endre celle status 
    public void brukervalg(int rad, int kol){
        rutenett.noterEndring(rad,kol,rutenett.rutene[rad][kol]);        
        String lev = "❤︎";
        if(rutenett.rutene[rad][kol].erLevende()){

            rutenett.rutene[rad][kol].oppdaterStatus2();
            utsyn.visEndring(rad,kol,'.');
            rutenett.kobleAlleCeller();      

        }
        else{

            rutenett.rutene[rad][kol].oppdaterStatus2();
            utsyn.visEndring(rad,kol,lev.charAt(0));
            rutenett.kobleAlleCeller();
        }
    }

    // Skriver ut antall levende celler som finnes igjen 
    public int skrivUtAntallLevende(){
        return rutenett.antallLevende();
    }
    
    // Viser alle Celler paa GUI interface
    public void visCelle(){
        String lev = "❤︎";
        for(int r = 0; r < rutenett.antRader;r +=1){
            for(int k = 0; k < rutenett.antKolonner; k+=1){

                Celle celle = rutenett.hentCelle(r,k);
                if(celle.erLevende()){
                    utsyn.markerCelle(r,k,lev.charAt(0));
                }
                else{
                    utsyn.markerCelle(r,k,'.');
                }
            }            
        }
    }
}
