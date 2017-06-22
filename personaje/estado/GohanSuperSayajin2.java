package personaje.estado;

import tablero.Equipo;

public class GohanSuperSayajin2 extends Estado {

	public GohanSuperSayajin2(){
		this.poderDePelea = 100;
		this.distanciaDeAtaque = 4;
		this.velocidadDeDesplazamiento = 3;
		this.kiParaTransformarse = 0;
	}
	
	public boolean puedeTransformarse(int ki, Equipo equipo){
		return false;
	}
	
	public Estado transformarse() throws UltimaTransformacionAlcanzada {
		throw new UltimaTransformacionAlcanzada();
	}
	
}
