package Bolig;

public class TestBolig {
public static void main(String[] args){
    Leilighet lei = new Leilighet(2021,"Rolf 17",2,22); 
    System.out.println("Naboer"+ lei.hentAntallNaboer());
    lei.registrerNabo("hoyere");
    lei.registrerNabo("venstre");
    lei.registrerNabo("fefef");
    System.out.println("Naboer"+ lei.hentAntallNaboer());
    
    Enebolig enebolig = new Enebolig(1962, "Borhen", 3);
    
}
}
