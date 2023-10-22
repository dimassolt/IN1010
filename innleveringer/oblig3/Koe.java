public class Koe<E> extends Lenkeliste<E> {
    // Foerst inn skal foerst ut FIFO
    @Override
    public void leggTil(E x){
        Node ny = new Node(x);        
        if(stoerrelse()!= 0){
            slutt.neste = ny;
            slutt = ny;
        }
        else{
            start = ny;
            slutt = ny;
        }
    }
}
