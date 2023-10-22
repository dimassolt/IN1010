import java.awt.*;
import javax.swing.*;
// import java.awt.BorderLayout;
class EksempelGrid{
    public static void main(String[] args){
        JFrame vindu = new JFrame("Navn paa vindu");
        // vindu.setSize(600,400);
        vindu.setLayout(new GridLayout(1,2));
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel tekst = new JLabel(); // Setter et nytt labele
        vindu.add(tekst, BoarderLayout.NORTH);  
// Add a panel
        JPanel hovedpanel1 = new JPanel();
        hovedpanel1.setLayout(new GridLayout(1,6)); //rad, kol
        // Setter stoerrelse paa panelen
        hovedpanel1.setPreferredSize(new Dimension(600,400));
        vindu.add(hovedpanel1);
// Add a knap
        for(int i = 6; i<6;i++){
        JButton knapp1 = new JButton("Tekst knapp");
        hovedpanel1.add(knapp1);
        }

        JButton knapp2 = new JButton("Tekst knapp");
        hovedpanel1.add(knapp2);

        vindu.pack(); // komprimerer - pakker 
        vindu.setLocationRelativeTo(null); // Midtstiller
        vindu.setVisible(true);
    }
}