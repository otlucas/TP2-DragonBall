package personaje.estado;

import tablero.Equipo;

public class MajinBooMalo extends Estado {

	private Estado estadoSiguiente;
	
	public MajinBooMalo() {
		this.poderDePelea = 50;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 3;
		this.estadoSiguiente = new MajinBooOriginal();
		this.kiParaTransformarse = 50;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
