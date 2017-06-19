package personaje.estado;

import tablero.Equipo;

public abstract class Estado {
	
	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidadDeDesplazamiento;
	private int cantidadDeVecesQueAbsorbioVida;
	
	public abstract boolean puedeTransformarse(int ki, Equipo equipo);
	public abstract Estado transformarse(int ki) throws UltimaTransformacionAlcanzada;
	
	public int getPoderDePelea() {
		return poderDePelea;
	}

	public int getDistanciaDeAtaque() {
		return distanciaDeAtaque;
	}

	public int getVelocidadDeDesplazamiento() {
		return velocidadDeDesplazamiento;
	}
	
	public void incrementarCantidadDeVecesQueAbsorbioVida() {
		cantidadDeVecesQueAbsorbioVida++;
	}
	
}
