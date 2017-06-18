package personaje.estado;

import tablero.Equipo;

public class GokuKaioKen extends Estado {
	
	private Estado estadoSiguiente;
	
	public GokuKaioKen() {
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 3;
		this.estadoSiguiente = new GokuSuperSayajin();
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= 50);
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		ki = ki - 50;
		return estadoSiguiente;
	}
	
}
