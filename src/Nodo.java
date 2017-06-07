package tablero;

public class Nodo {
	
	Nodo Padre;
	Casillero actual;
	double valorG; //ValorG es el costo que tiene llegar a este nodo desde el nodo partida
	double valorH; //ValorH es la distancia que tiene este nodo al nodo destino (el modulo de la resta de sus coordenadas)
	
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
