package model;

/**
 * Hier liegen die Hölzer drin.
 */
public class Schachtel {
	private int anzahlHoelzer;
	
	/**
	 * 
	 */
	public Schachtel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param anzahlHolz
	 */
	public Schachtel(int anzahlHoelzer) {
		super();
		this.anzahlHoelzer = anzahlHoelzer;
	}
	
	public int getAnzahlHoelzer() {
		return anzahlHoelzer;
	}

	public void setAnzahlHoelzer(int anzahlHoelzer) {
		this.anzahlHoelzer = anzahlHoelzer;
	}
	
	/**
	 * gibt die Anzhal der Hoelzer in der Schachtel in der Konsole aus.
	 * und visuell Striche für Hoelzer.
	 */
	public void print() {
		String visuell = "";
		for (int i = 0; i < anzahlHoelzer; i++) {
			if(i % 5==0) { //i!=0 && wenn direkt Zeile drunter
				visuell = visuell.concat(" ");
			}
			visuell = visuell.concat("|");
		} 
		
		//Anzahl
		System.out.print("Anzahl Hoelzer: " + anzahlHoelzer);
		
		//Visuell
		if (anzahlHoelzer <10)
		{
			System.out.println(" "+ visuell);
		}
		else {
			System.out.println(visuell);
		}
	}
	
	/**
	 * momentan nicht genutzt
	 */
	@Override
	public String toString() {
		return "Anzahl Hoelzer: " + anzahlHoelzer;
	}

	/**
	 * 
	 * @param anzahlHoelzer 
	 * @return 1 Fehlermeldung: Es könnnen nur 10 bis 40 Holzer hineingetan werden
	 * 0 erfolgreich befuellt.
	 */
	public int befuelle(int anzahlHoelzer) {
		if(!(anzahlHoelzer>=10 && anzahlHoelzer<=40)) {
			setAnzahlHoelzer(anzahlHoelzer);
			System.err.println("Mit nur 10-40 Hoelzer befüllen.");
			return 1;
		}	
		else {
			this.anzahlHoelzer = anzahlHoelzer;
			return 0;
		}
	}

	
}
