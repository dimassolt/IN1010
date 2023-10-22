package Bolig;

public class Leilighet extends Bolig implements HarNaboer{
    
    protected int etasje, leilighetsNr;
    public int naboer = 0;
    public Leilighet(int adr, String adres, int etasj, int nr){
        super(int aar,String adr)
        etasje = etasj;
        leilighetsNr = nr;
    }
    @Override
    public int hentAntallNaboer(){
        return naboer;
    }
    @Override
    public void registrerNabo(String hvor){
        if(hvor.equals("hoyrere") || hvor.equals("venstre")){

        }
    }

}
