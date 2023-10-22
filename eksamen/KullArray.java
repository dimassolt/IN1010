import java.util.Iterator;

public class KullArray  extends Kull{
    // Variabler
    Hund[] hundene = new Hund[60];
    // Konstruktor
    KullArray(Hund mor, Hund far){
        super(mor,far);
    }
    void settInn (Hund h){
        int sek = h.minFodselstid.sek;
        h.neste = hundene[sek];
        hundene[sek] = h;
    }
    public Iterator<Hund> iterator(){
        return new HundeIterator();
    }
    public class HundeIterator implements Iterator<Hund>{
        int pos;
        Hund denne;

        HundeIterator(){
            pos = 0;  denne.hundene[0];
            finnNesteHund();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        void finnNesteHund(){
            while(denne == null){
                ++pos;
                if(pos >= 60) return;
                denne = hundene[pos];
            }
        }

        @Override
        public Hund next(){
            Hund svar = denne;
            denne = denne.neste; finnNesteHund();
            return svar;
        }

    }
}
