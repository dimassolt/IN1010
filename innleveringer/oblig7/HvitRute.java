public class HvitRute extends Rute {
    // Konstruktor
    public HvitRute(int rad, int kol, Rute[][] lab) {
        super(rad, kol, lab);
    }

    // Finner veien ut vha naboer
    @Override
    public void finn(Rute fra){
        sjekke = true;      
        for(int i = 0; i < naboer.length; i++){       
            Rute denne = naboer[i];
            if(denne!= null && denne.sjekke != true){
                denne.finn(this);
            }
        }
    }
    
    @Override
    public String toString() {
        return ".";
    }

}
