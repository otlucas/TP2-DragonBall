package efecto;

import personaje.Personaje;

public class EfectoNube extends Efecto{
	
	public EfectoNube(int turno) {
		super(turno);
		// TODO Auto-generated constructor stub
	}

	public void activarEfecto(Personaje personaje) {
		personaje.activarEfectoNube(this);
	}
	
	public void desactivarEfecto(int turno, Personaje personaje, int indice) {
		if (turno == turnoFinal) {
			personaje.desactivarEfectoNube(indice);
		}
	}
}
