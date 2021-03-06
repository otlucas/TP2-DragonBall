package consumible;

import efecto.Efecto;
import efecto.EfectoEsfera;

public class EsferaDelDragon extends Consumible{

	protected int cantidadDeTurnos = 2;

	public Efecto getEfecto(int turno) {
		Efecto efecto = new EfectoEsfera(turno + cantidadDeTurnos);
		return efecto;
	}

	public int getTipo(){
		return 1;
	}
}