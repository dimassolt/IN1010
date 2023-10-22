package Bolig;

import java.util.ArrayList;

public class Kjokken extends RomMedVann {
    private boolean harOppvaskMaskin;

    public Kjokken(int areal, boolean varmt, boolean oppvask) {
        super(areal, varmt);
        harOppvaskMaskin = oppvask;
    }

    @Override
    public ArrayList<String> hentEgenskaper() {
        ArrayList<String> egenskaper = super.hentEgenskaper();

        if (harOppvaskMaskin) {
            egenskaper.add("Har oppvaskmaskin");
        }

        return egenskaper;
    }

    @Override
    public String typeRom() {
        return "Kjokken";
    }
}

