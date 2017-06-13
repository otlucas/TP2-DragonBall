package personaje;

public class Normal implements Estado {

	public int getPoderDePelea(Personaje personaje){
		return personaje.poderDePeleaN;
	}

	public int getDistanciaDeAtaque(Personaje personaje){
		return personaje.distanciaDeAtaqueN;
	}
	
	public int getVelocidadDeDesplazamiento(Personaje personaje){
		return personaje.velocidadDeDesplazamientoN;
	}

}
