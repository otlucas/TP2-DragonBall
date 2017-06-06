import java.util.ArrayList;
import java.util.List;

public class Movimiento {
	
	public List<Casillero> obtenerCasillerosPosibles(int rango, Casillero casilleroActual, List<Casillero> listaDeCasilleros){
		List<Casillero> casillerosPosibles = new ArrayList<Casillero>();
		int x = casilleroActual.getX();
		int y = casilleroActual.getY();
		int xMin = x - rango;
		if (xMin < 0)
			xMin = 0;
		int xMax = x + rango;
		if (xMax > 10)
			xMax = 10;
		int yMin = y - rango;
		if (yMin < 0)
			yMin = 0;
		int yMax = y + rango;
		if (xMax > 10)
			xMax = 10;

		for (Casillero c: listaDeCasilleros){
			int coordX = c.getX();
			int coordY = c.getY();
			if ( (xMin < coordX) && (coordX < xMax) && (yMin < coordY) && (coordY < yMax) )
				casillerosPosibles.add(c);
		}
		return casillerosPosibles;
	}
}