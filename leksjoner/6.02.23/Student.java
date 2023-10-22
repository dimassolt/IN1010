class Student{
    private String navn;
    private int studentid;
    
    public Student(String navn, int studentid){
        this.navn = navn;
        this.studentid = studentid;
 
    }
    public int hentstudentid(){
        return studentid;
    }
    public String hentNavn(){
        return navn;
    }
    public void skrivUtEmner(){
        for (Emne emne: emner){
            System.out.println()
        }
    }
    public void leggTilEmne(Emne emne){
        emner.add(emne);
    
    }
    public void fjernEmne(Emne emne){
        emner.remove(emne);
    }
}
