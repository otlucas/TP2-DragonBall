package tp2Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp2.Casillero;

public class CasilleroTests {
	
	@Test
	public void test01CrearCasilleroYChequearQueEstaLibre(){
		
		Casillero casillero = new Casillero(2,4);
		
		assertFalse(casillero.estaOcupado());
	}
	
	@Test
	public void test02ObtenerCoordenadaXDelCasillero(){
		
		Casillero casillero = new Casillero(2,4);
		
		assertTrue(casillero.getX() == 2);
		
	}
	
	@Test
	public void test03ObtenerCoordenadaYDelCasillero(){
		
		Casillero casillero = new Casillero (2,4);
		
		assertTrue(casillero.getY() == 4);
	}
	
	@Test
	public void test04CambiarElEstadoDeUnCasillero(){
		
		Casillero casillero = new Casillero (5,4);
		
		casillero.cambiarEstado();
		
		assertTrue(casillero.estaOcupado());
	}
	
	@Test
	public void test05CompararCasillerosIguales(){
		
		Casillero casillero1 = new Casillero (5,5);
		Casillero casillero2 = new Casillero (5,5);
		
		assertTrue(casillero1.equals(casillero2));
	}
	
	@Test
	public void test06CompararCasillerosDistintos(){
		
		Casillero casillero1 = new Casillero (5,5);
		Casillero casillero2 = new Casillero (6,5);
		
		assertFalse(casillero1.equals(casillero2));
	}

}
