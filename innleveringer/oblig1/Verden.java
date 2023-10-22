public class Verden {
    // Kostruktor sammen med variabler

    public  int genNr;
    public Rutenett rutenett;    
             
    public Verden (int antRader, int antKolonner){
        rutenett = new Rutenett(antRader,antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        genNr = 0;

    }

    // Metode tegn som tegner rutenett og skriver antLevende

    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Generasjons nummer: " + genNr);
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
    }

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

}

