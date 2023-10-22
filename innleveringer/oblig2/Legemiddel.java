public abstract class Legemiddel{
    // Setter variabler
    public final String navn;
    public int pris;
    public final double virkestoff;
    public final int id;
    public static int idOk = 0; 
    // Konstrukot for legemiddel
    public Legemiddel(String navn,int pris, double virkestoff){
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    id = idOk;
    idOk++;     
    }
    // Konstruktor for legemiddel med styrke som parameter
    public int styrke;
    public Legemiddel(String navn,int pris, double virkestoff,int styrke){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.styrke = styrke;
        id = idOk;
        idOk++;
        }
    // Returenerer pris
    public int hentPris(){
        return pris;
    }
    // Setter ny pris
    public void settNyPris(int pris){
        this.pris = pris;
    }
    // Returnerer klassinfo i enkel form   
    public String toString(){           
        return navn + " " + pris + " " + virkestoff + " " + id;
    }

}

class Narkotisk extends Legemiddel{
    // KOnstrukor for narkotisk legemiddel
    Narkotisk (String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff,styrke);
    }
    // Returnerer klassinfo i enkel form
    public String toString(){        
        return "Nasrkotisk legemiddel: " + navn +" med pris: " + pris + "kr, med virkestoff: " + virkestoff + "mg, id: " + id + " som har styrke: " + styrke;
    }    
}

class Vanedannende extends Legemiddel{
    // Konstruktor for vannedanende legemiddel
    Vanedannende (String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff, styrke);
    }
    // Returnerer klassinfo i enkel form
    public String toString(){            
        return "Vanedannende legemiddel: " + navn +" med pris: " + pris + "kr, med virkestoff: " + virkestoff + "mg, id: " + id + " som har styrke: " + styrke;
    }
}
 
class Vanlig extends Legemiddel{
    // Konstruktor for vanlig legemiddel
    Vanlig (String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
    }   
    // Returnerer klassinfo i enkel form
    public String toString(){           
        return "Vanlig legemiddel: " + navn +" med pris: " + pris + "kr, med virkestoff: " + virkestoff + "mg, id: " + id;
    }
}