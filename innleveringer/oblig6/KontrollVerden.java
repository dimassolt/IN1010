public class KontrollVerden {

    // Kostruktor sammen med variabler
    public UtsynGUI utsyn;
    public int genNr;
    public ModellRutenett rutenett;    
             
    public KontrollVerden (int antRader, int antKolonner){
        utsyn = new UtsynGUI(this);
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
        
        if(rutenett.rutene[rad][kol].erLevende()){
            rutenett.rutene[rad][kol].oppdaterStatus2();
            utsyn.visEndring(rad,kol,'.');
            rutenett.kobleAlleCeller();      

        }
        else{
            rutenett.rutene[rad][kol].oppdaterStatus2();
            utsyn.visEndring(rad,kol,'X');
            rutenett.kobleAlleCeller();
        }
    }

    // Skriver ut antall levende celler som finnes igjen 
    public int skrivUtAntallLevende(){
        return rutenett.antallLevende();
    }
    
    // Viser alle Celler paa GUI interface
    public void visCelle(){

        for(int r = 0; r < rutenett.antRader;r +=1){
            for(int k = 0; k < rutenett.antKolonner; k+=1){

                Celle celle = rutenett.hentCelle(r,k);
                if(celle.erLevende()){
                    utsyn.markerCelle(r,k,'X');
                }
                else{
                    utsyn.markerCelle(r,k,'.');
                }
            }            
        }
    }
}
