package tablero;

public class Nodo {
	
	Nodo Padre;
	Casillero actual;
	double valorG;
	double valorH;
	
	public Nodo(Nodo padre, Casillero actual, double valorG, double valorH){
		this.Padre = padre;
		this.actual = actual;
		this.valorG = valorG;
		this.valorH = valorH;
	}
	
	public Casillero devolverActual(){
		return this.actual;
	}
	
	public Nodo devolverPadre(){
		return this.Padre;
	}
	
	public double devolverValorG(){
		return this.valorG;
	}
	
	public double devolverValorH(){
		return this.valorH;
	}
}
