public class Lege {
    // Setter variable
    public String  navn;
    // Konstruktor for Lege
    public Lege(String na){
        navn = na;
    }
    // Returnerer legenavn
    public String hentNavn(){
        return navn;
    }
    // Skriver ut navn
    public String toString(){
        return navn;
    }
}

class Spesialist extends Lege implements Godkjenningsfritak{
    // Setter variabel for Spesialist
    private String kontrollkode;
    // Konstruktor for Spesialist
    public Spesialist(String le, String kontrollkode){
        super(le);
        this.kontrollkode = kontrollkode;
    }
    // Returnerer kontrollkode for spesialisten
    public String hentKontrollkode(){
        return kontrollkode;
    }
    // Skriver ut all info i brukervennlig form
    @Override
    public String toString(){
        return navn + " kontrollkode: " + kontrollkode;
    }
}
        
    


