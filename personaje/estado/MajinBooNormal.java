package personaje.estado;

import tablero.Equipo;

public class MajinBooNormal extends Estado {

	private Estado estadoSiguiente;
	
	public MajinBooNormal() {
		this.poderDePelea = 30;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new MajinBooMalo();
		this.kiParaTransformarse = 20;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
