package personaje;

public class SegundaTransformacion implements Estado {
	
	public int getPoderDePelea(Personaje personaje) {
		return personaje.poderDePeleaST;
	}

	public int getDistanciaDeAtaque(Personaje personaje) {
		return personaje.distanciaDeAtaqueST;
	}
	
	public int getVelocidadDeDesplazamiento(Personaje personaje) {
		return personaje.velocidadDeDesplazamientoST;
	}
}
