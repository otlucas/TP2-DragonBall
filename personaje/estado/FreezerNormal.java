package personaje.estado;

import tablero.Equipo;

public class FreezerNormal extends Estado {

	private Estado estadoSiguiente;
	
	public FreezerNormal() {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 4;
		this.estadoSiguiente = new FreezerSegundaForma();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 20);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 20;
		return estadoSiguiente;
	}
	
}
