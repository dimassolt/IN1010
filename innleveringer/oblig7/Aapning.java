public class Aapning extends HvitRute{
    // Konstruktor
    public Aapning(int rad, int kol, Rute[][] lab) {
        super(rad, kol, lab);
    }
    // Skriver ut fante aapninger
    @Override
    public void finn(Rute fra){
        System.out.println("Aapning: (" + antRader +", "+ antKolonner +")");
        sjekke = false;
    }
    
}
