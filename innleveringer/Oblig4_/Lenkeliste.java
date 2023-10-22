import java.util.Iterator;
abstract class Lenkeliste <E> implements Liste<E> {
// Oppretter class Node som skal representere nye elementer i lister
    public class Node{
        public E element;
        public Node neste;
        public Node(E element){
            this.element = element;
        }
    }
    public class LenkelisteIterator implements Iterator<E>{
        public Node denne = start;
        @Override
        public boolean hasNext(){
            return denne != null;
        }
        @Override
        public E next(){
            E element = denne.element;
            denne = denne.neste;
            return element;
        }
    }
    public Iterator<E> iterator(){
        return new LenkelisteIterator();
    }
    // Oppreter instansvariabler for start og slutt av listen
    public Node start = null;
    public Node slutt = null;
    
    // Henter listen lengde
    @Override
        public int stoerrelse() {
            int teller = 0;
            Node peker = start;
    
            while (peker != null) {
                teller ++;
                peker = peker.neste;
            }
            return teller;
        }
    // Legger til en ny element i listen
    @Override
    public void leggTil(E x) {
        Node ny = new Node(x);
        // int pos =
        if (start != null && slutt != null){
            start.neste = ny;
            slutt.neste = ny;
        }
        else{
            start = ny;
            slutt = ny;
        }
    }
    // Henter (returnerer) element fra listen
    @Override
    public E hent(){
        return start.element;
    }
    // Sletter element fra listen
    @Override
    public E fjern() throws UgyldigListeindeks{
        if(start == null){
          throw new UgyldigListeindeks(0);
        }
        E fjernetElement = start.element;
        start = start.neste;
        return fjernetElement;
    }
    // Skal returenere String versjon av listen, funker ikke  
    public String toString(){
        String line = "";
        Node celle = start;
        if(celle == null){
            return "Tom liste.";
        }
        while(celle.neste !=null){
            line += (celle.element+",");
            celle = celle.neste;
        }
        if(celle.neste == null){
            line += celle.element;
        }
        return line;
}
}