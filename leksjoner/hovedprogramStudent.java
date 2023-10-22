public class hovedprogramStudent {

    public static void main(String[] args){
    Student student1 = new Student("Dmitrii Solt",140);
    System.out.println("Navn"+ student1.hentNavn()); // Skriver ut Dmitrii Solt
    System.out.println("Id"+ student1.hentstudentid()); // 140
    Emne in1010 = new Emne("In1010",80);
    System.out.println(in1010.hentEmnekode());
}   
}
