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
	 * gibt die Anzahl der Hoelzer in der Schachtel in der Konsole aus.
	 * und visuell Striche für Hoelzer.
	 */
	public void print() {
		System.out.println(toString());
	}
	
	/**
	 *  gibt die Anzahl der Hoelzer in der Schachtel als String aus.
	 */
	@Override
	public String toString() {
		
		//Visuell
		String visuell = "";
		for (int i = 0; i < anzahlHoelzer; i++) {
			if(i % 5==0) { //i!=0 && wenn direkt Zeile drunter
				visuell = visuell.concat(" ");
			}
			visuell = visuell.concat("|");
		} 
		
		//Anzahl
		if (anzahlHoelzer <10)
		{
			return "Anzahl Hoelzer:  " + anzahlHoelzer + visuell;
		}
		else {
			return "Anzahl Hoelzer: " + anzahlHoelzer + visuell;
		}
	}

	/**
	 * 
	 * @param anzahlHoelzer 
	 * @return 1 Fehlermeldung: Es könnnen nur 10 bis 40 Holzer hineingetan werden.
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
