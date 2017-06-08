package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.Cell;
import personaje.CondicionesInsuficientes;

public class CellTests {

	protected Cell testCell;
	
	@Test
	public void test01ObtenerPoderDePelea() {
		
		testCell = new Cell();
		
		assertTrue(testCell.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida() {
		
		testCell = new Cell();
		
		assertTrue(testCell.obtenerPuntosDeVida() == 500);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		testCell = new Cell();
		
		assertTrue(testCell.getdistanciaDeAtaque() == 3);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		
		testCell = new Cell();
		
		assertTrue(testCell.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testCell = new Cell();
		testCell.perderPuntosDeVida(140);
		
		assertTrue(testCell.obtenerPuntosDeVida() == 360);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testCell = new Cell();
		testCell.perderPuntosDeVida(140);
		testCell.ganarPuntosDeVida(50);
		
		assertTrue(testCell.obtenerPuntosDeVida() == 410);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		testCell = new Cell();
		
		assertFalse(testCell.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		testCell = new Cell();
		
		assertFalse(testCell.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09PuedeEfectuarSegundaTransformacionInicialmenteDaFalse(){
		testCell = new Cell();
		
		assertFalse(testCell.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		testCell = new Cell();
		for (int i = 0; i<5; i++)
			testCell.ganarKi();

		assertTrue(testCell.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test11LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		testCell = new Cell();
		for (int i = 0; i<20; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		assertTrue(testCell.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test12SinEfectuarPrimeraTransformacionNoPuedeEfectuarSegunda(){
		testCell = new Cell();
		for (int i = 0; i<20; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		
		assertFalse(testCell.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test13LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue(){
		testCell = new Cell();
		for (int i = 0; i<20; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarPrimeraTransformacion();
		
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		assertTrue(testCell.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioPoderDePelea(){
		testCell = new Cell();
		for (int i = 0; i<8; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarPrimeraTransformacion();
		
		assertTrue(testCell.getPoderDePelea() == 40);
	}
	
	@Test
	public void test15EfectuarPrimeraTransformacionNoCambioVelocidadDeDesplazamiento(){
		testCell = new Cell();
		for (int i = 0; i<8; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarPrimeraTransformacion();
		
		assertTrue((testCell.getVelocidadDeDesplazamiento() == 3) && (testCell.getdistanciaDeAtaque() == 4));
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioPoderDePelea(){
		testCell = new Cell();
		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarPrimeraTransformacion();
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarSegundaTransformacion();
		
		assertTrue(testCell.getPoderDePelea() == 80);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento(){
		testCell = new Cell();
		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarPrimeraTransformacion();
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarSegundaTransformacion();
		
		assertTrue(testCell.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test18EfectuarSegundaTransformacionNoCambioDistanciaDeAtaque(){
		testCell = new Cell();
		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarPrimeraTransformacion();
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.efectuarSegundaTransformacion();
		
		assertTrue(testCell.getdistanciaDeAtaque() == 4);
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test19UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		testCell = new Cell();
		testCell.usarPrimeraTransformacion();
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test20UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		testCell = new Cell();
		testCell.usarSegundaTransformacion();
	}
	
	@Test 
	public void test21SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		testCell = new Cell();
		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.usarPrimeraTransformacion();
		
		assertTrue((testCell.getPoderDePelea() == 40) && (testCell.getVelocidadDeDesplazamiento() == 3) && (testCell.getdistanciaDeAtaque() == 4));
	}
	
	@Test 
	public void test22SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		testCell = new Cell();
		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		testCell.usarPrimeraTransformacion();
		testCell.usarSegundaTransformacion();
		
		assertTrue((testCell.getPoderDePelea() == 80) && (testCell.getVelocidadDeDesplazamiento() == 4));
	}
	
	@Test
	public void test23EfectuarAtaqueEspecialAumentaPuntosDeVida(){
		testCell = new Cell();
		for (int i = 0; i<5; i++)
			testCell.ganarKi();
		
		testCell.perderPuntosDeVida(50);

		assertTrue(testCell.obtenerPuntosDeVida() == 450);
		
		testCell.ejecutarAtaqueEspecial(50);
		
		assertTrue(testCell.obtenerPuntosDeVida() == 500);
	}
}

