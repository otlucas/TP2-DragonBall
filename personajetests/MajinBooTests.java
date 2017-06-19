package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.MajinBoo;

public class MajinBooTests {
	
	private MajinBoo majin = new MajinBoo();
	
	@Test
	public void test01ObtenerPoderDePelea(){

		assertTrue(majin.getPoderDePelea() == 30);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida(){

		assertTrue(majin.getPuntosDeVida() == 300);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){

		assertTrue(majin.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){

		assertTrue(majin.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		majin.perderPuntosDeVida(140);
		
		assertTrue(majin.getPuntosDeVida() == 160);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		majin.perderPuntosDeVida(140);
		majin.ganarPuntosDeVida(50);
		
		assertTrue(majin.getPuntosDeVida() == 210);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		
		assertFalse(majin.puedeTransformarse());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){

		assertFalse(majin.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		for (int i = 0; i<5; i++)
			majin.ganarKi();
		
		assertTrue(majin.puedeTransformarse());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		for (int i = 0; i<8; i++)
			majin.ganarKi();
		
		assertTrue(majin.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test11LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<20; i++)
			majin.ganarKi();
		majin.transformarse();
		
		assertTrue(majin.puedeTransformarse());
	}
	
	@Test
	public void test12EfectuarPrimeraTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			majin.ganarKi();
		majin.transformarse();
		
		assertTrue(majin.getPoderDePelea() == 50);
	}
	
	@Test
	public void test13EfectuarPrimeraTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<8; i++)
			majin.ganarKi();
		majin.transformarse();
		
		assertTrue(majin.getVelocidadDeDesplazamiento() == 3);
	}
	
	@Test
	public void test14EfectuarSegundaTransformacionCambioPoderDePelea() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.transformarse();
		majin.transformarse();
		
		assertTrue(majin.getPoderDePelea() == 60);
	}
	
	@Test
	public void test15EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.transformarse();
		majin.transformarse();
		
		assertTrue(majin.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioDistanciaDeAtaque() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.transformarse();
		majin.transformarse();
		
		assertTrue(majin.getdistanciaDeAtaque() == 3);
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test17UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		majin.transformarse();
	}
	
	@Test (expected = personaje.CondicionesInsuficientes.class)
	public void test18UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws personaje.CondicionesInsuficientes{
		majin.transformarse();
	}
	
	@Test 
	public void test19SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.transformarse();
		
		assertTrue((majin.getPoderDePelea() == 50) && (majin.getVelocidadDeDesplazamiento() == 3));
	}
	
	@Test 
	public void test20SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws personaje.CondicionesInsuficientes{
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.transformarse();
		majin.transformarse();
		
		assertTrue((majin.getPoderDePelea() == 60) && (majin.getVelocidadDeDesplazamiento() == 4) && (majin.getdistanciaDeAtaque() == 3));
	}



}
