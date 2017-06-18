package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tablero.Equipo;
import personaje.Gohan;
import personaje.Piccolo;

public class PiccoloTests {
	
	private Piccolo testPiccolo = new Piccolo();
	private Gohan gohan = new Gohan();
	
	private Equipo e = new Equipo("Guerreros Z");
	
	@Test
	public void test01ObtenerPoderDePelea(){
		
		assertTrue(testPiccolo.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida(){

		assertTrue(testPiccolo.getPuntosDeVida() == 500);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){

		assertTrue(testPiccolo.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){

		assertTrue(testPiccolo.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testPiccolo.perderPuntosDeVida(140);
		
		assertTrue(testPiccolo.getPuntosDeVida() == 360);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testPiccolo.perderPuntosDeVida(140);
		testPiccolo.ganarPuntosDeVida(50);
		
		assertTrue(testPiccolo.getPuntosDeVida() == 410);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){

		assertFalse(testPiccolo.puedeTransformarse());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		
		assertFalse(testPiccolo.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		for (int i = 0; i<5; i++)
			testPiccolo.ganarKi();
		
		assertTrue(testPiccolo.puedeTransformarse());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		for (int i = 0; i<8; i++)
			testPiccolo.ganarKi();
		
		assertTrue(testPiccolo.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test11LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(gohan);
		testPiccolo.setEquipo(e);
		gohan.perderPuntosDeVida(250);
		for (int i = 0; i<20; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.puedeTransformarse());
	}
	
	@Test
	public void test12EfectuarPrimeraTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.getPoderDePelea() == 40);
	}
	
	@Test
	public void test13EfectuarPrimeraTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.getVelocidadDeDesplazamiento() == 3);
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.getdistanciaDeAtaque() == 4);
	}
	
	@Test
	public void test15EfectuarSegundaTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(gohan);
		testPiccolo.setEquipo(e);
		gohan.perderPuntosDeVida(250);
		for (int i = 0; i<25; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.getPoderDePelea() == 60);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(gohan);
		testPiccolo.setEquipo(e);
		gohan.perderPuntosDeVida(250);
		for (int i = 0; i<25; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(gohan);
		testPiccolo.setEquipo(e);
		gohan.perderPuntosDeVida(250);
		for (int i = 0; i<25; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		testPiccolo.transformarse();
		
		assertTrue(testPiccolo.getdistanciaDeAtaque() == 6);
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test18UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		testPiccolo.transformarse();
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test19UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		testPiccolo.transformarse();
	}
	
	@Test 
	public void test20SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		
		assertTrue((testPiccolo.getPoderDePelea() == 40) && (testPiccolo.getVelocidadDeDesplazamiento() == 3) && (testPiccolo.getdistanciaDeAtaque() == 4));
	}
	
	@Test 
	public void test21SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(gohan);
		testPiccolo.setEquipo(e);
		gohan.perderPuntosDeVida(250);
		for (int i = 0; i<25; i++)
			testPiccolo.ganarKi();
		testPiccolo.transformarse();
		testPiccolo.transformarse();
		
		assertTrue((testPiccolo.getPoderDePelea() == 60) && (testPiccolo.getVelocidadDeDesplazamiento() == 4) && (testPiccolo.getdistanciaDeAtaque() == 6));
	}



}
