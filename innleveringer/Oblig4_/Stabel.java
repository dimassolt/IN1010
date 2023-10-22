public class Stabel<E> extends Lenkeliste <E>{
    // Ny element av listen skal legges paa toppen 
    @Override
        public void leggTil(E x){
            Node ny = new Node(x);
            ny.neste = start;
            start = ny;
        }
    
    
}

    