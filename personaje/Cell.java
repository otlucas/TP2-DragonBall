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
		this.kiParaAtaqueEspecial = 5;
	}

	public boolean puedeEfectuarAtaqueEspecial() {
		return (ki >= kiParaAtaqueEspecial);
	}

	public int ejecutarAtaqueEspecial(int danio) {
		this.ganarPuntosDeVida(danio);
		ki = ki - kiParaAtaqueEspecial;
		modo.incrementarCantidadDeVecesQueAbsorbioVida();
		return danio;
	}

}