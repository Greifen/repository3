package model;

/**
 * Computer ist dumm und wählt zufällig eine Anzahl von Hoelzern von 1 bis 3 aus.
 */
public class Computer extends Spieler{

	protected int zug;
	
	/**
	 * @param schachtel
	 */
	public Computer(Schachtel schachtel, String name) {
		super(schachtel, name);
	}
	
	/**
	 * 
	 * @return Anzahl der genommen Hoelzer (ist zufällig, bei weniger als 3 ist es immer 1)
	 */
	public int nehmen()
	{
		if(schachtel.getAnzahlHoelzer()<3) {
			zug = 1;
		}
		else
		{
			zug =(int) (Math.random()*3+1);
		}	
		nehmen(zug);
		return zug;
	}

	/**
	 * TODO:soll ich sowas überhaupt erlauben
	 * @return Anzahl der Hoelzer die im aktuellen Zug gezogen wurden.
	 */
	public int getZug() {
		return zug;
	}

	
}
