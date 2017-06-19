package personaje.estado;

import tablero.Equipo;

public class MajinBooOriginal extends Estado {

	public MajinBooOriginal() {
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 3;
		this.velocidadDeDesplazamiento = 4;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return false;
	}

	public Estado transformarse(int ki) throws UltimaTransformacionAlcanzada {
		throw new UltimaTransformacionAlcanzada();
	}
	
}
