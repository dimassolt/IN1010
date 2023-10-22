import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View{
    
        KontrollVerden kontroll;
        JFrame vindu;
        JPanel panel, konsoll, rutenett;
        JButton[][] ruter = new JButton[12][12];
        JLabel status;
        JButton stoppknapp;
        JButton avsluttknapp;
        JButton startknapp;
        boolean slutt = false;

        // Spillstop klasse
        class Avsluttbehandler implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                kontroll.avsluttSpillet();
            }
        }
        // Spillstart klasse
        class Startbehandlinger extends Thread implements ActionListener{
            @Override
            public void run () {
                while (!slutt){
                    try {
                        sleep(500);
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
                
        // Leser trykk paa knappen
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

                
        View (KontrollVerden k) {
            kontroll = k;	
            try {
                UIManager.setLookAndFeel(
                 UIManager.getCrossPlatformLookAndFeelClassName());
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
            status.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            konsoll.add(status, BorderLayout.WEST);

            stoppknapp = new JButton("Stoppe/Fortsette");
            stoppknapp.addActionListener(new Stop());
            stoppknapp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            konsoll.add(stoppknapp, BorderLayout.SOUTH);
            
            avsluttknapp = new JButton(" Avslutt ");
            avsluttknapp.addActionListener(new Avsluttbehandler());
            avsluttknapp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            konsoll.add(avsluttknapp, BorderLayout.EAST);

            
            startknapp = new JButton("Start");
            startknapp.addActionListener(new Startbehandlinger());
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
                    b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
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

