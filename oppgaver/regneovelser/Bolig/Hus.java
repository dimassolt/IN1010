package Bolig;

public abstract class Hus extends Bolig{
    protected int antEtasjer;
    public Hus(int arr, String adr, int antEt){
        super(arr, adr);
        antEtasjer = antEt;

    }
}
