package personaje.estado;

import tablero.Equipo;

public class GokuNormal extends Estado {
	
	private Estado estadoSiguiente;
	
	public GokuNormal() {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new GokuKaioKen();
		this.kiParaTransformarse = 20;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
