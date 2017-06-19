package personaje.estado;

import tablero.Equipo;

public class CellNormal extends Estado {
	
	private int cantidadDeVecesQueAbsorbioVida;
	
	public CellNormal(int cantidadDeVecesQueAbsorbioVida) {
		this.cantidadDeVecesQueAbsorbioVida = cantidadDeVecesQueAbsorbioVida;
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 3;
		this.velocidadDeDesplazamiento = 2;
	}
	
	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (cantidadDeVecesQueAbsorbioVida >= 4);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		return new CellSemiPerfecto(cantidadDeVecesQueAbsorbioVida);
	}
	
	public void incrementarCantidadDeVecesQueAbsorbioVida() {
		cantidadDeVecesQueAbsorbioVida++;
	}
	
}
