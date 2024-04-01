package model;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Spiel_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSpieler1;
	private JTextField txtSpieler2;
	private JTextField txtAnzahlHoelzer;
	private JLabel lblZug;
	private JLabel lblSchachtel;
	private JLabel lblgezogen;
	private JButton btnSpiel_starten;
	private JButton btnZiehe_1;
	private JButton btnZiehe_2;
	private JButton btnZiehe_3;
	private Schachtel schachtel;
	private Spieler spieler1;
	private Spieler spieler2;
	private Spieler aktuellerSpieler;
	private JLabel lblnimspielSpieler;

	
	
	public Spieler getAktuellerSpieler() {
		return aktuellerSpieler;
	}

	
	/**
	 * 
	 * @param altSpieler Spieler, welcher gerade den Zug beendet hat.
	 */
	public void waechselAktuellenSpieler(Spieler altSpieler) {
		if(altSpieler.equals(getSpieler())) {
			aktuellerSpieler = getSpieler2();
		}
		else {
			aktuellerSpieler = getSpieler();	
		}
	}
	

	

	public Spieler getSpieler() {
		return spieler1;
	}

	public Spieler getSpieler2() {
		return spieler2;
	}

	public Schachtel getSchachtel() {
		return schachtel;
	}
	
	/**
	 * Das Spiel ist erst beendet, wenn alle Hoelzer aus der Schachtel genommen wurden.
	 * @return
	 */
	public boolean istBeendet() {
		return getSchachtel().getAnzahlHoelzer() == 0;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spiel_GUI frame = new Spiel_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Spiel_GUI() {
		super();
		this.schachtel = new Schachtel();
		this.spieler1 = new Spieler(schachtel, "Spieler 1");
		this.spieler2 = new Spieler(schachtel, "Spieler 2");
		aktuellerSpieler=spieler1;
		
		setTitle("Nim-Spiel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Spieler 1:");
		lblNewLabel.setBounds(10, 41, 105, 14);
		contentPane.add(lblNewLabel);
		
		txtSpieler1 = new JTextField();
		txtSpieler1.setText("Spieler 1");
		txtSpieler1.setBounds(178, 35, 96, 20);
		contentPane.add(txtSpieler1);
		txtSpieler1.setColumns(10);
		
		JLabel lblSpieler = new JLabel("Spieler 2:");
		lblSpieler.setBounds(10, 67, 105, 14);
		contentPane.add(lblSpieler);
		
		txtSpieler2 = new JTextField();
		txtSpieler2.setText("Spieler 2");
		txtSpieler2.setColumns(10);
		txtSpieler2.setBounds(178, 61, 96, 20);
		contentPane.add(txtSpieler2);
		
		JLabel lblAnzahlHoelzer = new JLabel("Anzahl Hoelzer (10-40):");
		lblAnzahlHoelzer.setBounds(10, 92, 158, 14);
		contentPane.add(lblAnzahlHoelzer);
		
		txtAnzahlHoelzer = new JTextField();
		txtAnzahlHoelzer.setText("40");
		txtAnzahlHoelzer.setColumns(10);
		txtAnzahlHoelzer.setBounds(178, 86, 96, 20);
		contentPane.add(txtAnzahlHoelzer);
		
		btnSpiel_starten = new JButton("Spiel starten");
		btnSpiel_starten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spieler1.setName(txtSpieler1.getText());
				spieler2.setName(txtSpieler2.getText());
				getSchachtel().befuelle(Integer.parseInt(txtAnzahlHoelzer.getText()));
				wechselZug();
				
	        	btnZiehe_3.setEnabled(true);
	    		btnZiehe_2.setEnabled(true);
	        	btnZiehe_1.setEnabled(true);
	        	btnSpiel_starten.setEnabled(false);
			}
		});
		btnSpiel_starten.setBounds(314, 88, 134, 23);
		contentPane.add(btnSpiel_starten);
		
		lblZug = new JLabel("Spieler 1: Wähle eine Zahl von 1-3 zum Nehmen aus der Schachtel, falls noch genügend Hoelzer vorhanden sind.");
		lblZug.setBounds(10, 145, 706, 14);
		contentPane.add(lblZug);
		
		lblSchachtel = new JLabel("Anzahl Hoelzer: 40 ||||| ||||| ||||| ||||| ||||| ||||| ||||| |||||");
		lblSchachtel.setBounds(10, 202, 280, 14);
		contentPane.add(lblSchachtel);
		
		lblgezogen = new JLabel("");
		lblgezogen.setBounds(296, 202, 29, 14);
		contentPane.add(lblgezogen);
		
		btnZiehe_1 = new JButton("1");
		btnZiehe_1.setEnabled(false);
		btnZiehe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuellerSpieler().nehmen(1);
				lblgezogen.setText("|");
				wechselZug();
			}
		});
		
		btnZiehe_1.setBounds(314, 168, 50, 23);
		contentPane.add(btnZiehe_1);
		
		//TODO: Button als Array?
		btnZiehe_2 = new JButton("2");
		btnZiehe_2.setEnabled(false);
		btnZiehe_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuellerSpieler().nehmen(2);
				lblgezogen.setText("||");
				wechselZug();
			}
		});
		btnZiehe_2.setBounds(314, 202, 50, 23);
		contentPane.add(btnZiehe_2);
		
		btnZiehe_3 = new JButton("3");
		btnZiehe_3.setEnabled(false);
		btnZiehe_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuellerSpieler().nehmen(3);
				lblgezogen.setText("|||");
				wechselZug();
			}
		});
		btnZiehe_3.setBounds(314, 234, 50, 23);
		contentPane.add(btnZiehe_3);
		
		lblnimspielSpieler = new JLabel("NIM-Spiel: Spieler 1 setzt die Anzahl der Hoelzer fest. Anschließend werden abwechselnd 1-3 Hoelzer genommen. Wer das letzte Holz zieht verliert.");
		lblnimspielSpieler.setBounds(10, 11, 807, 14);
		contentPane.add(lblnimspielSpieler);
	}
	
	public void wechselZug() {
		waechselAktuellenSpieler(getAktuellerSpieler());
        lblSchachtel.setText(getSchachtel().toString());
        if (!istBeendet()) {
        	lblZug.setText(getAktuellerSpieler().getName() + ": Wähle eine Zahl von 1-3 zum Nehmen aus der Schachtel, falls noch genügend Hoelzer vorhanden sind.");
        	
        	if (getSchachtel().getAnzahlHoelzer() == 1)
            {
            	btnZiehe_3.setEnabled(false);
        		btnZiehe_2.setEnabled(false);
            }
        	else if(getSchachtel().getAnzahlHoelzer() == 2)
            {
        		btnZiehe_3.setEnabled(false);
            }
        }
        else
        {
        	lblZug.setText(getAktuellerSpieler().getName() + " hat gewonnen.");
        	btnZiehe_3.setEnabled(false);
    		btnZiehe_2.setEnabled(false);
        	btnZiehe_1.setEnabled(false);
        	btnSpiel_starten.setEnabled(true);
        }
	}
}