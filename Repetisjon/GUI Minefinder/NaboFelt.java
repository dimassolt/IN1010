
public class NaboFelt extends Felt{
    public NaboFelt(Modell m, Koordinat k){
        super(m, k);
    }
    public void finn(Felt forrige){
        if (erKlikket) return;
        else erKlikket = true;

        int antallMiner = 0;
        for (Felt nabo : naboer){
                if (nabo.erMine()) antallMiner++;
        }
        Tilstand tilstand =
            Tilstand.antallTilTilstand(antallMiner);
        modell.skalOppdateres(
                this.koordinat,
                tilstand);
    }
}
