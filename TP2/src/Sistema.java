import java.util.*;

public class Sistema {
	
	
	
	public static void main(String[]args){
		
	}
	
	public ArrayList<Casillero> crearCasilleros(int dimension){
		ArrayList<Casillero> listaDeCasilleros = new ArrayList<Casillero>();
		for (int i=0; i<dimension; i++){
			for (int j=0; j<dimension; j++){
				Casillero casillero = new Casillero(i,j);
				listaDeCasilleros.add(casillero);
			}
		}
		return listaDeCasilleros;
	}
	
	public Tablero crearTablero(ArrayList<Casillero> listaDeCasilleros){
		Tablero tablero = new Tablero(listaDeCasilleros);
		return tablero;
	}
	
	public void crearPersonajesYUbicar(ArrayList<Casillero> listaDeCasilleros, Movimiento movimiento){
		for (Casillero c: listaDeCasilleros){
			int x = c.getX(), y = c.getY();
			if ((x == 0) && (y == 4))
				Personaje goku = new Goku(c, movimiento);
			if ((x == 0) && (y == 3))
				Personaje gohan = new Gohan(c, movimiento);
			if ((x == 0) && (y == 5))
				Personaje piccolo = new Piccolo(c, movimiento);
			if ((x == 10) && (y == 4))
				Personaje cell = new Cell(c, movimiento);
			if ((x == 10) && (y == 3))
				Personaje freezer = new Freezer(c, movimiento);
			if ((x == 10) && (y == 5))
				Personaje majinBoo = new MajinBoo(c, movimiento);
		}
		
	}
}
