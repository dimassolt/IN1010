package Bolig;
import java.util.ArrayList;

public class Stue extends Rom {
    private boolean harPeis;

    public Stue(int areal, boolean harPeis) {
        super(areal);
        this.harPeis = harPeis;
    }

    @Override
    public String typeRom(){
        return "Stue";
    }

    @Override
    public ArrayList<String> hentEgenskaper(){
        ArrayList<String> egenskaper = new ArrayList<>();
        egenskaper.add("Areal: "+areal);
        
        if (harPeis) {
            egenskaper.add("Har peis");
        }

        return egenskaper;
    }


}
