package Bolig;

public class Test {
    public static void main(String[] args) {
        Stue stue = new Stue(25, true);
        Soverom soverom = new Soverom(15, true, stue);
        Kjokken kjokken = new Kjokken(30, false, true);

        System.out.println();
        System.out.println(stue);
        System.out.println();
        System.out.println(soverom);
        System.out.println();
        System.out.println(kjokken);

    }
}
