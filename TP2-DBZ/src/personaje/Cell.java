package personaje;

import personaje.estado.CellNormal;

public class Cell extends Personaje {

	private int cantidadDeVecesQueAbsorbioVida = 0;

	public Cell() {
		this.nombre = "Cell";
		this.modo = new CellNormal(cantidadDeVecesQueAbsorbioVida);
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.ki = 0;
		this.numeroDeTransformacion = 0;
	}

	public boolean puedeEfectuarAtaqueEspecial() {
		return (ki >= 5);
	}

	public int ejecutarAtaqueEspecial(int danio) {
		this.ganarPuntosDeVida(danio);
		ki = ki - 5;
		modo.incrementarCantidadDeVecesQueAbsorbioVida();
		return danio;
	}

}