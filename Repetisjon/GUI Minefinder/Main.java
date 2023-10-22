import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Main{
  public static void main(String[] args){

    JFrame vindu = new JFrame("Vaart Vindu");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    vindu.add(panel);

    panel.setOpaque(true);
    panel.setBackground(Color.RED);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    JLabel label = new JLabel("Skriv inn noe fint her: ");

    label.setLocation(27, 20);

    JTextField tekst = new JTextField("Hei for en solfyllt dag");
    panel.add(label);
    panel.add(tekst);


    vindu.pack();
    vindu.setVisible(true);


  }
}

class JMineButton extends JButton{
  public int x;
  public int y;
  public boolean mine = false;
}

class Spill{
  public static void main(String[] args){

    int brettStoerrelse = 10;
    int mineSjanse = 20;//I prosent;

    JMineButton[][] knappBrett = new JMineButton[brettStoerrelse][brettStoerrelse];

    try {
      UIManager.setLookAndFeel(
      UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) { System.exit(1); }

    JFrame vindu = new JFrame("Spillet");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    vindu.setLayout(new BorderLayout());

    JPanel KnappPanel = new JPanel();
    vindu.add(KnappPanel);

    KnappPanel.setLayout(new GridLayout(brettStoerrelse,brettStoerrelse));

    class Hendelse implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
        JMineButton knappen = (JMineButton)e.getSource();
        System.out.println("Knappen: " + knappen.x + " " + knappen.y);

        if(knappen.mine == true){
          knappen.setBackground(Color.RED);
        }
        else{
          knappen.setBackground(Color.GREEN);
        }
      }
    }

    for(int i = 0; i < brettStoerrelse; i++){
      for(int t = 0; t < brettStoerrelse; t++){
        JMineButton knapp = new JMineButton();
        KnappPanel.add(knapp);
        knapp.setPreferredSize(new Dimension(40,40));
        knapp.addActionListener(new Hendelse());

        knappBrett[i][t] = knapp;
        knapp.x = i;
        knapp.y = t;

        if(tilfeldig(0,100) < mineSjanse){
          knapp.mine = true;
        }
      }
    }

    JPanel kontrollPanel = new JPanel();
    vindu.add(kontrollPanel, BorderLayout.PAGE_START);

    JLabel tekst = new JLabel("Minesveiper!");
    kontrollPanel.add(tekst, BorderLayout.PAGE_START);

    JButton avslutt = new JButton("Avslutt!");
    avslutt.setPreferredSize(new Dimension(200,30));

    class Avslutter implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
        System.exit(1);
      }
    }

    avslutt.addActionListener(new Avslutter());

    kontrollPanel.add(avslutt, BorderLayout.PAGE_END);

    vindu.pack();
    vindu.setVisible(true);

  }

  static int tilfeldig (int a, int b) {
    // Trekk et tilfeldig heltall i intervallet [a..b];
    return (int)(Math.random()*(b-a+1))+a;
  }
}

 