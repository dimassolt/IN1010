
import java.util.Iterator;
class Lenkeliste implements Iterable<Integer>{
    class Node {
        int element;
        Node neste;
        Node forrige;

        public Node(int e){
            element = e;
        }
    }
    Node forste;
    Node siste;

    public void settInn(int e){
        if (forste == null){
            forste = new Node(e);
            siste = forste;
        }
        else{
            Node nyNode = new Node(e);
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode;
        }
    }

    @Override
    public LenkelisteIterator iterator() {
        return new LenkelisteIterator();
    }
    class LenkelisteIterator implements Iterator<Integer>{
        Node neste;
        public LenkelisteIterator(){
            neste = forste;
        }
        public boolean hasNext(){

        }

        public Integer next(){
            if (neste == null){
            return null;
            }


        }


    }
}
