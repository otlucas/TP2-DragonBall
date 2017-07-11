package personaje;

import personaje.estado.GokuNormal;

public class Goku extends Personaje {

	public Goku() {
		this.nombre = "Goku";
		this.modo = new GokuNormal();
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.ki = 0;
		this.numeroDeTransformacion = 0;
		this.kiParaAtaqueEspecial = 20;

	}

	public boolean puedeEfectuarAtaqueEspecial() {
		return (ki >= kiParaAtaqueEspecial);
	}

	public int ejecutarAtaqueEspecial(int danio) {
		danio = danio + (int)(0.5*danio);
		ki = ki - kiParaAtaqueEspecial;
		return danio;
	}

	public double porcentajeDanio(){
		return this.puntosDeVida < (0.3 * this.puntosDeVidaMaximos) ? 1.2 : 1;
	}

	@Override
	public void atacarA(Personaje victima, boolean especial){
		double multiplicador =  victima.getPoderDePelea()>getPoderDePelea() ? 0.8 : 1;
		int danio = getPoderDePelea();
		if (especial)
			danio = ejecutarAtaqueEspecial(danio);
		victima.perderPuntosDeVida((int)(danio*multiplicador*this.porcentajeDanio()));
	}

}
