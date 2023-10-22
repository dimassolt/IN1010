import java.util.HashMap;
import java.util.ArrayList;
abstract class Rom {

    final int nr;
    final int kvm;
    final int senger;
    final int etasje;

    boolean ledig = true;
    Rom neste;

    Rom(int n, int k, int s, int e){
        nr = n;
        kvm = k;
        senger = s;
        etasje = e;
    }
    @Override
    public String toString(){
        return nr + " "+ kvm +" "+  senger+  " "+  etasje+" "+ " " + ledig;
    }
}

class EnkelRom extends Rom{
    EnkelRom(int n, int k, int s, int e){
        super(n,k,s,e);
    }

    @Override 
    public String toString(){
        return "EnkelRom: " + super.toString();
    }
}

class VanligRom extends Rom{
    VanligRom(int n, int k, int s, int e){
        super(n,k,s,e);
    }

    @Override 
    public String toString(){
        return "VanligRom: " + super.toString();
    }
}

class Suite extends Rom{
    Suite(int n, int k, int s, int e){
        super(n,k,s,e);
    }

    @Override 
    public String toString(){
        return "Suite: " + super.toString();
    }
}

interface Kjokken{
    int kjokenAreal();
}

class VanligRomKjoken extends VanligRom implements Kjokken{
    final int kjokenAreal;

    VanligRomKjoken(int n, int k, int s, int e, int kjok){
        super(n,k,s,e);
        kjokenAreal = kjok;
    }
    @Override
    public int kjokenAreal(){
        return kjokenAreal;
    }
    @Override
    public  String toString(){
        return "VanligRom med kjokken: " + super.toString();
    }
}

class SuiteKjoken extends Suite implements Kjokken{
    final int kjokenAreal;

    SuiteKjoken(int n, int k, int s, int e, int kjok){
        super(n,k,s,e);
        kjokenAreal = kjok;
    }
    @Override
    public int kjokenAreal(){
        return kjokenAreal;
    }
    @Override
    public  String toString(){
        return "Suite med kjokken: " + super.toString() + kjokenAreal +"arealet til kjokkenet";
    }
}

class Hotel {
    final int maksAntSeng = 8;
    final int etasje;
    Rom foerste = null;
    Rom[] forsterometasje;
    Reservasjon forsteR,sisteR;

    Hotel(int e){
        etasje = e;
        forsterometasje = new Rom[etasje+1];
    }   
    // Придется писать вспомогательные методы чтобы заствить работтать это говно 
    Reservasjon finlegigReservasjon(String navn){
        Reservasjon p = forsteR;
        while(p!= null){

        }
        Gjest gjesten = new Gjest();
        gjesten.gjest = navn;
        denRes.gjest = gjesten;
        return denRes;
    }
    void tildelRom(String navn){
        Gjest gjest = new Gjest();
        gjest.gjest = navn;
        if(navn){

        }
        else{
            new IngenReservasjon(navn);
        }
    }
}

class Gjest{
    String gjest;
    Rom detteRomet = null;
}

class Reservasjon{
    Gjest gjest;
    int antalSengePlasser;
    boolean kjoken;
    Reservasjon forrigeR, nesteR;
}
class IngenReservasjon extends RuntimeException{
    IngenReservasjon(String navn){
        super("ingen reservasjon til: " + navn);
    }
}



