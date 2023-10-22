class IndeksertListe <E> extends Lenkeliste<E>{
    // Skal legge en element til listen med den gitte posisjonen
    public void leggTil (int pos, E x){
        
        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }                

        Node ny = new Node(x);
        Node forste = start;
    // Klarte ikke aa legge til ny element som ikke har posisjon i listen  
        if(start != null && slutt != null){
            if(pos == stoerrelse()){
                // super.leggTil(x);
                slutt.neste = ny;
                slutt = slutt.neste;
            }
            else if(pos == 0){
            //    super.leggTil(x);
                ny.neste = start;
                start = ny;
            }
            
            else{
                for(int i = 0; i < pos -1;i++){
                    forste = forste.neste;
                }
            ny.neste = forste.neste;
            forste.neste = ny;
        }   
        }
        else{
            start = ny;
            slutt = ny;
        }
        // System.out.println(pos);
    }
    // Setter element i listen med den gitte posisjonen
    public void sett (int pos, E x){
        if(pos < 0 || pos >=stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }
        Node forste = start;
        for(int i = 0; i < pos; i++){
            forste = forste.neste;
        }
        forste.element = x; 
    }

    // Henter element vha posisjon
    public E hent (int pos) throws UgyldigListeindeks{ 
        if(pos <0 || pos >=stoerrelse() || start == null){
            throw new UgyldigListeindeks(pos);
        }
        Node peker = start;
        for(int i=0;i<pos;i++){
            peker = peker.neste;
        }
            return peker.element;
}

    public E fjern (int pos) throws UgyldigListeindeks{
        if(pos < 0 || pos >= stoerrelse() || start == null){
            throw new UgyldigListeindeks(pos);
        }
        Node peker = start;
        for(int i = 0; i<pos-1;i++){
            peker = peker.neste;
        }
        E result = peker.neste.element;
        peker.neste = peker.neste.neste;
        return result;
    }
}