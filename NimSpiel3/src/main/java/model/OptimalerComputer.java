package model;

public class OptimalerComputer extends Computer{

	public OptimalerComputer(Schachtel schachtel, String name) {
		super(schachtel, name);
	}

	/**
	 * @return optimaler Anzahl an gezogenen Hoelzern, wenn möglich
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
}
