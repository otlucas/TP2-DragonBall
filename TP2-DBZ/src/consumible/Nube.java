package consumible;

import efecto.*;

public class Nube extends Consumible{
	
	protected int cantidadDeTurnos = 2;
	
	public Efecto getEfecto(int turno) {
		Efecto efecto = new EfectoNube(turno + cantidadDeTurnos);
		return efecto;
	}
}
