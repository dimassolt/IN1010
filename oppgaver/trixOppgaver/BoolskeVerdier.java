class Boolskeverdier{
    public static void main(String[] args){
        boolean sann = true;
        boolean usann = false;
        // System.out.println(sann);
        // System.out.println(usann);
        // if (100 > 10 == sann){
        // System.out.println("Forste test slo til!");    
        // }
        // if (100 > 10 == usann){
        //     System.out.println("Det oppsto feil");
        // }

        //     else { 
        //     System.out.println("Andre test slo ikke til!");
        //     }
        if (sann != usann) {
        System.out.println("Forste test slo til!");
        } else {
        System.out.println("Noe gikk feil!");
        }

        if (sann == usann) {
        System.out.println("Noe gikk feil!");
        } else {
        System.out.println("Andre test slo ikke til!");
        }
    }
}
