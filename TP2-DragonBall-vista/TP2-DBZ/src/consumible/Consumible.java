package consumible;

import posicionable.Posicionable;

public abstract class Consumible implements Posicionable {
	
	protected int tipo;
	protected int cantidadDeTurnos;
	
	public int getTipo() {
		return tipo;
	}
	
	public Efecto getEfecto(int turno) {
		Efecto efecto = new Efecto((turno + cantidadDeTurnos), tipo);
		return efecto;
	}
	
	@Override
	public boolean esMovible() {
		return false;
	}
	
	@Override
	public boolean ocupaEspacio() {
		return false;
	}
}
