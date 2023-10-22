public abstract class Legemiddel{  //Abstract class: is a restricted class that cannot be used to create objects 
    //Deklarerer variabler 
    public int pris;
    public final String navn;
    public final double virkestoff;
    public static int gyldigId = 0; //The static keyword in Java is used for memory management mainly.
    public static String legemiddelType;
    public final int id;

    //Konstuktoer
    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = gyldigId;
        gyldigId++;
    }
    //henter pris
    public int hentPris(){
        return pris;
    }
    public int hentId(){
        return id;
    }

    // Henter navn 
    public String hentNavn(){
        return navn;
    }
    //setter ny pris
    public void settNyPris(int ny_pris){
        pris = ny_pris;
    }
    //Skriver ut 
    public String toString() {
        return "Navn: " + navn + " Pris: " + pris + " Virkestoff: " + virkestoff;
        }
}



