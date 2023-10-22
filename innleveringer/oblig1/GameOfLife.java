public class GameOfLife {
// Jeg skal leke med den selv litt senere, men naa er det funkende variasjon 
    public static void main(String args[]){
        Verden verden = new Verden(8,12);
        verden.tegn();
        for(int oppdat = 0; oppdat < 3; oppdat +=1){
        verden.oppdatering();
        verden.tegn();

        }
        
    }
}


