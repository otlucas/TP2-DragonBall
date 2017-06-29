package efecto;

import personaje.Personaje;

public class EfectoEsfera extends Efecto{
	
	public EfectoEsfera(int turno) {
		super(turno);
		// TODO Auto-generated constructor stub
	}

	public void activarEfecto(Personaje personaje) {
		personaje.activarEfectoEsfera(this);
	}
	
	public void desactivarEfecto(int turno, Personaje personaje, int indice) {
		if (turno == turnoFinal) {
			personaje.desactivarEfectoEsfera(indice);
		}
	}
}
