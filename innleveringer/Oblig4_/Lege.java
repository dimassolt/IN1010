public class Lege implements Comparable <Lege>{
    // Deklarere variabler
    public String navn;
    public IndeksertListe<Resept> utskrevneResepter;
    // Konstrukor
    public Lege(String navn) {
        this.navn = navn;
        utskrevneResepter = new IndeksertListe<Resept>();
    }
    // Henter leges navn
    public String hentNavn() {
        return navn;
    }
    // Metode compareTo skal sammenligne to forskjellige legenavner
    @Override
    public int compareTo (Lege annen) {
        return navn.compareTo(annen.navn);
        
    }
    // Henter listen av resepter vha Indeksertliste
    public IndeksertListe<Resept> hentIndeksertListe(){
        return utskrevneResepter;
    }

    HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this,legemiddel);
        }
        HvitResept hvit = new HvitResept(legemiddel,this,pasient,reit);
        utskrevneResepter.leggTil(hvit);
        pasient.leggTilResept(hvit);
        return hvit;
    }
    Militaerresept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this,legemiddel);
        }
        Militaerresept mil = new Militaerresept(legemiddel,this,pasient);
        utskrevneResepter.leggTil(mil);
        pasient.leggTilResept(mil);
        return mil;
    }
    
    Presept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this,legemiddel);
        }
        Presept pres = new Presept(legemiddel,this,pasient,reit);
        utskrevneResepter.leggTil(pres);
        pasient.leggTilResept(pres);
        return pres;
    }
    BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if(!(this instanceof Spesialist)){
            throw new UlovligUtskrift(this,legemiddel);
        }
        BlaaResept blaa = new BlaaResept(legemiddel,this,pasient,reit);
        utskrevneResepter.leggTil(blaa);
        pasient.leggTilResept(blaa);
        return blaa;
    }


    // Returnerer alldata i String form
    public String toString() {
        return "Navn: " + navn;
    }
}
