package personaje.estado;

import tablero.Equipo;

public class FreezerSegundaForma extends Estado {

	private Estado estadoSiguiente;
	
	public FreezerSegundaForma() {
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 3;
		this.velocidadDeDesplazamiento = 4;
		this.estadoSiguiente = new FreezerDefinitivo();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 50);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 50;
		return estadoSiguiente;
	}
	
}
