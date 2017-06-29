package efecto;

import personaje.Personaje;

public abstract class Efecto {
	
	protected int turnoFinal;
	
	public Efecto(int turno) {
		turnoFinal = turno;
	}
	
	public boolean estaActivo(int turno) {
		if (turno < turnoFinal) {
			return true;
		}
		return false;
	}
	
	public abstract void activarEfecto(Personaje personaje);
	
	public abstract void desactivarEfecto(int turno, Personaje personaje, int indice);
}
