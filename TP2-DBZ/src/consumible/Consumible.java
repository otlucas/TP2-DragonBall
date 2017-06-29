package consumible;

import efecto.Efecto;
import posicionable.Posicionable;

public abstract class Consumible implements Posicionable {

	protected int cantidadDeTurnos;
	public int tipo;

	public abstract Efecto getEfecto(int turno);

	@Override
	public boolean esMovible() {
		return false;
	}

	@Override
	public boolean ocupaEspacio() {
		return false;
	}
}