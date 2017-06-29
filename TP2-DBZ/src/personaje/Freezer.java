package personaje;

import personaje.estado.FreezerNormal;

public class Freezer extends Personaje {

	public Freezer(){
		this.nombre = "Freezer";
		this.modo = new FreezerNormal();
		this.puntosDeVidaMaximos = 400;
		this.puntosDeVida = 400;
		this.ki = 0;
		this.numeroDeTransformacion = 0;
		this.kiParaAtaqueEspecial = 20;
		this.cantidadDeMovimientos = modo.getVelocidadDeDesplazamiento();
		this.cantidadDeAtaques = 1;
	}

	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= kiParaAtaqueEspecial);
	}

	public int ejecutarAtaqueEspecial(int danio){
		danio = danio + (int)(0.5*danio);
		ki = ki - kiParaAtaqueEspecial;
		return danio;
	}

}