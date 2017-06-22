package personaje;

import personaje.estado.PiccoloNormal;

public class Piccolo extends Personaje {

	public Piccolo() {
		this.nombre = "Piccolo";
		this.modo = new PiccoloNormal();
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.ki = 0;
		this.numeroDeTransformacion = 0;
	}

	public boolean puedeEfectuarAtaqueEspecial() {
		return (ki >= 10);
	}

	public int ejecutarAtaqueEspecial(int danio) {
		danio = danio + (int)(0.25*danio);
		ki = ki - 10;
		return danio;
	}

}