package personaje.estado;

import tablero.Equipo;

public class PiccoloNormal extends Estado {
	
	private Estado estadoSiguiente;
	
	public PiccoloNormal() {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new PiccoloFortalecido();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 20);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 20;
		return estadoSiguiente;
	}
	
}
