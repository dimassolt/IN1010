class TestResepter {
    public static void main(String[] args) {
        // Oppretter noen legemidler
        Vanlig vanlig = new Vanlig("P-piler", 250, 0.25);
        Vanlig vanlig2 = new Vanlig("P-piler", 250, 0.25);
        Vanedannende vanedannende = new Vanedannende("nesePustTurbo",500, 0.5, 10);

        // Oppretter noen leger
        Lege dre = new Lege("Dr.Dre");
        Lege dreee = new Lege("Dr.Dreee");

        // Tester HvitResept
        HvitResept hvitRes = new HvitResept(vanlig, dre, 1, 2);
        System.out.println(hvitRes);
        System.out.println("Resept id: " + hvitRes.hentId());
        System.out.println("Farge: " + hvitRes.farge());
        System.out.println("Pris å betale: " + hvitRes.prisAaBetale());
        hvitRes.bruk();
        hvitRes.bruk();
        hvitRes.bruk();
        System.out.println("Reit igjen etter tre bruk: " + hvitRes.hentReit());
        
        System.out.println("\n");

        // Tester MilResept
        MilResept milRep = new MilResept(vanedannende, dreee, 1);
        System.out.println(milRep);
        System.out.println("Resept id: " + milRep.hentId());
        System.out.println("Farge: " + milRep.farge());
        System.out.println("Pris å betale: " + milRep.prisAaBetale());
        System.out.println("Reit igjen: " + milRep.hentReit());
        

        System.out.println("\n");

        // Tester Presepter
        Presept pres = new Presept(vanlig, dre, 1, 2);
        System.out.println(pres);
        System.out.println("Resept id: " + pres.hentId());
        System.out.println("Farge: " + pres.farge());
        System.out.println("Pris å betale: " + pres.prisAaBetale());
        pres.bruk();
        System.out.println("Reit igjen: " + pres.hentReit());

        System.out.println("\n");

        // Tester BlaaResept
        BlaaResept blaaRes = new BlaaResept(vanlig2, dreee, 2, 1);
        System.out.println(blaaRes);
        System.out.println("Resept id: " + blaaRes.hentId());
        System.out.println("Farge: " + blaaRes.farge());
        System.out.println("Pris å betale: " + blaaRes.prisAaBetale());
        blaaRes.bruk();
        System.out.println("Reit igjen etter en bruk: " + blaaRes.hentReit());
    }
}



 