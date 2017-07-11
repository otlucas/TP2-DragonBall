package personaje.estado;

import tablero.Equipo;

public class GokuSuperSayajin extends Estado {
	
	public GokuSuperSayajin() {
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 5;
		this.kiParaTransformarse = 0;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return false;
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		throw new UltimaTransformacionAlcanzada();
	}
	
}
