package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.Goku;

public class GokuTests {
	
	protected Goku testGoku = new Goku();
	
	@Test
	public void test01ObtenerPoderDePelea() {
		
		assertTrue(testGoku.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida() {
		
		assertTrue(testGoku.getPuntosDeVida() == 500);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		assertTrue(testGoku.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		
		assertTrue(testGoku.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testGoku.perderPuntosDeVida(140);
		
		assertTrue(testGoku.getPuntosDeVida() == 360);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testGoku.perderPuntosDeVida(140);
		testGoku.ganarPuntosDeVida(50);
		
		assertTrue(testGoku.getPuntosDeVida() == 410);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		
		assertFalse(testGoku.puedeTransformarse());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){

		assertFalse(testGoku.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		for (int i = 0; i<5; i++)
			testGoku.ganarKi();
		
		assertTrue(testGoku.puedeTransformarse());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		for (int i = 0; i<8; i++)
			testGoku.ganarKi();
		
		assertTrue(testGoku.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test11LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<20; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		
		assertTrue(testGoku.puedeTransformarse());
	}
	
	@Test
	public void test12EfectuarPrimeraTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		
		assertTrue(testGoku.getPoderDePelea() == 40);
	}
	
	@Test
	public void test13EfectuarPrimeraTransformacionNoCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		
		assertTrue((testGoku.getVelocidadDeDesplazamiento() == 3) && (testGoku.getdistanciaDeAtaque() == 4));
	}
	
	@Test
	public void test14EfectuarSegundaTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		testGoku.transformarse();
		
		assertTrue(testGoku.getPoderDePelea() == 60);
	}
	
	@Test
	public void test15EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		testGoku.transformarse();
		
		assertTrue(testGoku.getVelocidadDeDesplazamiento() == 5);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		testGoku.transformarse();
		
		assertTrue(testGoku.getdistanciaDeAtaque() == 4);
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test17UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		testGoku = new Goku();
		testGoku.transformarse();
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test18UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		testGoku.transformarse();
	}
	
	@Test 
	public void test19SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		
		assertTrue((testGoku.getPoderDePelea() == 40) && (testGoku.getVelocidadDeDesplazamiento() == 3) && (testGoku.getdistanciaDeAtaque() == 4));
	}
	
	@Test 
	public void test20SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			testGoku.ganarKi();
		testGoku.transformarse();
		testGoku.transformarse();
		
		assertTrue((testGoku.getPoderDePelea() == 60) && (testGoku.getVelocidadDeDesplazamiento() == 5));
	}
}

