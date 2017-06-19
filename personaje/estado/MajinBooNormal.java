package personaje.estado;

import tablero.Equipo;

public class MajinBooNormal extends Estado {

	private Estado estadoSiguiente;
	
	public MajinBooNormal() {
		this.poderDePelea = 30;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new MajinBooMalo();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 20);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 20;
		return estadoSiguiente;
	}
	
}
