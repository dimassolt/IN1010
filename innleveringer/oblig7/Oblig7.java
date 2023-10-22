import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args) {
        String filnavn = args[0];
        Labyrint lab = new Labyrint(filnavn);

        // Printer ut antall rader og kolonner 
        System.out.println();

        System.out.print("Rader: ");

        System.out.print(lab.antRader);
        System.out.print(" ");
        System.out.print("Kolonner: ");


        System.out.println(lab.antKolonner);
        System.out.println();

        // Tegner labyrinten
        System.out.println(lab);
  
        // Bruker velger handling
        Scanner brukerinput = new Scanner(System.in);

        System.out.println("\nOppgi koordinater for hvit rute (rad kol).(-1 for aa avslutte):");
        String inn = brukerinput.nextLine();

        while (!inn.equals("-1")) {
            String[] l = inn.split(" ");

            try {
                int rad = Integer.parseInt(l[0]);
                int kol = Integer.parseInt(l[1]);

                try {
                    lab.finnUtVei(rad, kol);
                    inn = brukerinput.nextLine();

                }
                catch (NumberFormatException e) {
                
                }
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Oppgi koordinater som tilsvarer labyrinten!");
                inn = brukerinput.nextLine();
            }
            
        }
        brukerinput.close();
    }                
}

