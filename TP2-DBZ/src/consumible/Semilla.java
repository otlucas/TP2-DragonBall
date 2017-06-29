package consumible;

import efecto.Efecto;
import efecto.EfectoSemilla;

public class Semilla extends Consumible{

	protected int cantidadDeTurnos = 1;

	public Efecto getEfecto(int turno) {
		Efecto efecto = new EfectoSemilla(turno + cantidadDeTurnos);
		return efecto;
	}

	public int getTipo(){
		return 3;
	}
}