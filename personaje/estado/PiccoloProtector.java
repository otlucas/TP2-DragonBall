package personaje.estado;

import tablero.Equipo;

public class PiccoloProtector extends Estado {

	public PiccoloProtector() {
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 6;
		this.velocidadDeDesplazamiento = 4;
		this.kiParaTransformarse = 0;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return false;
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		throw new UltimaTransformacionAlcanzada();
	}
	
}
