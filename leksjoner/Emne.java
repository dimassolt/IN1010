class Emne {

    private String emnekode;

    private int maxAntallStudenter;

    private Student[] studenter;
    private int antallStudenter = 0;
     

    public Emne(String emnekode, int maxAntallStudenter){

        this.emnekode = emnekode;

        this.maxAntallStudenter = maxAntallStudenter;

        studenter = new Student[maxAntallStudenter];

}   
public String hentEmnekode(){
    return emnekode;
}
    public boolean harLedigPlass(){
    return maxAntallStudenter > antallStudenter;

}                                                  
public void leggTilStudent(Student student){
    if (harLedigPlass()){
        studenter[antallStudenter] = student;
        
    }
    studenter[0]=student;
    antallStudenter +=1; // sammen som ++
}
}
