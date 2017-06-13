package tablero;

import posicionable.Posicionable;

public class Casillero {

	private int x, y;
	private Posicionable posicionable;
	
	public Casillero(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean estaOcupado(){
		return ((posicionable != null) && (posicionable.ocupaEspacio()));
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}

	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}

	public boolean estaEnRango(int rango, Casillero destino){
		for (int x = this.x-rango; x <= this.x+rango; x++) {
			for (int y = this.y-rango; y <= this.y+rango; y++) {

				if(destino.getX() == x && destino.getY() == y){
					return true;
				}
			}
		}
		return false;
	}

	public boolean equals(Casillero casillero){
		return ((casillero.getX()==this.x) && (casillero.getY()==this.y));
	}
}