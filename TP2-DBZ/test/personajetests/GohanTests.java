package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.*;
import tablero.Equipo;

public class GohanTests {

	private Gohan testGohan = new Gohan();
	private Goku goku = new Goku();
	private Piccolo piccolo = new Piccolo();
	
	private Equipo e = new Equipo("Guerreros Z");
	
	@Test
	public void test01ObtenerPoderDePelea() {
		
		assertTrue(testGohan.getPoderDePelea() == 15);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida() {
		
		assertTrue(testGohan.getPuntosDeVida() == 300);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		assertTrue(testGohan.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		

		assertTrue(testGohan.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){

		testGohan.perderPuntosDeVida(140);
		
		assertTrue(testGohan.getPuntosDeVida() == 160);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testGohan.perderPuntosDeVida(140);
		testGohan.ganarPuntosDeVida(50);
		
		assertTrue(testGohan.getPuntosDeVida() == 210);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){

		assertFalse(testGohan.puedeTransformarse());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		
		assertFalse(testGohan.puedeEfectuarAtaqueEspecial());
	}
	
	
	@Test
	public void test09LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){

		for (int i = 0; i<5; i++)
			testGohan.ganarKi();
		
		assertTrue(testGohan.puedeTransformarse());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){

		for (int i = 0; i<8; i++)
			testGohan.ganarKi();
		
		assertTrue(testGohan.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test11LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsFalse() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(goku);
		e.agregarPersonaje(piccolo);
		testGohan.setEquipo(e);
		for (int i = 0; i<20; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		
		assertFalse(testGohan.puedeTransformarse());
	}
	
	@Test
	public void test12EfectuarPrimeraTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<8; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		
		assertTrue(testGohan.getPoderDePelea() == 30);
	}
	
	@Test
	public void test13EfectuarPrimeraTransformacionNoCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{

		for (int i = 0; i<8; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		
		assertTrue(testGohan.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test14EfectuarSegundaTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(goku);
		e.agregarPersonaje(piccolo);
		testGohan.setEquipo(e);
		goku.perderPuntosDeVida(400);
		piccolo.perderPuntosDeVida(400);
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		testGohan.transformarse();
		
		assertTrue(testGohan.getPoderDePelea() == 100);
	}
	
	@Test
	public void test15EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(goku);
		e.agregarPersonaje(piccolo);
		testGohan.setEquipo(e);
		goku.perderPuntosDeVida(400);
		piccolo.perderPuntosDeVida(400);
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		testGohan.transformarse();
		
		assertTrue(testGohan.getVelocidadDeDesplazamiento() == 3);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(goku);
		e.agregarPersonaje(piccolo);
		testGohan.setEquipo(e);
		goku.perderPuntosDeVida(400);
		piccolo.perderPuntosDeVida(400);
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		testGohan.transformarse();
		
		assertTrue(testGohan.getdistanciaDeAtaque() == 4);
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test19UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{

		testGohan.transformarse();
	}
	
	@Test 
	public void test17SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		testGohan = new Gohan();
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		
		assertTrue((testGohan.getPoderDePelea() == 30) && (testGohan.getVelocidadDeDesplazamiento() == 2));
	}
	
	@Test 
	public void test18SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		e.agregarPersonaje(goku);
		e.agregarPersonaje(piccolo);
		testGohan.setEquipo(e);
		goku.perderPuntosDeVida(400);
		piccolo.perderPuntosDeVida(400);
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.transformarse();
		testGohan.transformarse();
		
		assertTrue((testGohan.getPoderDePelea() == 100) && (testGohan.getVelocidadDeDesplazamiento() == 3) && (testGohan.getdistanciaDeAtaque() == 4));
	}
}
