package efecto;

import personaje.Personaje;

public class EfectoSemilla extends Efecto{
	
	public EfectoSemilla(int turno) {
		super(turno);
		// TODO Auto-generated constructor stub
	}

	public void activarEfecto(Personaje personaje) {
		personaje.activarEfectoSemilla(this);
	}
	
	public void desactivarEfecto(int turno, Personaje personaje, int indice) {
		if (turno == turnoFinal) {
			personaje.desactivarEfectoSemilla(indice);
		}
	}
}
