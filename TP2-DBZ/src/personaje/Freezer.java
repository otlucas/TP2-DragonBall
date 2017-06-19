package personaje;

import personaje.estado.FreezerNormal;

public class Freezer extends Personaje {
	
	public Freezer(){
		this.nombre = "Freezer";
		this.modo = new FreezerNormal();
		this.puntosDeVidaMaximos = 400;
		this.puntosDeVida = 400;
		this.ki = 0;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 20);
	}
	
	public int ejecutarAtaqueEspecial(int danio){
		danio = danio + (int)(0.5*danio);
		ki = ki - 20;
		return danio;
	}
	
}