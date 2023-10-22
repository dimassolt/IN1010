class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{
    
    // Vi skal legge foerstee elementer i listen med hensyn paa dens prioritet
    @Override
    public void leggTil(E x){
        Node foerste = new Node(x);
        //Sjekker hvis listen er tom 
        if(start == null){
            // Vi maa sette foerste element
            super.leggTil(x);
            return;
        }
        // Sjekker hvis elementet skal settes foerst i listen
        if(foerste.element.compareTo(start.element) < 0){
            foerste.neste = start;
            start = foerste;
            return;
        }
        // Hvis ikke da trenger vi aa lage en ekstra variabel som skal oekes til aa gi riktig posisjon for hvert element 
        Node forrige = start;
        while(forrige.neste != null && forrige.neste.element.compareTo(x) < 0){
            // Vi gaar gjennom listen til vi finner riktig posisjon
            forrige = forrige.neste;
        }
        // Setter riktig posisjon
        foerste.neste = forrige.neste;
        forrige.neste = foerste;
    }
}
