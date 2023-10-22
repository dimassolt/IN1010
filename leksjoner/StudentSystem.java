import java.util.HashMap;

public class StudentSystem {
    private Emne[] emner;
    private HashMap< Integer, Student> studenter;
    public StudentSystem(Emne[] emner,String filnavn){
    this.emner = emner;
    studenter = new HashMap
}
public void LesFraFil(String filnavn){
Scanner sc = null;
try {
    File fil = new File(filnavn);
    sc = new Scanner(fil);
} catch (Exception e) {
    // TODO: handle exception
    Systen.out.println("Fant ikke filen");
    while (sc.hasNExtline){
        String navn = sc.nextLine().trim
    }
}
}
}
