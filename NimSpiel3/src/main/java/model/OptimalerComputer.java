package model;

public class OptimalerComputer extends Computer{

	public OptimalerComputer(Schachtel schachtel, String name) {
		super(schachtel, name);
	}

	/**
	 * 
	 * @return optimaler Anzahl an gezogenen Hoelzern, wenn möglich
	 */
	public int nehmen()
	{
		zug= (schachtel.getAnzahlHoelzer()+3)%4;
		if((schachtel.getAnzahlHoelzer()+3)%4==0) {
			//zufällig wie Computer Oberklasse
			super.nehmen();
		}
		else
		{
			//optimal
			nehmen(zug);
		}	
		return zug;
	}
}
