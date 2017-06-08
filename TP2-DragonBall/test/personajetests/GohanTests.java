package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.CondicionesInsuficientes;
import personaje.Gohan;

public class GohanTests {

	protected Gohan testGohan;
	
	@Test
	public void test01ObtenerPoderDePelea() {
		
		testGohan = new Gohan();
		
		assertTrue(testGohan.getPoderDePelea() == 15);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida() {
		
		testGohan = new Gohan();
		
		assertTrue(testGohan.obtenerPuntosDeVida() == 300);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		
		testGohan = new Gohan();
		
		assertTrue(testGohan.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		
		testGohan = new Gohan();
		
		assertTrue(testGohan.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		testGohan = new Gohan();
		testGohan.perderPuntosDeVida(140);
		
		assertTrue(testGohan.obtenerPuntosDeVida() == 160);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		testGohan = new Gohan();
		testGohan.perderPuntosDeVida(140);
		testGohan.ganarPuntosDeVida(50);
		
		assertTrue(testGohan.obtenerPuntosDeVida() == 210);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		testGohan = new Gohan();
		
		assertFalse(testGohan.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		testGohan = new Gohan();
		
		assertFalse(testGohan.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09PuedeEfectuarSegundaTransformacionInicialmenteDaFalse(){
		testGohan = new Gohan();
		
		assertFalse(testGohan.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		testGohan = new Gohan();
		for (int i = 0; i<5; i++)
			testGohan.ganarKi();
		
		assertTrue(testGohan.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test11SinEfectuarPrimeraTransformacionNoPuedeEfectuarSegunda(){
		testGohan = new Gohan();
		for (int i = 0; i<10; i++)
			testGohan.ganarKi();
		
		assertFalse(testGohan.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test12LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		testGohan = new Gohan();
		for (int i = 0; i<8; i++)
			testGohan.ganarKi();
		
		assertTrue(testGohan.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test13LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue(){
		testGohan = new Gohan();
		for (int i = 0; i<20; i++)
			testGohan.ganarKi();
		testGohan.efectuarPrimeraTransformacion();
		
		assertTrue(testGohan.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioPoderDePelea(){
		testGohan = new Gohan();
		for (int i = 0; i<8; i++)
			testGohan.ganarKi();
		testGohan.efectuarPrimeraTransformacion();
		
		assertTrue(testGohan.getPoderDePelea() == 30);
	}
	
	@Test
	public void test15EfectuarPrimeraTransformacionNoCambioVelocidadDeDesplazamiento(){
		testGohan = new Gohan();
		for (int i = 0; i<8; i++)
			testGohan.ganarKi();
		testGohan.efectuarPrimeraTransformacion();
		
		assertTrue(testGohan.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioPoderDePelea(){
		testGohan = new Gohan();
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.efectuarPrimeraTransformacion();
		testGohan.efectuarSegundaTransformacion();
		
		assertTrue(testGohan.getPoderDePelea() == 100);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento(){
		testGohan = new Gohan();
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.efectuarPrimeraTransformacion();
		testGohan.efectuarSegundaTransformacion();
		
		assertTrue(testGohan.getVelocidadDeDesplazamiento() == 3);
	}
	
	@Test
	public void test18EfectuarSegundaTransformacionCambioDistanciaDeAtaque(){
		testGohan = new Gohan();
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.efectuarPrimeraTransformacion();
		testGohan.efectuarSegundaTransformacion();
		
		assertTrue(testGohan.getdistanciaDeAtaque() == 4);
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test19UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		testGohan = new Gohan();
		testGohan.usarPrimeraTransformacion();
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test20UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		testGohan = new Gohan();
		testGohan.usarSegundaTransformacion();
	}
	
	@Test 
	public void test21SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		testGohan = new Gohan();
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.usarPrimeraTransformacion();
		
		assertTrue((testGohan.getPoderDePelea() == 30) && (testGohan.getVelocidadDeDesplazamiento() == 2));
	}
	
	@Test 
	public void test22SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		testGohan = new Gohan();
		for (int i = 0; i<25; i++)
			testGohan.ganarKi();
		testGohan.usarPrimeraTransformacion();
		testGohan.usarSegundaTransformacion();
		
		assertTrue((testGohan.getPoderDePelea() == 100) && (testGohan.getVelocidadDeDesplazamiento() == 3) && (testGohan.getdistanciaDeAtaque() == 4));
	}
}
