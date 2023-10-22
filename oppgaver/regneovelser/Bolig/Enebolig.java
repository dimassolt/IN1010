package Bolig;

public class Enebolig extends Hus implements KanMales{
    public Enebolig(int arr, String adr, int antEt){
        super(arr, adr, antEt);
    }
    @Override
    public void male(){
        System.out.println("Male hele utsiden");
    }
}
