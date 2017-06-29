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
		this.kiParaAtaqueEspecial = 10;
		this.cantidadDeMovimientos = modo.getVelocidadDeDesplazamiento();
		this.cantidadDeAtaques = 1;
	}

	public boolean puedeEfectuarAtaqueEspecial() {
		return (ki >= kiParaAtaqueEspecial);
	}

	public int ejecutarAtaqueEspecial(int danio) {
		danio = danio + (int)(0.25*danio);
		ki = ki - kiParaAtaqueEspecial;
		return danio;
	}

}