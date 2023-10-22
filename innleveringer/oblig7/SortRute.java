public class SortRute extends Rute{
    // Konstuktor
    public SortRute(int rad, int kol, Rute[][] lab) {
        super(rad, kol, lab);
    }

    // Metode skal vaere tom for sort rute
    @Override
    void finn(Rute fra){
        
    }
    @Override
    public String toString(){
        return "#";
    }
    
}
