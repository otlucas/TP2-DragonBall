package personaje.estado;

import tablero.Equipo;

public class CellPerfecto extends Estado {
	
	private int cantidadDeVecesQueAbsorbioVida;
	
	public CellPerfecto(int cantidadDeVecesQueAbsorbioVida) {
		this.cantidadDeVecesQueAbsorbioVida = cantidadDeVecesQueAbsorbioVida;
		this.poderDePelea = 80;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 4;
		this.kiParaTransformarse = 0;
	}
	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return false;
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		throw new UltimaTransformacionAlcanzada();
	}
	
	public void incrementarCantidadDeVecesQueAbsorbioVida() {
		cantidadDeVecesQueAbsorbioVida++;
	}
	
}
