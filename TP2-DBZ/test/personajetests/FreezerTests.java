package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import posicionable.CondicionesInsuficientes;
import personaje.Freezer;

public class FreezerTests {
	
	@Test
	public void test01ObtenerPoderDePelea(){
		Freezer frio = new Freezer();
		
		assertTrue(frio.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida(){
		Freezer freezer = new Freezer();
		
		assertTrue(freezer.obtenerPuntosDeVida() == 400);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		Freezer freezer = new Freezer();
		
		assertTrue(freezer.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		Freezer freezer = new Freezer();
		
		assertTrue(freezer.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		Freezer freezer = new Freezer();
		freezer.perderPuntosDeVida(140);
		
		assertTrue(freezer.obtenerPuntosDeVida() == 260);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		Freezer freezer = new Freezer();
		freezer.perderPuntosDeVida(140);
		freezer.ganarPuntosDeVida(50);
		
		assertTrue(freezer.obtenerPuntosDeVida() == 310);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		Freezer freezer = new Freezer();
		
		assertFalse(freezer.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		Freezer freezer = new Freezer();
		
		assertFalse(freezer.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09PuedeEfectuarSegundaTransformacionInicialmenteDaFalse(){
		Freezer freezer = new Freezer();
		
		assertFalse(freezer.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<5; i++)
			freezer.ganarKi();
		
		assertTrue(freezer.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test11SinEfectuarPrimeraTransformacionNoPuedeEfectuarSegunda(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<10; i++)
			freezer.ganarKi();
		
		assertFalse(freezer.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test12LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<8; i++)
			freezer.ganarKi();
		
		assertTrue(freezer.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test13LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<20; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		
		assertTrue(freezer.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioPoderDePelea(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<8; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		
		assertTrue(freezer.getPoderDePelea() == 40);
	}
	
	@Test
	public void test15EfectuarPrimeraTransformacionCambioDistanciaDeAtaque(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<8; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		
		assertTrue(freezer.getdistanciaDeAtaque() == 3);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioPoderDePelea(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<25; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		freezer.efectuarSegundaTransformacion();
		
		assertTrue(freezer.getPoderDePelea() == 50);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento(){
		Freezer freezer = new Freezer();
		for (int i = 0; i<25; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		freezer.efectuarSegundaTransformacion();
		
		assertTrue(freezer.getVelocidadDeDesplazamiento() == 6);
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test18UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		Freezer freezer = new Freezer();
		freezer.efectuarPrimeraTransformacion();
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test19UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		Freezer freezer = new Freezer();
		freezer.efectuarSegundaTransformacion();
	}
	
	@Test 
	public void test20SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		Freezer freezer = new Freezer();
		for (int i = 0; i<25; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		
		assertTrue((freezer.getPoderDePelea() == 40) && (freezer.getdistanciaDeAtaque() == 3));
	}
	
	@Test 
	public void test21SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		Freezer freezer = new Freezer();
		for (int i = 0; i<25; i++)
			freezer.ganarKi();
		freezer.efectuarPrimeraTransformacion();
		freezer.efectuarSegundaTransformacion();
		
		assertTrue((freezer.getPoderDePelea() == 50) && (freezer.getVelocidadDeDesplazamiento() == 6) && (freezer.getdistanciaDeAtaque() == 3));
	}

}
