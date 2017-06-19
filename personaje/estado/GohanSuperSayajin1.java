package personaje.estado;

import tablero.Equipo;

public class GohanSuperSayajin1 extends Estado {
	
	private Estado estadoSiguiente;
	
	public GohanSuperSayajin1(){
		this.poderDePelea = 30;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new GohanSuperSayajin2();
	}
	
	public boolean puedeTransformarse(int ki, Equipo equipo) {
		int puntosDeVidaMaximosDeGoku = equipo.getIntegrantes().get("Goku").getPuntosDeVidaMaximos();
		int puntosDeVidaActualDeGoku = equipo.getIntegrantes().get("Goku").getPuntosDeVida();
		int puntosDeVidaMaximosDePiccolo = equipo.getIntegrantes().get("Piccolo").getPuntosDeVidaMaximos();
		int puntosDeVidaActualDePiccolo = equipo.getIntegrantes().get("Piccolo").getPuntosDeVida();
		return ((ki >= 30) && (puntosDeVidaActualDeGoku < 0.3*puntosDeVidaMaximosDeGoku) && (puntosDeVidaActualDePiccolo < 0.3*puntosDeVidaMaximosDePiccolo));
	}
	
	public Estado transformarse(int ki) {
		ki = ki - 30;
		return estadoSiguiente;
	}
	
}
