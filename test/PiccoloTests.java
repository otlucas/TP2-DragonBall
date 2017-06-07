package tp2Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp2.CondicionesInsuficientes;
import tp2.Piccolo;

public class PiccoloTests {
	
	@Test
	public void test01ObtenerPoderDePelea(){
		Piccolo picolo = new Piccolo();
		
		assertTrue(picolo.getPoderDePelea() == 20);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida(){
		Piccolo picolo = new Piccolo();
		
		assertTrue(picolo.obtenerPuntosDeVida() == 500);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		Piccolo picolo = new Piccolo();
		
		assertTrue(picolo.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		Piccolo picolo = new Piccolo();
		
		assertTrue(picolo.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		Piccolo picolo = new Piccolo();
		picolo.perderPuntosDeVida(140);
		
		assertTrue(picolo.obtenerPuntosDeVida() == 360);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		Piccolo picolo = new Piccolo();
		picolo.perderPuntosDeVida(140);
		picolo.ganarPuntosDeVida(50);
		
		assertTrue(picolo.obtenerPuntosDeVida() == 410);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		Piccolo picolo = new Piccolo();
		
		assertFalse(picolo.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		Piccolo picolo = new Piccolo();
		
		assertFalse(picolo.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09PuedeEfectuarSegundaTransformacionInicialmenteDaFalse(){
		Piccolo picolo = new Piccolo();
		
		assertFalse(picolo.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<5; i++)
			picolo.ganarKi();
		
		assertTrue(picolo.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test11SinEfectuarPrimeraTransformacionNoPuedeEfectuarSegunda(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<10; i++)
			picolo.ganarKi();
		
		assertFalse(picolo.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test12LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<8; i++)
			picolo.ganarKi();
		
		assertTrue(picolo.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test13LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<20; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		
		assertTrue(picolo.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioPoderDePelea(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<8; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		
		assertTrue(picolo.getPoderDePelea() == 40);
	}
	
	@Test
	public void test15EfectuarPrimeraTransformacionCambioVelocidadDeDesplazamiento(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<8; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		
		assertTrue(picolo.getVelocidadDeDesplazamiento() == 3);
	}
	
	@Test
	public void test16EfectuarPrimeraTransformacionCambioDistanciaDeAtaque(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<8; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		
		assertTrue(picolo.getdistanciaDeAtaque() == 4);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioPoderDePelea(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<25; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		picolo.efectuarSegundaTransformacion();
		
		assertTrue(picolo.getPoderDePelea() == 60);
	}
	
	@Test
	public void test18EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<25; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		picolo.efectuarSegundaTransformacion();
		
		assertTrue(picolo.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test19EfectuarSegundaTransformacionCambioDistanciaDeAtaque(){
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<25; i++)
			picolo.ganarKi();
		picolo.efectuarPrimeraTransformacion();
		picolo.efectuarSegundaTransformacion();
		
		assertTrue(picolo.getdistanciaDeAtaque() == 6);
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test20UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		Piccolo picolo = new Piccolo();
		picolo.usarPrimeraTransformacion();
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test21UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		Piccolo picolo = new Piccolo();
		picolo.usarSegundaTransformacion();
	}
	
	@Test 
	public void test22SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<25; i++)
			picolo.ganarKi();
		picolo.usarPrimeraTransformacion();
		
		assertTrue((picolo.getPoderDePelea() == 40) && (picolo.getVelocidadDeDesplazamiento() == 3) && (picolo.getdistanciaDeAtaque() == 4));
	}
	
	@Test 
	public void test23SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		Piccolo picolo = new Piccolo();
		for (int i = 0; i<25; i++)
			picolo.ganarKi();
		picolo.usarPrimeraTransformacion();
		picolo.usarSegundaTransformacion();
		
		assertTrue((picolo.getPoderDePelea() == 60) && (picolo.getVelocidadDeDesplazamiento() == 4) && (picolo.getdistanciaDeAtaque() == 6));
	}



}
