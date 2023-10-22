public class MineFelt extends Felt{
    public MineFelt(Modell m, Koordinat k){
        super(m, k);
    }
    public void finn(Felt forrige){
        if (erKlikket) return;
        else erKlikket = true;

        modell.skalOppdateres(
                this.koordinat,
                Tilstand.MINE);
    }
    @Override
    public boolean erMine(){
        return true;
    }
}
