package efecto;

import personaje.Personaje;

public class EfectoChocolate extends Efecto{
	
	public EfectoChocolate(int turno) {
		super(turno);
		// TODO Auto-generated constructor stub
	}

	public void activarEfecto(Personaje personaje) {
		personaje.activarEfectoChocolate(this);
	}
	
	public void desactivarEfecto(int turno, Personaje personaje, int indice) {
		if (turno == turnoFinal) {
			personaje.desactivarEfectoChocolate(indice);
		}
	}
}
