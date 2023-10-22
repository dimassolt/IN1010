public abstract class Resept {
    // Setter variabler 
    public final int id;
    public static int idOk;
    public Legemiddel legemiddel;
    public Lege utskrevendeLege;
    public final int pasientid;
    public int reit;
    // Konstruktor med reit
    public Resept(Legemiddel legMid,Lege le, int pasId, int antIgjen){
        legemiddel = legMid;
        utskrevendeLege = le;
        pasientid = pasId;
        reit = antIgjen;
        id = idOk;
        idOk++;
    }
    // Konstruktor uten reit
    public Resept(Legemiddel legMid,Lege le, int pasId){
        legemiddel = legMid;
        utskrevendeLege = le;
        pasientid = pasId;
        id = idOk;
        idOk++;
    }
    // Henter resept id
    public int hentId(){
        return id;
    }
    // Henter legemiddel
    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }
    // Henter utskrevende lege
    public Lege hentLege(){
        return utskrevendeLege;
    }
    // Henter pasient id 
    public int hentPasientId(){
    return pasientid;
    }
    // Henter antall reit igjen
    public int hentReit(){
        return reit;
    }    
    // Bruker resept 
    public boolean bruk() {
        if (reit > 0){
            reit -= 1;
            return true;
        }
        else{
            return false;
        }
    }
    // Deklarerer farge og pris
    abstract public String farge();
    abstract public int prisAaBetale();
    // Deklarere eksempel for String metode 
    public String toString() {
        return "Legemiddel: "+ legemiddel +", lege: " + utskrevendeLege + "for pasient: " + pasientid + ", reit" + reit;
    }


}   

 class HvitResept extends Resept{
    // Konstruktor for Hvit Resept med reit for P-resept
    public HvitResept(Legemiddel legMid,Lege le, int pasId, int antIgjen){
        super(legMid, le, pasId, antIgjen);
    }
    // Konstruktor for Hvit Resept uten reit for MilResept
    public HvitResept(Legemiddel legMid,Lege le, int pasId){
        super(legMid, le, pasId);
    }

    public String toString(){
        return "Hvit resept" +" for legemiddel: "+ legemiddel +", lege: " + utskrevendeLege + " for pasient: " + pasientid + ", reit: " + reit;
    }
    // Henter info om hvilket farge legemiddel er
    @Override
    public String farge(){
        return "hvit";
    }
    // Henter pris for legemiddel
    @Override
    public int prisAaBetale(){
        return legemiddel.pris;
    }
   
}

class MilResept extends HvitResept{
    // Konstruktor for Militar Resept
    public MilResept(Legemiddel legMid,Lege le, int pasId){
        super(legMid, le, pasId);   
        reit = 3;
        legemiddel.settNyPris(0);
    }

}
class Presept extends HvitResept{
    // Setter variabel for rabatt
    private  int rabatt = 108; 
    // Konstruktor for P-resepter
    public Presept(Legemiddel legMid,Lege le, int pasId, int antIgjen){
        super(legMid, le, pasId, antIgjen);   

        if(legemiddel.pris - rabatt  < 0){       
           legemiddel.settNyPris(0);
        }   
        else;{
            legemiddel.settNyPris(legemiddel.pris-rabatt);
        }
    }
    

}
class BlaaResept extends Resept{
    // Konstruktor for BlaaResepept
    public BlaaResept(Legemiddel legMid,Lege le, int pasId, int antIgjen){
        super(legMid, le, pasId, antIgjen);
  
        legMid.pris = (int)Math.round(legMid.pris*0.25);
    }
    // Skriver ut all tilgjengelig info
    public String  toString(){
        return "Blaa resept" +" for legemiddel: "+ legemiddel +", lege: " + utskrevendeLege + " for pasient: " + pasientid + ", reit: " + reit;
    }
    // Henter farge for resepten   
    @Override
    public String farge(){
        return "blaa";
    }
    // Henter pris for legemiddel
    @Override
    public int prisAaBetale(){
        return legemiddel.pris;
    }  
}