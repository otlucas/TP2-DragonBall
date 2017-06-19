package personaje;

import personaje.estado.MajinBooNormal;

public class MajinBoo extends Personaje {
	
	public MajinBoo() {
		this.nombre = "MajinBoo";
		this.modo = new MajinBooNormal();
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.ki = 0;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 30);
	}
	
	public int ejecutarAtaqueEspecial(int danio){
		danio = 0;
		ki = ki-30;
		/*INUTILIZAR ENEMIGO*/
		return danio;
	}
	
}
