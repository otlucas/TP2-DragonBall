package personaje.estado;

import tablero.Equipo;

public class FreezerSegundaForma extends Estado {

	private Estado estadoSiguiente;
	
	public FreezerSegundaForma() {
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 3;
		this.velocidadDeDesplazamiento = 4;
		this.estadoSiguiente = new FreezerDefinitivo();
		this.kiParaTransformarse = 50;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
