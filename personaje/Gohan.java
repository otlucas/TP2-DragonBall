package personaje;

import personaje.estado.GohanNormal;

public class Gohan extends Personaje {

	public Gohan(){
		this.nombre = "Gohan";
		this.modo = new GohanNormal();
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.ki = 0;
		this.numeroDeTransformacion = 0;
		this.kiParaAtaqueEspecial = 10;

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
