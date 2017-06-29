package personaje;

import personaje.estado.MajinBooNormal;

public class MajinBoo extends Personaje {

	public MajinBoo() {
		this.nombre = "MajinBoo";
		this.modo = new MajinBooNormal();
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.ki = 0;
		this.numeroDeTransformacion = 0;
		this.kiParaAtaqueEspecial = 30;
		this.cantidadDeMovimientos = modo.getVelocidadDeDesplazamiento();
		this.cantidadDeAtaques = 1;
	}

	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= kiParaAtaqueEspecial);
	}

	public int ejecutarAtaqueEspecial(int danio){
		danio = 0;
		ki = ki - kiParaAtaqueEspecial;
		return danio;
	}

}
