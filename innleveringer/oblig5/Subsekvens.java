class Subsekvens{
    // Deklarerer variabler
    public final String subsekvens;
    private int antall;
    
    // Konstruktor
    public Subsekvens(String subsekvens, int antall){
        this.subsekvens = subsekvens;
        this.antall = antall;
    }
    // Henter relevante data
    public String hentSubsekvens(){
        return subsekvens;
    }

    // Henter antall forekomster
    public int hentAntallForekomster(){
        return antall;
    }

    // Setter ny verdi for antall 
    public void endreAntallForekomster(int antall){
        this.antall = antall;
    }

    // Setter ny antall forekomster
    public int leggTilAntallForekomser(){
        return antall ++;
    }

    // Henter String representasjon
    public String toString(){
        return "(" + subsekvens +", " + antall + ")";
    } 

}