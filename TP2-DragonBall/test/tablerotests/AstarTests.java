package tablerotests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import tablero.Casillero;
import tablero.MovimientoNoValido;
import tablero.Tablero;

public class AstarTests {
	
	@Test
    public void testAStarDimension3y2Obstaculos() throws MovimientoNoValido {

        Tablero tablero = new Tablero(3, null, null, null);
        
        tablero.tablero.get(0).get(1).cambiarEstado();
        tablero.tablero.get(1).get(1).cambiarEstado();
        ArrayList<Casillero> caminoCasillerosEsperado = new ArrayList<Casillero>();
        caminoCasillerosEsperado.add(tablero.tablero.get(0).get(2));
        caminoCasillerosEsperado.add(tablero.tablero.get(1).get(2));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(1));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(0));
        
		ArrayList<Casillero> caminoCasilleros = tablero.AStar(tablero.tablero.get(0).get(2), tablero.tablero.get(2).get(0));
		assertEquals(true, caminoCasilleros.size() == caminoCasillerosEsperado.size());
		for(int x = 0; x < caminoCasilleros.size(); x++){
			assertEquals(true, caminoCasilleros.get(x).getX() == caminoCasillerosEsperado.get(x).getX());
			assertEquals(true, caminoCasilleros.get(x).getY() == caminoCasillerosEsperado.get(x).getY());
		}
        
        
    }
	
	@Test
    public void testAStarDimension4y3Obstaculos() throws MovimientoNoValido {

        Tablero tablero = new Tablero(4, null, null, null);
        
        tablero.tablero.get(0).get(2).cambiarEstado();
        tablero.tablero.get(2).get(2).cambiarEstado();
        tablero.tablero.get(3).get(2).cambiarEstado();
        ArrayList<Casillero> caminoCasillerosEsperado = new ArrayList<Casillero>();
        caminoCasillerosEsperado.add(tablero.tablero.get(0).get(3));
        caminoCasillerosEsperado.add(tablero.tablero.get(1).get(2));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(1));
        caminoCasillerosEsperado.add(tablero.tablero.get(3).get(0));
        
		ArrayList<Casillero> caminoCasilleros = tablero.AStar(tablero.tablero.get(0).get(3), tablero.tablero.get(3).get(0));
		assertEquals(true, caminoCasilleros.size() == caminoCasillerosEsperado.size());
		for(int x = 0; x < caminoCasilleros.size(); x++){
			assertEquals(true, caminoCasilleros.get(x).getX() == caminoCasillerosEsperado.get(x).getX());
			assertEquals(true, caminoCasilleros.get(x).getY() == caminoCasillerosEsperado.get(x).getY());
		}
        
        
    }
	
	@Test
    public void testAStarDimension8yMuchosObstaculos() throws MovimientoNoValido {

        Tablero tablero = new Tablero(8, null, null, null);
        
        tablero.tablero.get(0).get(3).cambiarEstado();
        tablero.tablero.get(1).get(3).cambiarEstado();
        tablero.tablero.get(1).get(5).cambiarEstado();
        tablero.tablero.get(2).get(1).cambiarEstado();
        tablero.tablero.get(2).get(5).cambiarEstado();
        tablero.tablero.get(3).get(1).cambiarEstado();
        tablero.tablero.get(3).get(2).cambiarEstado();
        tablero.tablero.get(3).get(3).cambiarEstado();
        tablero.tablero.get(3).get(5).cambiarEstado();
        tablero.tablero.get(3).get(7).cambiarEstado();
        tablero.tablero.get(4).get(2).cambiarEstado();
        tablero.tablero.get(4).get(3).cambiarEstado();
        tablero.tablero.get(4).get(5).cambiarEstado();
        tablero.tablero.get(5).get(1).cambiarEstado();
        tablero.tablero.get(5).get(2).cambiarEstado();
        tablero.tablero.get(5).get(3).cambiarEstado();
        tablero.tablero.get(5).get(4).cambiarEstado();
        tablero.tablero.get(5).get(5).cambiarEstado();
        tablero.tablero.get(5).get(7).cambiarEstado();
        tablero.tablero.get(6).get(1).cambiarEstado();
        tablero.tablero.get(6).get(4).cambiarEstado();
        tablero.tablero.get(6).get(5).cambiarEstado();
        tablero.tablero.get(7).get(1).cambiarEstado();
        ArrayList<Casillero> caminoCasillerosEsperado = new ArrayList<Casillero>();
        caminoCasillerosEsperado.add(tablero.tablero.get(0).get(6));
        caminoCasillerosEsperado.add(tablero.tablero.get(0).get(5));
        caminoCasillerosEsperado.add(tablero.tablero.get(1).get(4));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(3));
        caminoCasillerosEsperado.add(tablero.tablero.get(1).get(2));
        caminoCasillerosEsperado.add(tablero.tablero.get(1).get(1));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(0));
        caminoCasillerosEsperado.add(tablero.tablero.get(3).get(0));
        caminoCasillerosEsperado.add(tablero.tablero.get(4).get(0));
        caminoCasillerosEsperado.add(tablero.tablero.get(5).get(0));
        caminoCasillerosEsperado.add(tablero.tablero.get(6).get(0));
        caminoCasillerosEsperado.add(tablero.tablero.get(7).get(0));
        
		ArrayList<Casillero> caminoCasilleros = tablero.AStar(tablero.tablero.get(0).get(6), tablero.tablero.get(7).get(0));
		assertEquals(true, caminoCasilleros.size() == caminoCasillerosEsperado.size());
		for(int x = 0; x < caminoCasilleros.size(); x++){
			assertEquals(true, caminoCasilleros.get(x).getX() == caminoCasillerosEsperado.get(x).getX());
			assertEquals(true, caminoCasilleros.get(x).getY() == caminoCasillerosEsperado.get(x).getY());
		}
        
        
    }
	
	@Test(expected=MovimientoNoValido.class)
    public void testAStarDimension3yMovimientoNoValido() throws MovimientoNoValido {

        Tablero tablero = new Tablero(3, null, null, null);
        
        tablero.tablero.get(0).get(1).cambiarEstado();
        tablero.tablero.get(1).get(1).cambiarEstado();
        tablero.tablero.get(2).get(1).cambiarEstado();
        ArrayList<Casillero> caminoCasillerosEsperado = new ArrayList<Casillero>();
        caminoCasillerosEsperado.add(tablero.tablero.get(0).get(2));
        caminoCasillerosEsperado.add(tablero.tablero.get(1).get(2));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(1));
        caminoCasillerosEsperado.add(tablero.tablero.get(2).get(0));
        
		ArrayList<Casillero> caminoCasilleros = tablero.AStar(tablero.tablero.get(0).get(2), tablero.tablero.get(2).get(0));
		assertEquals(true, caminoCasilleros.size() == caminoCasillerosEsperado.size());
		for(int x = 0; x < caminoCasilleros.size(); x++){
			assertEquals(true, caminoCasilleros.get(x).getX() == caminoCasillerosEsperado.get(x).getX());
			assertEquals(true, caminoCasilleros.get(x).getY() == caminoCasillerosEsperado.get(x).getY());
		}
        
        
    }
	
	@Test(expected=MovimientoNoValido.class)
    public void testAStarDimension8yMovimientoNoValido() throws MovimientoNoValido {

        Tablero tablero = new Tablero(8, null, null, null);
        
        tablero.tablero.get(0).get(3).cambiarEstado();
        tablero.tablero.get(1).get(3).cambiarEstado();
        tablero.tablero.get(2).get(3).cambiarEstado();
        tablero.tablero.get(3).get(3).cambiarEstado();
        tablero.tablero.get(4).get(3).cambiarEstado();
        tablero.tablero.get(5).get(3).cambiarEstado();
        tablero.tablero.get(6).get(3).cambiarEstado();
        tablero.tablero.get(7).get(3).cambiarEstado();
        
        
        ArrayList<Casillero> caminoCasillerosEsperado = new ArrayList<Casillero>();
        
		ArrayList<Casillero> caminoCasilleros = tablero.AStar(tablero.tablero.get(0).get(6), tablero.tablero.get(7).get(0));
		assertEquals(true, caminoCasilleros.size() == caminoCasillerosEsperado.size());
		for(int x = 0; x < caminoCasilleros.size(); x++){
			assertEquals(true, caminoCasilleros.get(x).getX() == caminoCasillerosEsperado.get(x).getX());
			assertEquals(true, caminoCasilleros.get(x).getY() == caminoCasillerosEsperado.get(x).getY());
		}
        
        
    }
	
	@Test(expected=MovimientoNoValido.class)
    public void testAStarDimension4yMovimientoNoValido() throws MovimientoNoValido {

        Tablero tablero = new Tablero(4, null, null, null);
        
        tablero.tablero.get(0).get(1).cambiarEstado();
        tablero.tablero.get(2).get(0).cambiarEstado();
        
        ArrayList<Casillero> caminoCasillerosEsperado = new ArrayList<Casillero>();
        
		ArrayList<Casillero> caminoCasilleros = tablero.AStar(tablero.tablero.get(0).get(2), tablero.tablero.get(2).get(0));
		assertEquals(true, caminoCasilleros.size() == caminoCasillerosEsperado.size());
		for(int x = 0; x < caminoCasilleros.size(); x++){
			assertEquals(true, caminoCasilleros.get(x).getX() == caminoCasillerosEsperado.get(x).getX());
			assertEquals(true, caminoCasilleros.get(x).getY() == caminoCasillerosEsperado.get(x).getY());
		}
        
        
    }

}
