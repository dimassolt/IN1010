class Tidspunkt implements Comparable<Tidspunkt>{
    // Deklarerer variabler
    int dato;
    int klokkeslett;
    int sek;
    // Konstruktor
    Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek){
       dato = aar*12*30 + mnd*30 + dag;
       klokkeslett = time*60*60 + min*60 + sek;
       this.sek = sek;
    }
    // Vi skal sammenligne dette tidspunktet med andre
    /* Hvis resultatet gir 1 da er dett 
        tidspunktet stoerre enn annet*/ 
    public int compareTo(Tidspunkt annet){
            if(dato > annet.dato){
                return 1;
            }
            else if(dato == annet.dato){
                if (klokkeslett > annet.klokkeslett){
                    return 1;
                }
                else if (klokkeslett == annet.klokkeslett){
                    return 0;
                }
                else{
                    return -1;
                } 
            }
            else{
                return -1;
            }
    }
    
}