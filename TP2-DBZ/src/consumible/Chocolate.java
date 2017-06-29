package consumible;

import efecto.Efecto;
import efecto.EfectoChocolate;

public class Chocolate extends Consumible {

	protected int cantidadDeTurnos = 3;

	public Efecto getEfecto(int turno) {
		Efecto efecto = new EfectoChocolate(turno + cantidadDeTurnos);
		return efecto;
	}

	@Override
	public int getTipo() {
		return 4;
	}
}