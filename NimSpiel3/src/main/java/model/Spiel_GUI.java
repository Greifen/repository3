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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.EventHandler;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.SystemColor;

public class Spiel_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSpieler1;
	private JTextField txtSpieler2;
	private JComboBox cbxAnzahlHoelzer;
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
	private JLabel lblWhleEineZahl;
	private final JPanel panel_2 = new JPanel();

	
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
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 64, 105, 14);
		contentPane.add(lblNewLabel);
		
		txtSpieler1 = new JTextField();
		txtSpieler1.setForeground(Color.BLUE);
		txtSpieler1.setText("Spieler 1");
		txtSpieler1.setBounds(178, 58, 96, 20);
		contentPane.add(txtSpieler1);
		txtSpieler1.setColumns(10);

		txtSpieler1.addFocusListener(new FocusListener(){
			
			@Override
			public void focusGained(FocusEvent e) {
				txtSpieler1.selectAll();
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JLabel lblSpieler = new JLabel("Spieler 2:");
		lblSpieler.setForeground(Color.BLACK);
		lblSpieler.setBounds(10, 90, 105, 14);
		contentPane.add(lblSpieler);
		
		txtSpieler2 = new JTextField();
		txtSpieler2.setForeground(Color.RED);
		txtSpieler2.setText("Spieler 2");
		txtSpieler2.setColumns(10);
		txtSpieler2.setBounds(178, 84, 96, 20);
		contentPane.add(txtSpieler2);
		txtSpieler2.addFocusListener(new FocusListener(){
			
			@Override
			public void focusGained(FocusEvent e) {
				txtSpieler2.selectAll();
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblAnzahlHoelzer = new JLabel("Anzahl Hoelzer (10-40):");
		lblAnzahlHoelzer.setBounds(10, 115, 158, 14);
		contentPane.add(lblAnzahlHoelzer);
		
		
		btnSpiel_starten = new JButton("Spiel starten");
		btnSpiel_starten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spieler1.setName(txtSpieler1.getText());
				spieler2.setName(txtSpieler2.getText());
				getSchachtel().befuelle(Integer.parseInt(cbxAnzahlHoelzer.getSelectedItem().toString()));
				
				wechselZug();
				
	        	btnZiehe_3.setEnabled(true);
	    		btnZiehe_2.setEnabled(true);
	        	btnZiehe_1.setEnabled(true);
	        	btnSpiel_starten.setEnabled(false);
	        	txtSpieler1.setEnabled(false);
	        	txtSpieler2.setEnabled(false);
	        	cbxAnzahlHoelzer.setEnabled(false);
	        	lblgezogen.setText("");
	        	lblWhleEineZahl.setText("Wähle eine Zahl von 1-3 zum Nehmen aus der Schachtel, falls noch genügend Hoelzer vorhanden sind.");
	    		panel_2.setVisible(true);
			}
		});
		btnSpiel_starten.setBounds(303, 111, 134, 23);
		contentPane.add(btnSpiel_starten);
		
		lblZug = new JLabel("Spieler 2");
		lblZug.setForeground(Color.RED);
		lblZug.setBounds(20, 0, 100, 14);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		

		panel_2.add(lblZug);
		panel_2.setVisible(false);
		
		lblSchachtel = new JLabel("Anzahl Hoelzer: 40 ||||| ||||| ||||| ||||| ||||| ||||| ||||| |||||");
		lblSchachtel.setBounds(20, 72, 280, 14);
		panel_2.add(lblSchachtel);
		
		lblgezogen = new JLabel("");
		lblgezogen.setBounds(296, 72, 29, 14);
		panel_2.add(lblgezogen);
		
		btnZiehe_1 = new JButton("1");
		btnZiehe_1.setToolTipText("Ziehe ein Streichholz.");
		btnZiehe_1.setEnabled(false);
		btnZiehe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuellerSpieler().nehmen(1);
				lblgezogen.setText("|");
				wechselZug();
			}
		});

		
//		Wenn button aktiv dann reagiert er nur auf press :(
/*		btnZiehe_1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int c = e.getKeyCode();
		        if(c == KeyEvent.VK_ENTER){//	VK_NUMPAD1 
		        	getAktuellerSpieler().nehmen(2);
					lblgezogen.setText("|");
					wechselZug();
		        }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
*/
		

		btnZiehe_1.setBounds(314, 38, 50, 23);
		panel_2.add(btnZiehe_1);
		
		//TODO: Button als Array?
		btnZiehe_2 = new JButton("2");
		btnZiehe_2.setToolTipText("Ziehe 2 Streichhölzer.");
		btnZiehe_2.setEnabled(false);
		btnZiehe_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuellerSpieler().nehmen(2);
				lblgezogen.setText("||");
				wechselZug();
			}
		});
		btnZiehe_2.setBounds(314, 72, 50, 23);
		panel_2.add(btnZiehe_2);
		
		btnZiehe_3 = new JButton("3");
		btnZiehe_3.setToolTipText("Ziehe 3 Streichhölzer.");
		btnZiehe_3.setEnabled(false);
		btnZiehe_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuellerSpieler().nehmen(3);
				lblgezogen.setText("|||");
				wechselZug();
			}
		});
		btnZiehe_3.setBounds(314, 104, 50, 23);
		panel_2.add(btnZiehe_3);
		
//		lblnimspielSpieler = new JLabel("<html><body><FONT COLOR=\"#FF0099\">Spieler 1</FONT> setzt die Anzahl der Hoelzer fest.<br>Anschließend werden abwechselnd 1-3 Hoelzer genommen.<br><b>Wer das letzte Holz zieht verliert.</b></body></html>");
		lblnimspielSpieler = new JLabel("<html><body><b>Wer das letzte Holz zieht verliert.</b></body></html>");
		lblnimspielSpieler.setToolTipText("Spieler 1: Wähle eine Zahl von 10-40 Hoelzer zum Befüllen der Schachtel.");
		lblnimspielSpieler.setBounds(10, 23, 807, 50);
		contentPane.add(lblnimspielSpieler);
		
		//TODO: echt nicht int übergebar?
		String comboBoxListe[] = {"10", "11",
	            "12", "13", "14",
	            "15", "16", "17",
	            "18", "19", "20",
	            "21", "22", "23",
	            "24", "25", "26", "27", "28",
	            "29", "30", "31",
	            "31", "32", "33",
	            "34", "35", "36",
	            "37", "38", "39", "40"};
		cbxAnzahlHoelzer = new JComboBox(comboBoxListe);
		cbxAnzahlHoelzer.setBounds(178, 111, 96, 22);
		cbxAnzahlHoelzer.setSelectedIndex((int) (Math.random()*30+10));
		cbxAnzahlHoelzer.setToolTipText("Spieler 1: Wähle eine Zahl von 10-40 Hoelzer zum Befüllen der Schachtel.");
		contentPane.add(cbxAnzahlHoelzer);
		
		
//		TODO: doof da muss man noch alt+1 drücken		
		btnZiehe_1.setMnemonic('1');
		btnZiehe_2.setMnemonic('2');
		btnZiehe_3.setMnemonic('3');
		
		JList list = new JList();
		list.setBounds(114, 295, 1, 1);
		contentPane.add(list);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(619, 168, -396, -35);
		contentPane.add(panel);
		panel_2.setBounds(-11, 143, 900, 153);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblWhleEineZahl = new JLabel("Wähle eine Zahl von 1-3 zum Nehmen aus der Schachtel, falls noch genügend Hoelzer vorhanden sind.");
		lblWhleEineZahl.setBounds(100, 0, 706, 14);
		panel_2.add(lblWhleEineZahl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-5, 0, 931, 15);
		panel_2.add(panel_1);
		panel_1.setBackground(SystemColor.info);
		panel_1.setForeground(Color.BLACK);
/*		
 //TODO: Was besser Combobox oder Spinner?
		JSpinner spiAnzahlHoelzer = new JSpinner();
		spiAnzahlHoelzer.setToolTipText("Spieler 1: Wähle eine Zahl von 10-40 Hoelzer zum Befüllen der Schachtel.");
		spiAnzahlHoelzer.setBounds(459, 112, 57, 20);
		contentPane.add(spiAnzahlHoelzer);
		*/
	}
	
	public void wechselZug() {
		waechselAktuellenSpieler(getAktuellerSpieler());
        lblSchachtel.setText(getSchachtel().toString());
        if (!istBeendet()) {
        	lblZug.setText(getAktuellerSpieler().getName());
        	if (getAktuellerSpieler().equals(getSpieler())){
        		lblZug.setForeground(Color.BLUE);
        	}
        	else
        	{
        		lblZug.setForeground(Color.RED);
        	}
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
        	lblWhleEineZahl.setText("hat gewonnen.");
        	lblZug.setText(getAktuellerSpieler().getName());
        	if (getAktuellerSpieler().equals(getSpieler())){
        		lblZug.setForeground(Color.BLUE);
        	}
        	else
        	{
        		lblZug.setForeground(Color.RED);
        	}
        	btnZiehe_3.setEnabled(false);
    		btnZiehe_2.setEnabled(false);
        	btnZiehe_1.setEnabled(false);
        	btnSpiel_starten.setEnabled(true);
        	txtSpieler1.setEnabled(true);
        	txtSpieler2.setEnabled(true);
        	cbxAnzahlHoelzer.setEnabled(true);
        	btnSpiel_starten.requestFocusInWindow();
        	
        	  
        	//TODO: checken ob richtig von 0 bis 30 [bzw. 10 bis 40 wenn nicht index] wie testen? (10 beim händischen testen gekommen, 40 noch nicht, aber 38)
        	cbxAnzahlHoelzer.setSelectedIndex((int) (Math.random()*30));
        	
        	
        }
	}
}
