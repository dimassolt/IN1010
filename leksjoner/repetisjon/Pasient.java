public class Pasient implements Comparable<Pasient>{
    private String beskrivelse;
    private int prioritet;
    public Pasient(String beskrivelse, int prioritet){
        this.beskrivelse = beskrivelse;
        this.prioritet = prioritet;
    }
    public int compareTo(Pasient annen){
        if(prioritet < annen.prioritet){
            return -1;
        }
        else if(prioritet == annen.prioritet){
            return 0;
        }
        else {//prioritet > annen.prioritet
            return 1;
        }

        // return prioritet - annen.prioritet;
    }
    public static void main(String[] args) {
    Pasient forste = new Pasient("Brukket bein", 3);
    Pasient andre = new Pasient("Hjertesaar", 1);   

    assert forste.compareTo(andre) < 0: "!<0";
    // System.out.println(forste.compareTo(andre));

    }
}
