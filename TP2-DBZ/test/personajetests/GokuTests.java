package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import posicionable.CondicionesInsuficientes;
import personaje.Goku;

public class GokuTests {
	
	protected Goku testGoku;
	
	@Test
	public void test01ObtenerPoderDePelea() {
		
		testGoku = new Goku();
		
		assertTrue(testGoku.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida() {
		
		testGoku = new Goku();
		
		assertTrue(testGoku.obtenerPuntosDeVida() == 500);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		testGoku = new Goku();
		
		assertTrue(testGoku.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		
		testGoku = new Goku();
		
		assertTrue(testGoku.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testGoku = new Goku();
		testGoku.perderPuntosDeVida(140);
		
		assertTrue(testGoku.obtenerPuntosDeVida() == 360);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testGoku = new Goku();
		testGoku.perderPuntosDeVida(140);
		testGoku.ganarPuntosDeVida(50);
		
		assertTrue(testGoku.obtenerPuntosDeVida() == 410);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		testGoku = new Goku();
		
		assertFalse(testGoku.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		testGoku = new Goku();
		
		assertFalse(testGoku.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09PuedeEfectuarSegundaTransformacionInicialmenteDaFalse(){
		testGoku = new Goku();
		
		assertFalse(testGoku.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		testGoku = new Goku();
		for (int i = 0; i<5; i++)
			testGoku.ganarKi();
		
		assertTrue(testGoku.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test11SinEfectuarPrimeraTransformacionNoPuedeEfectuarSegunda(){
		testGoku = new Goku();
		for (int i = 0; i<10; i++)
			testGoku.ganarKi();
		
		assertFalse(testGoku.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test12LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		testGoku = new Goku();
		for (int i = 0; i<8; i++)
			testGoku.ganarKi();
		
		assertTrue(testGoku.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test13LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue(){
		testGoku = new Goku();
		for (int i = 0; i<20; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		
		assertTrue(testGoku.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioPoderDePelea(){
		testGoku = new Goku();
		for (int i = 0; i<8; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		
		assertTrue(testGoku.getPoderDePelea() == 40);
	}
	
	@Test
	public void test15EfectuarPrimeraTransformacionNoCambioVelocidadDeDesplazamiento(){
		testGoku = new Goku();
		for (int i = 0; i<8; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		
		assertTrue((testGoku.getVelocidadDeDesplazamiento() == 3) && (testGoku.getdistanciaDeAtaque() == 4));
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioPoderDePelea(){
		testGoku = new Goku();
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		testGoku.efectuarSegundaTransformacion();
		
		assertTrue(testGoku.getPoderDePelea() == 60);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento(){
		testGoku = new Goku();
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		testGoku.efectuarSegundaTransformacion();
		
		assertTrue(testGoku.getVelocidadDeDesplazamiento() == 5);
	}
	
	@Test
	public void test18EfectuarSegundaTransformacionCambioDistanciaDeAtaque(){
		testGoku = new Goku();
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		testGoku.efectuarSegundaTransformacion();
		
		assertTrue(testGoku.getdistanciaDeAtaque() == 4);
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test19UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		testGoku = new Goku();
		testGoku.efectuarPrimeraTransformacion();
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test20UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		testGoku = new Goku();
		testGoku.efectuarSegundaTransformacion();
	}
	
	@Test 
	public void test21SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		testGoku = new Goku();
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		
		assertTrue((testGoku.getPoderDePelea() == 40) && (testGoku.getVelocidadDeDesplazamiento() == 3) && (testGoku.getdistanciaDeAtaque() == 4));
	}
	
	@Test 
	public void test22SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		testGoku = new Goku();
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.efectuarPrimeraTransformacion();
		testGoku.efectuarSegundaTransformacion();
		
		assertTrue((testGoku.getPoderDePelea() == 60) && (testGoku.getVelocidadDeDesplazamiento() == 5));
	}
}

