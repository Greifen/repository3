package model;

/**
 * Computer ist dumm und wählt zufällig eine Anzahl von Hoelzern von 1 bis 3 aus.
 */
public class Computerd extends Spieler{

	/**
	 * @param schachtel
	 */
	public Computerd(Schachtel schachtel, String name) {
		super(schachtel, name);
	}
	
	/**
	 * 
	 * @return Anzahl der genommen Hoelzer (ist zufällig, bei weniger als 3 ist es immer 1)
	 */
	public int nehmen()
	{
		if(schachtel.getAnzahlHoelzer()<3) {
			nehmen(1);
			return 1;
		}
			
		int anzahlHoelzer=(int) (Math.random()*3+1);
		nehmen(anzahlHoelzer);
		return anzahlHoelzer;
	}
}
