public class Hovedprogramm {
        public static void main(String[] args) {

            // Opprett et objekt av klassen Narkotisk
            Legemiddel nark = new Narkotisk("We*d", 5000, 10, 3);
            System.out.println(nark.toString());

            // Opprett et objekt av klassen Vanedannende
            Legemiddel vane = new Vanedannende("Ibux", 550, 10, 3);
            System.out.println(vane.toString());

            // Opprett to objekter av klassen Vanlig
            Legemiddel vanlig = new Vanlig("P-piler", 200, 2);
            System.out.println(vanlig.toString());

            Legemiddel vanlig1 = new Vanlig("Paraset", 150, 0.5);
            System.out.println(vanlig1.toString());
            
            // Opprett et objekt av klassen Lege
            Lege lege = new Lege("Dr.Dre");
            System.out.println(lege.toString());
            
            // Opprett et objekt av klassen Spesialist
            Spesialist spesialist = new Spesialist("Dr.Pepper", "passord");
            System.out.println(spesialist.toString());
            
            // Opprett et objekt av klassen Resept
            Presept resept = new Presept(vanlig, lege, 1, 1);
            System.out.println(resept.toString());
            
            // Opprett et objekt av klassen BlaaResept
            BlaaResept blaaResept = new BlaaResept(nark, spesialist, 2, 2);
            System.out.println(blaaResept.toString());
            
            // Opprett et objekt av klassen Militaerresept
            MilResept milres = new MilResept(vane, spesialist, 3);
            System.out.println(milres.toString());

            // Opprett et objekt av klassen Hvit Resept
            HvitResept hvitRes = new HvitResept(vanlig1, lege, 4, 2);
            System.out.println(hvitRes.toString());


        }
}
    

