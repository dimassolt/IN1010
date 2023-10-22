/**
 * Avgjør hvordan en rute skal se ut.
 * brukes til å kommunisere mellom fra gui til modell gjennom Kontroll
 * vi gjør dette i stedet for å sende med informasjon om hva slags rute det er
 * og antallet. hvorfor? vi trodde det var lurt i starten er det? Kanskje!
 */
public enum Tilstand{
    TOMT,
    EN,
    TO,
    TRE,
    FIRE,
    FEM,
    SEKS,
    SYV,
    ATTE,
    NI,
    // MINE,
    // SKJULT;
    
    MINE;
    /**
     * tar antallet naboer, og konverterer det til riktig nabo
     * @param antall antall naboer som er miner til et nabofelt
     * @return tilstanden som antallet
     */
    static public Tilstand  antallTilTilstand(int antall){
        if (antall <= 0) return TOMT; // Dette skal ikke skje.
                                      // Burde kaste et unntak
        switch(antall){
            case 1:
                return EN;
            case 2:
                return TO;
            case 3:
                return TRE;
            case 4:
                return FIRE;
            case 5:
                return FEM;
            case 6:
                return SEKS;
            case 7:
                return SYV;
            case 8:
                return ATTE;
            default:
                return MINE; // Strengt tatt feil, men vi
                             // dropper exceptions i dette
                             // eksempelet :-)
        }
    }
}
