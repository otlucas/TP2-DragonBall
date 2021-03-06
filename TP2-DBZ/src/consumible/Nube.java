package consumible;

import efecto.Efecto;
import efecto.EfectoNube;

public class Nube extends Consumible{

	protected int cantidadDeTurnos = 2;

	public Efecto getEfecto(int turno) {
		Efecto efecto = new EfectoNube(turno + cantidadDeTurnos);
		return efecto;
	}

	public int getTipo(){
		return 2;
	}
}
