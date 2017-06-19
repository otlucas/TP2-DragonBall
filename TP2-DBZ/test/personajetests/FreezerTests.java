package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.Freezer;

public class FreezerTests {
	
	private Freezer testFreezer = new Freezer();
	
	@Test
	public void test01ObtenerPoderDePelea(){
		
		assertTrue(testFreezer.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida(){
		
		assertTrue(testFreezer.getPuntosDeVida() == 400);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		assertTrue(testFreezer.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		
		assertTrue(testFreezer.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testFreezer.perderPuntosDeVida(140);
		
		assertTrue(testFreezer.getPuntosDeVida() == 260);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testFreezer.perderPuntosDeVida(140);
		testFreezer.ganarPuntosDeVida(50);
		
		assertTrue(testFreezer.getPuntosDeVida() == 310);		
	}
	
	@Test
	public void test07PuedeTransformarseInicialmenteDaFalse(){
		
		assertFalse(testFreezer.puedeTransformarse());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		
		assertFalse(testFreezer.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09LuegoDeVariosTurnosTransformarseEsTrue(){
		for (int i = 0; i<5; i++)
			testFreezer.ganarKi();
		
		assertTrue(testFreezer.puedeTransformarse());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){

		for (int i = 0; i<8; i++)
			testFreezer.ganarKi();
		
		assertTrue(testFreezer.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test11LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<20; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		
		assertTrue(testFreezer.puedeTransformarse());
	}
	
	@Test
	public void test12EfectuarPrimeraTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<8; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		
		assertTrue(testFreezer.getPoderDePelea() == 40);
	}
	
	@Test
	public void test13EfectuarPrimeraTransformacionCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<8; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		
		assertTrue(testFreezer.getdistanciaDeAtaque() == 3);
	}
	
	@Test
	public void test14EfectuarSegundaTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		testFreezer.transformarse();
		
		assertTrue(testFreezer.getPoderDePelea() == 50);
	}
	
	@Test
	public void test15EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		testFreezer.transformarse();
		
		assertTrue(testFreezer.getVelocidadDeDesplazamiento() == 6);
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test16UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{

		testFreezer.transformarse();
	}
	
	@Test 
	public void test17SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		
		assertTrue((testFreezer.getPoderDePelea() == 40) && (testFreezer.getdistanciaDeAtaque() == 3));
	}
	
	@Test 
	public void test18SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<25; i++)
			testFreezer.ganarKi();
		testFreezer.transformarse();
		testFreezer.transformarse();
		
		assertTrue((testFreezer.getPoderDePelea() == 50) && (testFreezer.getVelocidadDeDesplazamiento() == 6) && (testFreezer.getdistanciaDeAtaque() == 3));
	}

}
