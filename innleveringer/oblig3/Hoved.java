 public class Hoved {
    public static void main(String[]args){
    IndeksertListe<String> liste = new IndeksertListe<>();
liste.leggTil("A");
liste.leggTil("B");
liste.leggTil("C");
// System.out.println(liste);

liste.fjern();
// System.out.println(liste);
liste.sett(1, "D");
}
}