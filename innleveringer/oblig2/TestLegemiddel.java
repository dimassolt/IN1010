public class TestLegemiddel {

    public static void main(String[] args) {
        // Oppretter noen legemidler
        Vanlig vanlig = new Vanlig("paraset", 250, 0.25);
        Vanlig vanlig2 = new Vanlig("parazzzet", 25000, 0.25332);
        Narkotisk narkotisk = new Narkotisk("narkotika",1000,0.232,10000);       
        Vanedannende vanedannende = new Vanedannende("nesePustTurbo",500, 0.5, 10);
        
        // Tester konstruktor for Vanlig legemiddel
        System.out.println("Tester konstruktor for Vanlig legemiddel:");

        if(vanlig.navn == "paraset" && vanlig.pris == 250 && vanlig.virkestoff == 0.25 && vanlig.id == 0) {
            System.out.print(" Alt riktig!");
            
        }
        else{
        System.out.print(" feil!!!");

        }
        // Tester konstruktor for Vanedannende legemiddel
        System.out.println("\n ");
        System.out.println("Tester konstruktor for Vanedannende legemiddel:");

        if(vanedannende.navn == "nesePustTurbo" && vanedannende.pris == 500 && vanedannende.virkestoff == 0.5 && vanedannende.id == 1 && vanedannende.styrke == 10) {
            System.out.print(" Alt riktig!");
            
        }
        else{
        System.out.print(" feil!!!");

        }
        // Tester konstruktor for Narkotisk legemiddel
        System.out.println("\n ");
        System.out.println("Tester konstruktor for Narkotisk legemiddel:");


        if(narkotisk.navn == "narkotika" && narkotisk.pris == 1000 && narkotisk.virkestoff == 0.232 && narkotisk.id == 2 && narkotisk.styrke == 10000) {
            System.out.print(" Alt riktig!");
            
        }
        else{
        System.out.print(" feil!!!");

        }
        // Tester toString() metode
        System.out.println("\n ");
        System.out.println("Tester toString() metode:");
        System.out.println(vanlig);

        System.out.println(vanedannende);

        System.out.println(narkotisk);

        // Tester hentPris metode
        System.out.println("Tester hentPris metode: "); 
        if( vanlig.hentPris() == 250){
            System.out.println("Alt riktig!");
        } 
        else{
            System.out.println("feil!");
        }

        if( vanedannende.hentPris() == 500){
            System.out.println("Alt riktig!");
        } 
        else{
            System.out.println("feil!");
        }

        if( narkotisk.hentPris() == 1000){
            System.out.println("Alt riktig!");
        } 
        else{
            System.out.println("feil!");
        }
        // Tester settNyPris metode, prisen skal bli 200kr
        System.out.println("Tester settNyPris metode, prisen skal bli 200kr: "); 
        vanlig.settNyPris(200); 
            System.out.println(vanlig);
            System.out.println("Tester settNyNavn metode, prisen skal bli 200kr: "); 
        
        System.out.println("\n");

        // Slik toString() funker 
        System.out.println(vanlig);
        System.out.println(vanlig2);
        System.out.println(narkotisk);
        System.out.println(vanedannende);



    }   

}
