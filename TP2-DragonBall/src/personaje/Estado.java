package personaje;

public interface Estado {
	
	public abstract int getPoderDePelea(Personaje personaje);
	public abstract int getDistanciaDeAtaque(Personaje personaje);
	public abstract int getVelocidadDeDesplazamiento(Personaje personaje);
	
}
