package personaje.estado;

import tablero.Equipo;

public class CellSemiPerfecto extends Estado {

	private int cantidadDeVecesQueAbsorbioVida;
	
	public CellSemiPerfecto(int cantidadDeVecesQueAbsorbioVida) {
		this.cantidadDeVecesQueAbsorbioVida = cantidadDeVecesQueAbsorbioVida;
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 3;
		this.kiParaTransformarse = 0;
	}
	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (cantidadDeVecesQueAbsorbioVida >= 8);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return new CellPerfecto(cantidadDeVecesQueAbsorbioVida);
	}
	
	public void incrementarCantidadDeVecesQueAbsorbioVida() {
		cantidadDeVecesQueAbsorbioVida++;
	}
	
}
