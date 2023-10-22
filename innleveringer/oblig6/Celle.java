public class Celle {
    // Konstruktor
    public boolean levende = false;
    public Celle naboer[] = new Celle[8];
    public int antNaboer = 0;
    public int antLevendeNaboer = 0;

    // Metode settDoed uten retur
    public void settDoed(){
        levende = false;
    }
    // Metode settLevende uten retur
    public void settLevende(){
        levende = true;
    }
    // Metode erLevende med retur av boolsk verdi
    public boolean  erLevende(){
        if (levende == true)
            return true;
        else{
            return false;
        }
    }
    // Metode hentStatusTegn med retur av char
    public char hentStatusTegn(){
        if(levende == true){
            return 'X';
        
        }
        else{   
            return ' ';
        }
    }
    // Metode leggTilNabo uten retur
    public void leggTilNabo(Celle nabo){
        naboer [antNaboer] =nabo;
        antNaboer +=1;

    }
    // Metode tellLevendeNabuer uten retur, klarte ikke aa gjore den kortere 
    public void tellLevendeNaboer(){
        antLevendeNaboer = 0;    
        if(( naboer[0]!= null) && ( naboer[0].erLevende()) ){
            antLevendeNaboer += 1;
        }        
        if(( naboer[1]!= null) && (naboer[1].erLevende())){
            antLevendeNaboer += 1;
        }        
        if(( naboer[2]!= null) && (naboer[2].erLevende())){
            antLevendeNaboer += 1;
        }        
        if(( naboer[3]!= null) && (naboer[3].erLevende())){
            antLevendeNaboer += 1;
        }        
        if(( naboer[4]!= null) && (naboer[4].erLevende())){
            antLevendeNaboer += 1;
        }        
        if(( naboer[5]!= null) && (naboer[5].erLevende())){
            antLevendeNaboer += 1;
        }        
        if(( naboer[6]!= null) && (naboer[6].erLevende())){
            antLevendeNaboer += 1;
        }        
        if(( naboer[7]!= null) && (naboer[7].erLevende())){
            antLevendeNaboer += 1;
        }        
    }
    // Metode oppdaterStatus uten retur
    public void oppdaterStatus(){
        if (levende){
            if ((antLevendeNaboer > 3)||(antLevendeNaboer<2)) {
                settDoed();    
            }
        }
        else {
            if (antLevendeNaboer == 3){
                settLevende();
            }
        }
    }
    // Oppdaterer Celles status fra levende til doed og omvendt
    public void oppdaterStatus2(){
        if(levende){
            settDoed();    
        }
        else{
            settLevende();
        }
    }        
    

}

    
    