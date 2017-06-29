package personaje.estado;

import tablero.Equipo;

public class GokuKaioKen extends Estado {
	
	private Estado estadoSiguiente;
	
	public GokuKaioKen() {
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 3;
		this.estadoSiguiente = new GokuSuperSayajin();
		this.kiParaTransformarse = 50;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}

	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		return estadoSiguiente;
	}
	
}
