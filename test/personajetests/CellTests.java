package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.Cell;

public class CellTests {
	
	private Cell testCell = new Cell();
	
	@Test
	public void test01ObtenerPoderDePelea() {
		
		assertTrue(testCell.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida() {
		
		assertTrue(testCell.getPuntosDeVida() == 500);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		assertTrue(testCell.getdistanciaDeAtaque() == 3);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		
		assertTrue(testCell.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testCell.perderPuntosDeVida(140);
		
		assertTrue(testCell.getPuntosDeVida() == 360);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testCell.perderPuntosDeVida(140);
		testCell.ganarPuntosDeVida(50);
		
		assertTrue(testCell.getPuntosDeVida() == 410);		
	}
	
	@Test
	public void test07PuedeTransformarseInicialmenteDaFalse(){

		assertFalse(testCell.puedeTransformarse());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		
		assertFalse(testCell.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){

		for (int i = 0; i<5; i++)
			testCell.ganarKi();

		assertTrue(testCell.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPoderTransformarseEsTrue(){

		for (int i = 0; i<20; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<5; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		assertTrue(testCell.puedeTransformarse());
	}
	
	@Test
	public void test11LuegoDeTransformarseUnaVezPoderEfectuarOtraTransformacionEsTrue() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<20; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		assertTrue(testCell.puedeTransformarse());
	}
	
	@Test
	public void test12EfectuarPrimeraTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<8; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		assertTrue(testCell.getPoderDePelea() == 40);
	}
	
	@Test
	public void test13EfectuarPrimeraTransformacionNoCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		
		for (int i = 0; i<8; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		assertTrue((testCell.getVelocidadDeDesplazamiento() == 3) && (testCell.getdistanciaDeAtaque() == 4));
	}
	
	@Test
	public void test14EfectuarSegundaTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		
		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		for (int i = 0; i<10; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		System.out.println(testCell.getPoderDePelea());
		assertTrue(testCell.getPoderDePelea() == 80);
	}
	
	@Test
	public void test15EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		assertTrue(testCell.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionNoCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		for (int i = 0; i<8; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		assertTrue(testCell.getdistanciaDeAtaque() == 4);
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test17UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		
		testCell.transformarse();
	}
	
	@Test 
	public void test18SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		
		for (int i = 0; i<4; i++)
			testCell.ejecutarAtaqueEspecial(0);
		
		testCell.transformarse();
		
		assertTrue((testCell.getPoderDePelea() == 40) && (testCell.getVelocidadDeDesplazamiento() == 3) && (testCell.getdistanciaDeAtaque() == 4));
	}
	
	@Test 
	public void test19SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testCell.ganarKi();
		for (int i = 0; i<9; i++)
			testCell.ejecutarAtaqueEspecial(0);
		testCell.transformarse();
		testCell.transformarse();
		
		assertTrue((testCell.getPoderDePelea() == 80) && (testCell.getVelocidadDeDesplazamiento() == 4));
	}
	
	@Test
	public void test20EfectuarAtaqueEspecialAumentaPuntosDeVida(){
		
		for (int i = 0; i<5; i++)
			testCell.ganarKi();
		
		testCell.perderPuntosDeVida(50);

		assertTrue(testCell.getPuntosDeVida() == 450);
		
		testCell.ejecutarAtaqueEspecial(50);
		
		assertTrue(testCell.getPuntosDeVida() == 500);
	}
}

