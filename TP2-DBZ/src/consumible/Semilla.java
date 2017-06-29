package consumible;

import efecto.Efecto;
import efecto.EfectoSemilla;

public class Semilla extends Consumible{

	protected int cantidadDeTurnos = 1;
	public int tipo = 3;

	public Efecto getEfecto(int turno) {
		Efecto efecto = new EfectoSemilla(turno + cantidadDeTurnos);
		return efecto;
	}
}