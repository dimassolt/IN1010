import java.util.Iterator;

class Hund implements Comparable<Hund> {
    String navn;
    Kull mittKull;
    Tidspunkt minFodselstid;
    Hund neste = null;

    Hund (Kull k, String n, Tidspunkt fodt) {
        navn = n;  mittKull = k;  minFodselstid = fodt;
    }
    public Hund mor(){
        // if(mittKull.mor != null){
            return mittKull.mor;
        // }
        // else{
        //     return null;
        // }
    }
    
    public Hund far(){
        // if(mittKull.far != null){
            return mittKull.far;
        // }
        // else{
        //     return null;
        // }    
    }
    
    // public Hund mor(){
    //     if(navn != null){
    //         return this;
    //     }
    //     else{
    //         return null;
    //     }
    // }
    
    // public Hund far(){
    //     if(navn != null){
    //         return this;
    //     }
    //     else{
    //         return null;
    //     }    
    // }
    
    @Override
    public int compareTo (Hund h) {
        return this.minFodselstid.compareTo(h.minFodselstid);
    }
    public boolean erHelsosken (Hund h) {
    
        if(this.mittKull.mor == h.mittKull.mor && this.mittKull.far == h.mittKull.far){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean erHalvsosken (Hund h) {
        boolean morlik = (this.mor() == h.mor()) && mor()!=null;    
        boolean farlik = (this.far() == h.far()) && far()!=null;    
        return morlik ^ farlik;
        // if(this.mittKull.mor != h.mittKull.mor && this.mittKull.far == h.mittKull.far ){
        //     return true;
        // }
        // else if(this.mittKull.mor == h.mittKull.mor && this.mittKull.far != h.mittKull.far ){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        
    }
    
    public Hund finnEldsteKjenteOpphav() {
        // basistilfellet:
        if(mor() == null && far() == null){
            return this;
        }
        Hund mor = mor();
        Hund far = far();
        if(far == null){
            return mor.finnEldsteKjenteOpphav();
        }
        else if (mor == null){
            return far.finnEldsteKjenteOpphav();
        }
        Hund eldsteFarSide = far.finnEldsteKjenteOpphav();
        Hund eldsteMorSide = mor.finnEldsteKjenteOpphav();

        if (eldsteFarSide.compareTo(eldsteMorSide) < 0){
            return eldsteFarSide;
        }
        else {
            return eldsteMorSide;
        }
    //     if(this.mor() != null){ 
    //         return this.mor().finnEldsteKjenteOpphav();
    //     }
    //     else if (this.far() != null){
    //         return this.far().finnEldsteKjenteOpphav();
    //     }
    //     else{
            // return this;
        // }
    }

}
abstract class Kull implements Iterable<Hund> {
    Hund mor, far;
    Kull (Hund mor, Hund far) {
        this.mor = mor;  this.far = far;
    }
    public void skrivUtAlle () {
        for (Hund h: this)System.out.println("  " + h);
    }
    public abstract void settInn (Hund h);
    public abstract Iterator<Hund> iterator ();
}
