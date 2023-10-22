import java.util.Iterator;

class Skinnegoende{
    final String id;
    final int sporvidde;
    
    Skinnegoende neste, forrige;
    
    Skinnegoende(String i, int bredde){
        id = i;
        sporvidde = bredde;
    }
    
    String hentId(){
        return id;
    }
    
    int hentSporvidde(){
        return sporvidde;
    }
    
}

interface Motordrevet {
    boolean fossilt = false;
    int trekkraft = 0;
    
}
class Lokomotiv extends Skinnegoende{
    final boolean fossilt;
    final int trekkraft;
    Lokomotiv(String i, int bredde, boolean stoff, int kraft){
        super(i,bredde);
        fossilt = stoff;
        trekkraft = kraft;
    }
    boolean erFossilt(){
        return fossilt;
    }
    
    boolean erElektrisk(){
        if(trekkraft>0) {
			return true;
		}
		else{
			return false;
		}
    }
}

abstract class Vogn extends Skinnegoende{
    final int lengde;
    Vogn(String i, int bredde, int l){
        super(i,bredde);
        lengde = l;
    }
}

class Godsvogn extends Vogn{
    final double lastevekt;
    Godsvogn(String i, int bredde, int l, double vekt){
        super(i,bredde,l);
        lastevekt = vekt;
    }
}

class Passasjervogn extends Vogn{
    final int maksAntallPassasjerer;
    Passasjervogn(String i, int bredde, int l, int maksAnt){
        super(i,bredde,l);
        maksAntallPassasjerer = maksAnt;
    }
}

//Oppgave 3

class Tog implements Iterable<Skinnegoende>{
    int antallVogner;
    Skinnegoende[] tog;
    Skinnegoende forste, siste;
    //3g
    Passasjervogn[] pasVogner;
    int antPasVogner;
    //3a
    Tog(int ant){
        antallVogner = ant;
        tog = new Skinnegoende[ant];
        forste=siste=null;
        
    }
    //3b
    void leggTil(Skinnegoende goende){
        if(forste == null){
            forste = goende;
            siste = forste;
        }
        else{
            siste.neste = goende;
            goende.forrige = siste;
            siste = goende;
        }
    }
    //4c
    void leggTilSikker(Skinnegoende goende) throws FeilSporvidde{
        if(forste == null){
            forste = goende;
            siste = forste;
        }
        else if (forste.sporvidde!=goende.sporvidde){
            throw new FeilSporvidde();
        }
        else{
            siste.neste = goende;
            goende.forrige = siste;
            siste = goende;
        }
    }
    
    //3c
    Skinnegoende taUt(Skinnegoende ut){
        if(ut == forste && forste == siste){
            forste = siste = null;
        }
        else if(ut == forste){
            forste = forste.neste;
            forste.forrige = null;
        }
        else if(ut == siste){
            siste = siste.forrige;
            siste.neste = null;
        }
        else{
            ut.forrige.neste = ut.neste;
            ut.neste.forrige = ut.forrige;
            ut.forrige = ut.neste = null;
        }
        return ut;
    }
    //3d
    Skinnegoende finnOgTaUt(String iden){
        Skinnegoende ut = forste;
        while(ut != null){
            if(ut.id.equals(iden)){
                this.taUt(ut);
                return ut;
            }
            ut = ut.neste;
        }
        return ut;
    }
    //4b 
    void sjekkSporvidde() throws FeilSporvidde{
        Skinnegoende sjekke = forste;
        while(sjekke != null){
            if(sjekke.sporvidde == forste.sporvidde){
                throw new FeilSporvidde();
            }
            sjekke = sjekke.neste;
        }
    }
    //4d
    void sjekkSporviddeRekursivt(){
        forste.sjekkRekursivt(forste);
    }
    Sporgoende sjekkRekursivt(Sporvidde sjekke){
        // Sporvidde goende = sjekke;
        if(sjekke == siste){
            return sjekke;
        }
        else if(sjekke.sporvidde != forste.sporvidde){
                throw new FeilSporvidde();
            }
        else{
            sjekke = sjekke.neste;
            sjekkRekursivt(sjekke);
            
            }
        return sjekke;
    }
    //3e
    void leggTilForan(Skinnegoende en, Skinnegoende to){
        if(en == forste && forste == siste){
            forste.neste = en;
            siste = en;
            forste = to;
        }
        else if(en == forste){
            forste.forrige = to;
            forste.neste = en;
            
        }
        else if(en == siste){
            siste.neste = en;
            siste = to;
            
        }
        else{
            en.forrige.neste = en.neste;
            en.neste.forrige = en.forrige;
            en.forrige = en.neste = to;
            to.neste = en;
        }
    }
    //3f
    public Iterator<Skinnegoend> iterator(){
        return new SkinnegoendeIterator();
    }
    //Class for iterator
    class SkinnegoendeIterator implements Iterator<Skinnegoend>{
        Skinnegoende f = forste;
        
        @Override
        public boolean hasNext(){
            return f!= null;
        }
        @Override
        public Skinnegoend next(){
            Skinnegoende goende = f;
            f = f.neste;
            return goende; 
        }
    }
    //3g
        void tellPasVogner(){
        Skinnegoende pasVogn = forste;
        while(pasVogn != null){
            if(pasVogn instanceof Passasjervogn){
                antPasVogner++;
            }
            ut = ut.neste;
        }
    }
    
    Passasjervogn[] hentPassasjervogner(){
        pasVogner = new Passasjervogn[antPasVogner];
        
        Skinnegoende pasVogn = forste;
        int indeks = 0;
        while(pasVogn != null){
            if(pasVogn instanceof Passasjervogn){
                pasVogner[indeks] = pasVogn;
                indeks++;
            }
            ut = ut.neste;
        }
        return pasVogner;
    }
}

//Oppgave 4

//4a

class FeilSporvidde extends Exception{
    FeilSporvidde(){
        super("Kan ikke brukes sammen pga forskjellig sporvidden!");
    }
}
//5a
class Leter implements Runnable{
    Tog tog;
    Monitor mon;
    String idDel;
    
    Leter(Tog t, Monitor m, String s){
        tog = t;
        mon = m;
        idDel = s;
    }
    @Override
	public
    void run(){
        Skinnegoende goende = t.forste;
        while(t.goende.id.startWith(idDel)){
                mon.leggTil(goende);
                if(goende == t.siste){
                    mon.ferdigLeting();
                }
                else{
                    goende = goende.neste;
                }
        }
    }
}
//5b
class Resultat implements Runnable{
    Monitor mon;
    Resultat(Monitor m){
        mon = m;
    }
    void hentNeste(){
        Skinnegoende neste = mon.hentNeste();
        System.out.println("Skinnegoendes id: " + neste.id);
    } 
}
//5c
class Monitor{
    Lock laas = new ReentrantLock();
    int antLete;
    Monitor(int ant){
        antLete = ant;
    }
    void leggTil(){
        
    }
    void hentNeste(){
    }
    
    void ferdigLeting(){
		
	}
    
}





