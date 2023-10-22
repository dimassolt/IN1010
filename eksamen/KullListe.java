import java.util.Iterator;

public class KullListe extends Kull{
    // Deklarerer variabler
    Hund forste = null;

    // Konstruktor
    KullListe(Hund mor, Hund far) {
        super(mor, far);
    }
// Vi skal lage prioritetskoe dvs sortere fra ungsta til eldste
    @Override
    public void settInn (Hund h){
        if(forste == null){
            forste = h;
            return;
        }
        
        if(h.compareTo(forste) >0){
            h.neste = forste;
            forste = h; 
            return;
        }
        Hund p = forste;
        while(true){
            if (p.neste == null){
                // Inn sist
                p.neste = h;
                return;
            }
 
            if (h.compareTo(p.neste) > 0){
                // Inn mellom p og p.neste
                h.neste = p.neste;
                p.neste = h;
                return;
            }
            p = p.neste;
        }
    }
    
    
    @Override
    public Iterator<Hund> iterator(){
        return new HundeIterator();
    }
    class HundeIterator implements Iterator<Hund>{
        private Hund denne = forste;
        @Override
        public boolean hasNext(){
            return denne !=null;
        }
        @Override
        public Hund next(){
            Hund svar = denne;
            denne = denne.neste;
            return svar;
        }
    }
}
        
    
