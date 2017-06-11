package personaje;

public class PrimeraTransformacion implements Estado {
	
	public int getPoderDePelea(Personaje personaje) {
		return personaje.poderDePeleaPT;
	}

	public int getDistanciaDeAtaque(Personaje personaje) {
		return personaje.distanciaDeAtaquePT;
	}
	
	public int getVelocidadDeDesplazamiento(Personaje personaje) {
		return personaje.velocidadDeDesplazamientoPT;
	}
}
