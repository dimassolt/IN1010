public class TomtFelt extends Felt{
    public TomtFelt(Modell m, Koordinat k){
        super(m, k);
    }
    public void finn(Felt forrige){
        if (erKlikket) return;
        else erKlikket = true;

        modell.skalOppdateres(
                this.koordinat,
                Tilstand.TOMT);

        for (Felt nabo : naboer){
            nabo.finn(this);
        }
    }
}
