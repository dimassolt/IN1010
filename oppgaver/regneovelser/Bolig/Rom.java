package Bolig;
import java.util.ArrayList;

public abstract class Rom {
    protected int areal;

    public Rom(int areal) {
        this.areal = areal;
    }

    public abstract String typeRom();
    
    public abstract ArrayList<String> hentEgenskaper();
    
    public int hentAreal() {
        return areal;
    }

    @Override
    public String toString() {
        String utskrift = "Romtype: " + typeRom();
        utskrift += "\nareal: " + areal;

        ArrayList<String> egenskaper = hentEgenskaper();
        
        for (String egenskap : egenskaper){
            utskrift += "\n" + egenskap;
        }
        
        return utskrift;

    }


}