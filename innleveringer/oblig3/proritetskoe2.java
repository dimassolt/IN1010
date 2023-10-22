class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{
    
    // Vi skal legge foerstee elementer i listen med hensyn paa dens prioritet
    @Override
    public void leggTil(E x){
        Node foerste = new Node(x);
        if(start == null){
            // Listen er tom, saa vi maa sette foerste element
            super.leggTil(x);
            return;
        }
        if(foerste.element.compareTo(start.element) < 0){
            // Elementet skal settes foerst i listen
            foerste.neste = start;
            start = foerste;
            return;
        }
        Node forrige = start;
        while(forrige.neste != null && forrige.neste.element.compareTo(x) < 0){
            // Vi gaar gjennom listen til vi finner riktig posisjon
            forrige = forrige.neste;
        }
        // Setter inn elementet paa riktig posisjon
        foerste.neste = forrige.neste;
        forrige.neste = foerste;
    }
}
