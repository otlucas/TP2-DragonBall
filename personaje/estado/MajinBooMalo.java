package personaje.estado;

import tablero.Equipo;

public class MajinBooMalo extends Estado {

	private Estado estadoSiguiente;
	
	public MajinBooMalo() {
		this.poderDePelea = 50;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 3;
		this.estadoSiguiente = new MajinBooOriginal();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 50);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 50;
		return estadoSiguiente;
	}
	
}
