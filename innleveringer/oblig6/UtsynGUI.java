import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UtsynGUI{
    // Deklarerer variabler og andre objekter som skal brukes videre
    KontrollVerden kontroll;
    JFrame vindu;
    JPanel panel, konsoll, rutenett;
    JButton[][] ruter = new JButton[12][12];
    JLabel status;
    JButton stoppknapp;
    JButton avsluttknapp;
    JButton startknapp;
    boolean slutt = false;

    // Avslutter heleprogrammet
    class Avsluttbehandler implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kontroll.avsluttSpillet();
        }
    }
    // Starter programmet
    class Startbehandlinger extends Thread implements ActionListener{
        @Override
        public void run () {
            while (!slutt){
                try {
                    sleep(2000);
                    kontroll.tegn();                
                    kontroll.oppdatering();
                    kontroll.startSpillet();
                } catch (InterruptedException e) {}
            }
        }
        @Override
        public void actionPerformed (ActionEvent e) {                
                start();
        }
    }
            
    // Leser trykk paa knappen til aa stoppe eller fortsette
    class Stop implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            slutt = !slutt;
            new Startbehandlinger().start();
        }
    }

    // Trykk paa brett tik aa endre Celles status (levende/doed)
    class Spillvelger implements ActionListener {
        int rad, kol;
        Spillvelger (int r, int k) {
            rad = r;  kol = k;
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            kontroll.brukervalg(rad, kol);
        }
    }

            
    UtsynGUI (KontrollVerden k) {
        kontroll = k;	
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { System.exit(9); }

        vindu = new JFrame("Game of Life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        vindu.add(panel);

        konsoll = new JPanel();
        konsoll.setLayout(new BorderLayout());
        panel.add(konsoll, BorderLayout.NORTH);

        status = new JLabel(" ");
        status.setForeground(Color.DARK_GRAY); 
        status.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        status.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        konsoll.add(status, BorderLayout.WEST);

        stoppknapp = new JButton("Stoppe/Fortsette");
        stoppknapp.addActionListener(new Stop());
        stoppknapp.setBackground(Color.LIGHT_GRAY);
        stoppknapp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        stoppknapp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        konsoll.add(stoppknapp, BorderLayout.SOUTH);
        
        avsluttknapp = new JButton(" Avslutt ");
        avsluttknapp.addActionListener(new Avsluttbehandler());
        avsluttknapp.setBackground(Color.LIGHT_GRAY);
        avsluttknapp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        avsluttknapp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        konsoll.add(avsluttknapp, BorderLayout.EAST);

        
        startknapp = new JButton("Start");
        startknapp.addActionListener(new Startbehandlinger());
        startknapp.setBackground(Color.LIGHT_GRAY);
        startknapp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        startknapp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        konsoll.add(startknapp, BorderLayout.CENTER);

        // Oppretter knapper og spillebrett
        rutenett = new JPanel();
        rutenett.setLayout(new GridLayout(12,12));
        for (int rx = 0;  rx < 12;  ++rx) {
            for (int kx = 0;  kx < 12;  ++kx) {
                JButton b = new JButton(" ");
                ruter[rx][kx] = b;
                b.addActionListener(new Spillvelger(rx,kx));
                b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
                b.addActionListener(new Spillvelger(rx,kx));
                rutenett.add(b);
            }
        }

        panel.add(rutenett, BorderLayout.CENTER);    
        vindu.pack();
        vindu.setSize(800,800);
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }
    // Viser endrede Celle paa GUI
    public void visEndring (int r, int k, char c) {
        ruter[r][k].setText(Character.toString(c));
    }    
    // Viser alle Celler
    public void markerCelle (int r, int k, char c) {
        ruter[r][k].setText(Character.toString(c));
    }    
    // Viser antall levende Celler og generasjonsnummer
    void visStatus () {
        status.setText(" Antall levende igjen: "+Integer.toString(kontroll.skrivUtAntallLevende())+ 
        " " + "Antall generasjon: " + Integer.toString(kontroll.genNr) + " ");
    }
    
}

