public class Pasient {
    public String navn;
    public String fodselsnummer;
    public int indeks = 0;
    public final int id;
    public static int gyldigId = 0;
    // Her bruker vi Stabel fordi nyere resepter skal legges overst for pasient
    public Stabel<Resept> utskrevneResepter;

    public Pasient(String navn, String fodselsnummer) {
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        id = gyldigId;
        gyldigId++;
        utskrevneResepter = new Stabel<Resept>();
    }
    public int hentId(){
        return id;
    }
    public String hentNavn(){
        return navn;
    }

    public void leggTilResept(Resept resept){
        utskrevneResepter.leggTil(resept);
    }

    public Stabel<Resept> hentResepter(){
        return utskrevneResepter;
    }

    // public IndeksertListe<Resept> hentReseptPasientListe(){
    //     IndeksertListe<Resept>  resepter = new IndeksertListe<Resept>();
    //     for(Resept r:utskrevneResepter){
    //         resepter.leggTil(r);
    //     }
    //     return resepter;
    // }

    public String toString() {
        return "Navn: "+ navn + ", foedselsnummer: " + fodselsnummer ;
    }    
    public String brukString(){
        return navn + "(fnr " +fodselsnummer + ")";
    }
}
