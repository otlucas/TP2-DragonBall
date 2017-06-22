package personaje.estado;

import tablero.Equipo;

public class FreezerDefinitivo extends Estado {

	public FreezerDefinitivo() {
		this.poderDePelea = 50;
		this.distanciaDeAtaque = 3;
		this.velocidadDeDesplazamiento = 6;
		this.kiParaTransformarse = 0;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return false;
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		throw new UltimaTransformacionAlcanzada();
	}
	
}
