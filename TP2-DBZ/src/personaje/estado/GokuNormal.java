package personaje.estado;

import tablero.Equipo;

public class GokuNormal extends Estado {
	
	private Estado estadoSiguiente;
	
	public GokuNormal() {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new GokuKaioKen();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 20);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 20;
		return estadoSiguiente;
	}
	
}
