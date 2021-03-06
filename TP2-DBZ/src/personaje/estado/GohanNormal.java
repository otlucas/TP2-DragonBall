package personaje.estado;

import tablero.Equipo;

public class GohanNormal extends Estado {
	
	private Estado estadoSiguiente;
	
	public GohanNormal() {
		this.poderDePelea = 15;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.estadoSiguiente = new GohanSuperSayajin1();
		this.kiParaTransformarse = 10;
	}

	public boolean puedeTransformarse(int ki, Equipo equipo) {
		return (ki >= kiParaTransformarse);
	}
	
	public Estado transformarse() {
		return estadoSiguiente;
	}

}
