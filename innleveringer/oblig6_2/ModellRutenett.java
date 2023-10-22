public class ModellRutenett {
        // Kostruktor sammen med variabler
        // Konstruktor sammen med variabler
    public int antRader;
    public int antKolonner;
    Celle[][] rutene;

    public ModellRutenett (int antRader,int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];

    }
    // Metode lagCelle med parametre for rader og kolonner
    public void lagCelle(int rad, int kol){
        Celle cell = new Celle();
        if(Math.random()<=0.3333){
            cell.settLevende();
        }
        rutene[rad][kol] = cell;
    }

    // Registrerer endring i Celles status
    void noterEndring (int r, int k, Celle marker) {
        rutene[r][k] = marker;
    }
    // Metode til aa fylle vaar nett med    elementer av klassen Celle
        public void fyllMedTilfeldigeCeller(){
        for(int r = 0; r<antRader; r+=1){
            for(int k = 0; k<antKolonner; k+=1){
                lagCelle(r,k);
            }
        }        
    }
    // Metode hentCelle som henter Cellens posisjon i rutenett
    public Celle hentCelle(int r, int k){
        if((r<0)||(r >= antRader)||(k<0)||(k>=antKolonner)){
            return null;
        }
        else{
            return rutene[r][k];
        }
    }
    // Metode tegnRutenett som tegner brett for spilet
    public void tegnRutenett(){   
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");

        for(int r = 0; r < rutene.length; r+=1){
            System.out.print("|---".repeat(rutene[0].length));
            System.out.print("|\n");
            for(int k = 0; k < rutene[0].length; k+=1){
                System.out.print("|");
                System.out.print(" " + rutene[r][k].hentStatusTegn() + " "); 
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.print("|---".repeat(rutene[0].length));
        System.out.print("|\n");
    }
    // Metode settNaboer som analyserer hvilken status har hver cellens nabo
    public void settNaboer(int r, int k){
        Celle cell = hentCelle(r,k);
        for(int naboRad = (r-1); naboRad < (r+2); naboRad+=1){
            for(int naboKol = (k-1); naboKol < (k+2); naboKol+=1){
                if (r==naboRad && k ==naboKol){
                    naboKol+=1;           
                }   
                if(hentCelle(naboRad,naboKol)!=null){
                    cell.leggTilNabo(hentCelle(naboRad,naboKol));
            }
            }
        }
    }

    // Metode som kobler celler sammen  
    public void kobleAlleCeller(){
        for(int r = 0; r < antRader;r +=1){
            for(int k = 0; k < antKolonner; k+=1){
            settNaboer(r,k);                     
            }
        }
    }
    // Teller antall levende igjen
    public int antallLevende(){
        int antallLevendeIRutenett = 0;
            for(int r = 0; r < antRader;r+=1){
                for(int k =0; k < antKolonner; k+=1){
                  Celle cell = rutene[r][k];
                  if(cell.erLevende()){ 
                    antallLevendeIRutenett +=1;
                  }  
            }
            
        }
        return antallLevendeIRutenett;
    }
    
}