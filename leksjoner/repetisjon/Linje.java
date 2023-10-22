import java.util.Iterator;
public class Linje implements Iterable<Linje.Stopp>{
    private Stopp start;
    public Linje(String navn){
        start = new Stopp(navn);
    }
    public void leggTilStopp(String navn){
        Stopp sisteStopp = start;
        while(sisteStopp.nestestopp != null){
            sisteStopp = sisteStopp.nestestopp;
        }
        sisteStopp.nestestopp = new Stopp(navn);
    }

    class Stopp{
        private String navn;
        private Stopp nestestopp = null;
        // private int teller;
        public Stopp(String navn){
            this.navn = navn;
        }
    }
    public Iterator<Linje.Stopp> iterator(){
        return new Linjeiterator();
    }
    class Linjeiterator implements Iterator<Stopp>{
        
        private Stopp peker = start;

        public boolean hasNext(){
            return peker != null;
        }
        public Stopp next(){
            Stopp midlertidig = peker;
            peker = peker.nestestopp;
            return midlertidig;
        }

    }
    public static void main(String[] args) {
        Linje linje1 = new Linje("Frornerseteren");
        String[] stoppnavn = {
            "Voksenkollen",
            "Lillevann",
            "Skogen",
            "Voksenlia",
            "Holmenkollen"
        };
        for(String navn : stoppnavn){
            linje1.leggTilStopp(navn);
        }
        for (Stopp stopp : linje1){
            System.out.println(stopp);
        }
    }
}