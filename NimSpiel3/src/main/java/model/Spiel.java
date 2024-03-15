package model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Misère-Variante mit nur einer Reihe.
 */
public class Spiel {
	private Schachtel schachtel;
	private Spieler spieler1;
	private Spieler spieler2;
	private Spieler aktuellerSpieler;
	private int userEingabe;
	
	/**
	 * @param spieler1
	 * @param spieler2
	 * @param schachtel
	 */
	public Spiel() {
		super();
		this.schachtel = new Schachtel();
		this.spieler1 = new Spieler(schachtel, "Spieler 1");
//		this.spieler2 = new Spieler(schachtel, "Spieler 2");
		this.spieler2= new Computer(schachtel, "Computer");
		aktuellerSpieler=spieler1;
	}
	
	
	public static void main(String[] args) {
		
        // Überprüfe, ob ein Befehlszeilenparameter übergeben wurde und ob es sich um "-h" handelt
        if (args.length > 0 && args[0].equals("-h")) {
            //TODO: // Pfad zur Anleitungsdatei (NimSpiel3 finde ich nicht seit es im Repository3 ist)
            String anleitungDateiName = "C:\\Users\\karin\\eclipse-workspace\\Anleitung.txt";
        	//TODO: Diese f**** S***** will nicht als relativer Pfad funktionieren
        	//String anleitungDateiName = "main\\resources\\Anleitung.txt";
            // Erstelle ein neues File-Objekt mit dem Dateinamen der Anleitung
            File anleitungDatei = new File(anleitungDateiName);

            try {
                // Überprüfe, ob Desktop-Support verfügbar ist
                if (Desktop.isDesktopSupported()) {
                    // Hole das Desktop-Objekt
                    Desktop desktop = Desktop.getDesktop();
                    // Öffne die Anleitung mit dem Standardprogramm
                    desktop.open(anleitungDatei);
                } else {
                    System.out.println("Desktop-Support ist nicht verfügbar.");
                    // Hier könntest du eine alternative Methode implementieren, um die Anleitung zu öffnen
                }
            } catch (IOException e) {
                System.out.println("Fehler beim Öffnen der Anleitung: " + e.getMessage());
            }
        }
		
		
		
//		new Spiel().starteStatisch();
		new Spiel().starteKonsole();

	
	}
	
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
	
	/**
	 * View über Konsoleneingabe
	 */
	private void starteKonsole() {
		Scanner s = new Scanner(System.in);
		
		//erfrageSpielernamen
		//TODO: Fehler, wenn Namen aus mehr als einem Wort besteht.
		System.out.print("Spieler 1: ");
		spieler1.setName(s.next());
//		System.out.print("Spieler 2: ");
//		spieler2.setName(s.next());

		//gibSpielanleitungAus
		System.out.println("NIM-Spiel: "+ getAktuellerSpieler().getName() + " setzt die Anzahl der Hoelzer fest. Anschließend werden abwechselnd 1-3 Hoelzer genommen. Wer das letzte Holz zieht verliert.");
		
		//befülleSchachtel
		System.out.println(getAktuellerSpieler().getName() + ": Wähle eine Zahl von 10-40 zum Befüllen der Schachtel.");
		do 
		{
			userEingabe = s.nextInt();
		} while (getSchachtel().befuelle(userEingabe)!=0);
		waechselAktuellenSpieler(getSpieler());
		
		//nehmen
        while (!istBeendet()) {
            if (aktuellerSpieler instanceof Computer) {
            	System.out.println(getAktuellerSpieler().getName() + " nimmt " + ((Computer) getAktuellerSpieler()).nehmen() + " Hoelzer.");
            } else {
                System.out.println(getAktuellerSpieler().getName() + ": Wähle eine Zahl von 1-3 zum Nehmen aus der Schachtel, falls noch genügend Hoelzer vorhanden sind.");
                do {
                    userEingabe = s.nextInt();
                } while (getAktuellerSpieler().nehmen(userEingabe) != 0);
            }
            waechselAktuellenSpieler(getAktuellerSpieler());
            getSchachtel().print();
        }
		
		//gibGewinnerAn
		System.out.println(getAktuellerSpieler().getName() +" hat gewonnen.");
	}
	

	/**
	 * Testrun statisch ohne View
	 */
	private void starteStatisch() {
		getSchachtel().setAnzahlHoelzer(4);
		
		System.out.println("Anzahl Hoelzer: " +getSchachtel().getAnzahlHoelzer());
		
		getSpieler2().nehmen(3);
		
		System.out.println("Nachdem Spieler1 3 Hoelzer nimmt " +getSchachtel().getAnzahlHoelzer());
		if(istBeendet()) {
			System.out.println("Spiel ist zu Ende.");
		}	
		
		getSpieler().nehmen(1);
		
		System.out.println("Nachdem Spieler2 1 Hoelzer nimmt " +getSchachtel().getAnzahlHoelzer());
		if(istBeendet()) {
			System.out.println("Spiel ist zu Ende.");
		}
		
		getSpieler2().nehmen(3);
		
		System.out.println("Nachdem Spieler1 3 Hoelzer nimmt " +getSchachtel().getAnzahlHoelzer());
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
}
