package personaje.estado;

import tablero.Equipo;

public class PiccoloFortalecido extends Estado {

	private Estado estadoSiguiente;
	
	public PiccoloFortalecido() {
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 3;
		this.estadoSiguiente = new PiccoloProtector();
		this.kiParaTransformarse = 0;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		int puntosDeVidaMaximosDeGohan = equipo.getIntegrantes().get("Gohan").getPuntosDeVidaMaximos();
		int puntosDeVidaActualDeGohan = equipo.getIntegrantes().get("Gohan").getPuntosDeVida();
		return (puntosDeVidaActualDeGohan < (0.2*puntosDeVidaMaximosDeGohan));
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
