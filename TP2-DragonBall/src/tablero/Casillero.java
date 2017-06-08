package tablero;

public class Casillero {
	
	private boolean ocupado = false;
	private int x, y;
	
	public Casillero(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean estaOcupado(){
		return (ocupado==true);
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void cambiarEstado(){
		if (!ocupado)
			ocupado = true;
		else
			ocupado = false;
	}
	public boolean equals(Casillero casillero){
		return ((casillero.getX()==this.x) && (casillero.getY()==this.y));
	}

}
