import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Legesystemet{
    // Oppretter lister for hver klasse
    public static Lenkeliste<Lege> leger = new Koe<Lege>();
    public static Lenkeliste<Legemiddel> legemidler = new Koe<Legemiddel>();
    public static Lenkeliste<Resept> resepter = new Koe<Resept>();
    public static Lenkeliste<Pasient> pasienter = new Koe<Pasient>();
    public static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) throws NumberFormatException, UgyldigListeindeks, UlovligUtskrift, IOException{
        brukerensMeny();
    }
    public static void lesFil(String filnavn) throws NumberFormatException, UgyldigListeindeks, UlovligUtskrift{
        //Leser inn fra fil
        try{

            File fil = new File(filnavn);
            Scanner innlesning = new Scanner(fil);
            innlesning.nextLine();
        
            try{ 
                //Leser fra fil, hvis linja ikke starter med # (pasienter)
                String linje_pasient = innlesning.nextLine();
                while(!(linje_pasient.contains("#"))){
                    String elementPasient = linje_pasient;
                    String pasientNavn = elementPasient.split(",")[0];
                    String pasientFodNummer = elementPasient.split(",")[1];
                    Pasient pasient = new Pasient(pasientNavn,pasientFodNummer);
                    pasienter.leggTil(pasient);
                    linje_pasient = innlesning.nextLine();
                }

                }
                catch (Exception InvalidParameterException){
                    System.err.println("Ugyldig data fra fil!");
                }

                try{ 
                    //Leser fra fil, hvis linja ikke starter med # (Legemidler)
                    String linje_legemiddel = innlesning.nextLine();
                    while(!(linje_legemiddel.contains("#"))){
                        // Legemidler (navn,type,pris,virkestoff,[styrke])
                        String elementLegemiddel = linje_legemiddel;
                        String legemiddelNavn = elementLegemiddel.split(",")[0];
                        String legemiddelType = elementLegemiddel.split(",")[1];
                        String legemiddelPr = elementLegemiddel.split(",")[2];
                        int legemiddelPris = Integer.parseInt(legemiddelPr);
                        String legemiddelVirk = elementLegemiddel.split(",")[3];
                        double legemiddelVirkestoff = Double.parseDouble(legemiddelVirk);
                        
                        if(legemiddelType.equals("narkotisk") || legemiddelType.equals("vanedannende")){
                            String legemiddelStyrk = elementLegemiddel.split(",")[4];
                            int legemiddelStyrke = Integer.parseInt(legemiddelStyrk);
                            if(legemiddelType.equals("narkotisk")){
                                Narkotisk narkotisk_legemiddel = new Narkotisk(legemiddelNavn, legemiddelPris, legemiddelVirkestoff, legemiddelStyrke);
                                legemidler.leggTil(narkotisk_legemiddel);
                                linje_legemiddel = innlesning.nextLine();
                                
                            }
                            else{
                                Vanedannende vanedannende_legemiddel = new Vanedannende(legemiddelNavn, legemiddelPris, legemiddelVirkestoff, legemiddelStyrke);
                                legemidler.leggTil(vanedannende_legemiddel);
                                linje_legemiddel = innlesning.nextLine();
                            }
                        }
                        else if(legemiddelType.equals("vanlig")){
                            Vanlig vanlig_legemidler = new Vanlig(legemiddelNavn,legemiddelPris, legemiddelVirkestoff);
                            legemidler.leggTil(vanlig_legemidler);
                            linje_legemiddel = innlesning.nextLine();
                            
                        } 
                        else{
                            innlesning.nextLine();
                        }
                    } 
                        
                }
                    catch (Exception InvalidParameterException){
                        System.err.println("Ugyldig data fra fil!");
                    }

                    try{ 
                        //Leser fra fil, hvis linja ikke starter med # (leger)
                        String linje_lege = innlesning.nextLine();
                        while(!(linje_lege.contains("#"))){
                            String elementLege = linje_lege;
                            String legeNavn = elementLege.split(",")[0];
                            String legeKontrollkode = elementLege.split(",")[1];
                            if(legeKontrollkode.equals("0")){ 
                                Lege lege = new Lege(legeNavn);
                                leger.leggTil(lege);
                                linje_lege = innlesning.nextLine();
                            }
                            else{
                                Spesialist spesialist = new Spesialist(legeNavn, legeKontrollkode);
                                leger.leggTil(spesialist);
                                linje_lege = innlesning.nextLine();
                            }
                        }
                        
                        }
                        catch (Exception InvalidParameterException){
                            System.out.println("Ugyldig data fra fil!");
                        }

                    try{
                    //Leser fra fil, hvis linja ikke starter med # (Legemidler)
                    String linje_resept = innlesning.nextLine();
                    while(linje_resept != null){
                        // Resepter  (legemiddelNummer,legeNavn,pasientID,type,[reit])
                        // Vi setter navn for hver element i filens linje 
                        // til aa kunne viderebruke data fra andre klasser
                        String elementResept = linje_resept;
                        int legemiddelNr = Integer.parseInt(elementResept.split(",")[0]);
                        String legeNavn = elementResept.split(",")[1];
                        // System.out.println(legeNavn);
                        int pasientId = Integer.parseInt(elementResept.split(",")[2]);
                        String reseptType = elementResept.split(",")[3];

                            Legemiddel denneLegmid = new Vanlig(" ibuprofen",0,0);
                            for(Legemiddel leg:legemidler){
                                if(legemiddelNr == leg.hentId()){
                                    denneLegmid = leg;
                                }

                            }

                            Lege denneLege = new Lege("Oleg");
                            for(Lege l:leger){
                                if(legeNavn.equalsIgnoreCase(l.hentNavn())){
                                    denneLege = l;
                                }
                            }                                                                
                            Pasient dennePasient = new Pasient("","");
                            for(Pasient p:pasienter){
                                if(pasientId == p.hentId()){
                                    dennePasient = p;
                                }
                            }
                            
                        if(reseptType.equals("blaa")){                
                            try{
                            resepter.leggTil(denneLege.skrivBlaaResept(denneLegmid,dennePasient,Integer.parseInt(linje_resept.split(",")[4])));                        
                            } 
                        catch (UlovligUtskrift e) {
                            e.printStackTrace();
                        }}
                            
                        else if(reseptType.equals("militaer")){
                            try{
                            resepter.leggTil(denneLege.skrivMilResept(denneLegmid,dennePasient));
                        } 
                        catch (UlovligUtskrift e) {
                            e.printStackTrace();
                        }                        }
                        
                        else if(reseptType.equals("hvit")){
                            try{
                            resepter.leggTil(denneLege.skrivHvitResept(denneLegmid,dennePasient,Integer.parseInt(elementResept.split(",")[4])));
                        } catch (UlovligUtskrift e) {
                            e.printStackTrace();
                        }
                        }

                        else if(reseptType.equals("p")){
                            try{
                            resepter.leggTil(denneLege.skrivPResept(denneLegmid,dennePasient,Integer.parseInt(linje_resept.split(",")[4])));
                    } catch (UlovligUtskrift e) {
                        e.printStackTrace();
                    }
                        }
                        else{
                            innlesning.nextLine();
                        }

                        // Her er noen tester som printer ut alltilgjengelig info

                        // System.out.println(resepter);
                        // System.out.println(denneLege);
                        // System.out.println(dennePasient);
                        // System.out.println(denneLegmid);
                        // System.out.println(linje_resept);
                        // System.out.println(denneLege.utskrevneResepter);
                        // System.out.println(dennePasient.hentId());
                        // if(linje_resept!=null){
                        linje_resept = innlesning.nextLine();
                        }
                        
                    }
                        catch (Exception InvalidParameterException){
                        innlesning.close();
                        }
                        
                        }
                catch(FileNotFoundException e){
                System.out.println(e);
                }
        
    }

public static void brukerensMeny() throws IOException, NumberFormatException, UgyldigListeindeks, UlovligUtskrift{
        
    int svar = 100;
     //Kommandoloekke
    while(svar != 0){
        System.out.println("");
        System.out.println("Hva kan jeg hjelpe deg med?\n");
        System.out.println("NB: ALLtid start med 'Les fil'\n");
        System.out.println("1) Les fil");
        System.out.println("2) Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter");
        System.out.println("3) Opprette nye elementer");
        System.out.println("4) Bruk resept");
        System.out.println("5) Se statistikk");
        System.out.println("Tast inn '0' for aa avlutte programmet");
        
        System.out.print("Velg hva du vil gjoere:\n");
        svar = scanner.nextInt();
        

        if(svar == 1){
            lesFil("LiteEksempel.txt");
        }else if(svar == 3){
            nyeElementer("LiteEksempel.txt");
        }else if(svar == 2){
           skrivUtFil();
        }else if(svar == 4){
            brukReseptForPasient("LiteEksempel.txt");
        }else if(svar == 5){
            seStatistik();
        }else if(svar!=1 && svar != 2 && svar != 3 && svar != 4 && svar != 0){
            System.out.println("Ugyldig input");
        }
            
        } System.out.println("Takk! Ha det bra!");
    
}

private static void skrivUtFil(){
    /*Skriver ut en oversikt over hele legesystemet

    Pasient: Navn, fødselsnr, ID
    Legemiddel: Navn, type, pris, virkestoff, styrke, ID
    Lege: Navn, kontrollkode
    Resept: LegemiddelNummer, lege, paientID, type */
     // Fyll inn informasjonen for hver kategori:

    System.out.println("Pasienter: ");
    for (Pasient pasient : pasienter) {
       System.out.println(pasient);
    }
    
    System.out.println("Legemidler: ");
    for (Legemiddel legemiddel : legemidler) {
        System.out.println(legemiddel);
    }
    
    System.out.println("Leger: ");
    for(Lege le : leger){
        System.out.println(le);}
   
    System.out.println("Resepter: ");
    for(Resept res : resepter){
       System.out.println(res);}

}
private static void nyeElementer(String filnavn) throws IOException{
    //Åpner filen, appendmode
    BufferedReader br = new BufferedReader(new FileReader(filnavn));
    try {
        System.out.println("Hva vil du skrive inn?:");
        System.out.println("1 - Pasient");
        System.out.println("2 - Legemiddel");
        System.out.println("3 - Lege");
        System.out.println("4 - Resept");
        int valg = scanner.nextInt();

        if(valg == 1){
            String line_pasient;
            StringBuilder sb = new StringBuilder();
            while ((line_pasient = br.readLine()) != null) {
            if (line_pasient.contains("# Legemidler (navn,type,pris,virkestoff,[styrke])")) {
            scanner.nextLine();
            System.out.println("Tast inn pasientens navn og foedselsnummer (navn,fn)");
            String pas = scanner.nextLine();
            sb.append(pas).append("\n");
            sb.append(line_pasient).append("\n");
        } else {
            sb.append(line_pasient).append("\n");
        }
        }
        FileWriter fw = new FileWriter(filnavn, false);
        fw.write(sb.toString());
        fw.close();
        }else if(valg == 2){
            String line_legemiddel;
            StringBuilder sb = new StringBuilder();
            while ((line_legemiddel = br.readLine()) != null) {
            if (line_legemiddel.contains("# Leger (navn,kontrollid / 0 hvis vanlig lege)")) {
            scanner.nextLine();
            System.out.println("Legemiddel (navn,type,pris,virkestoff,[styrke]):");
            String leg = scanner.nextLine();
            sb.append(leg).append("\n");
            sb.append(line_legemiddel).append("\n");
        } else {
            sb.append(line_legemiddel).append("\n");
        }
        }
        FileWriter fw = new FileWriter(filnavn, false);
        fw.write(sb.toString());
        fw.close();
        }else if(valg ==3){
            String line_lege;
            StringBuilder sb = new StringBuilder();
            while ((line_lege = br.readLine()) != null) {
            if (line_lege.contains("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])")) {
            scanner.nextLine();
            System.out.println("Tast inn leges navn og kontrollkode (navn,kode)");
            String le = scanner.nextLine();
            sb.append(le).append("\n");
            sb.append(line_lege).append("\n");
        } else {
            sb.append(line_lege).append("\n");
        }
        }
        FileWriter fw = new FileWriter(filnavn, false);
        fw.write(sb.toString());
        fw.close();
        }else if(valg == 4){
                scanner.nextLine();
                System.out.println("Tast inn ny resept (legemiddelNummer (4+),legeNavn,pasientID,type,[reit])");
                String res = scanner.nextLine();
                try(
                BufferedWriter writer = new BufferedWriter(new FileWriter(filnavn, true))) {
                writer.append("\n" + res);
                // writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }else{
            System.out.println("Ugildig input");}
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        br.close();
    }
}    


    private static void brukReseptForPasient(String filnavn) throws IOException{
    //  Metoden skal bruke resept for den gitte pasienten

        // Klarte ikke aa la den substitere reit i filen

        try {
            System.out.println("Hvilken pasient vil du se resepter for?");
            for(Pasient pasient:pasienter){
                System.out.println(pasient.id + ": " + pasient.brukString());
            }
            int valg_pasient = scanner.nextInt();
    
            if(0<=valg_pasient || valg_pasient <= pasienter.stoerrelse()){
                for(Pasient pasient:pasienter){    
                    if(valg_pasient == pasient.id){
                        System.out.println("Valgt pasient: " + pasient.brukString());
                        System.out.println();
                        System.out.println("Hvilken resept vil du bruke?");
                        System.out.println();
                        for(Resept resept:pasient.utskrevneResepter){
                            System.out.println(resept.hentId()+": " + resept.hentLegemiddel().hentNavn() + " ("+ resept.hentReit()+ " reit)");
                        }
                        int valg_resept = scanner.nextInt();
                        if(0<=valg_resept || valg_resept <= pasient.utskrevneResepter.stoerrelse()){
                            for(Resept resept:pasient.utskrevneResepter){
                                if(valg_resept == resept.id && resept.reit != 0){
                                    resept.bruk();
                                    System.out.println();
                                    System.out.println("Brukte resept paa " + resept.hentLegemiddel() + " antall reit igjen: " + resept.hentReit());
                                }
                                else if(valg_resept == resept.id && resept.reit == 0){
                                    System.out.println("Kunne ikke bruke resept paa " + resept.hentLegemiddel() + " (reit igjen: " + resept.hentReit()+")");
                                }
                            }
                        }
                        else{
                            FileWriter fw = new FileWriter(filnavn, false);
                            System.out.println("Ugyldig resept id!!!");
                            fw.close();
                        }
                    }
                }
            }
            else{
                FileWriter fw = new FileWriter(filnavn, false);
                System.out.println("Ugyldig pasient id!!!");
                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }       

    private static void seStatistik(){
    // Skal printe ut statistikk i foelge oppgaveteksten
    
        int antallVane = 0;
        int antallNark = 0;
        Lenkeliste<Lege> narkoLeger = new IndeksertListe<Lege>();
        Lenkeliste<Pasient> narkoPas = new Koe<Pasient>();
       
        // Viser antall vanedannende og narkotiske resepter i Koe<Resept>
        System.out.println();

        System.out.println("Viser statistikk for antall vanedannende og narkotiske resepter: \n");
        for(Resept resept:resepter){
            if(resept.hentLegemiddel() instanceof Vanedannende){
                antallVane++;
            }
            else if(resept.hentLegemiddel() instanceof Narkotisk){
                antallNark++;
            }
        }            
        System.out.println("Antall vanedannende: " + antallVane);
        System.out.println("Antall narkotiske: " + antallNark);

        // Skal vise leger som skriver narkoresepter
        for(Resept resept: resepter){
            if(resept.hentLegemiddel() instanceof Narkotisk){
                narkoLeger.leggTil(resept.hentLege());
            }        
        }
        for(Lege lege:narkoLeger){
            System.out.println(lege.hentNavn());
        }

        // Skal vise pasienter som skriver narkoresepter
        for(Resept resept: resepter){
            if(resept.hentLegemiddel() instanceof Narkotisk){
                narkoPas.leggTil(resept.hentpasient());
            }        
        }
        for(Pasient pas:narkoPas){
            System.out.println(pas.hentNavn());
        }
    }
}