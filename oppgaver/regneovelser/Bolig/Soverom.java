package Bolig;
import java.util.ArrayList;

public class Soverom extends Rom {
    private boolean harInnebygdSkap;
    private Stue egenStue = null;

    public Soverom(int areal, boolean skap) {
        super(areal);
        harInnebygdSkap = skap;
    }

    public Soverom(int areal, boolean skap, Stue stue) {
        super(areal);
        harInnebygdSkap = skap;
        egenStue = stue;
    }

    @Override
    public String typeRom(){
        return "Soverom";
    }

    @Override
    public ArrayList<String> hentEgenskaper() {
        ArrayList<String> egenskaper = new ArrayList<>();
        
        if (harInnebygdSkap) {
            egenskaper.add("Har skap");
        }

        if (egenStue != null) {
            egenskaper.add("Har stue");
        }

        return egenskaper;

    }
}
