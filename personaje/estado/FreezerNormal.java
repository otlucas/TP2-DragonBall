package personaje.estado;

import tablero.Equipo;

public class FreezerNormal extends Estado {

	private Estado estadoSiguiente;
	
	public FreezerNormal() {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 4;
		this.estadoSiguiente = new FreezerSegundaForma();
		this.kiParaTransformarse = 20;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
