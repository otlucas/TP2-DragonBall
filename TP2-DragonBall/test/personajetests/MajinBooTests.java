package personajetests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import personaje.CondicionesInsuficientes;
import personaje.MajinBoo;

public class MajinBooTests {
	
	@Test
	public void test01ObtenerPoderDePelea(){
		MajinBoo majin = new MajinBoo();
		
		assertTrue(majin.getPoderDePelea() == 30);
	}
	
	@Test
	public void test02ObtenerPuntosDeVida(){
		MajinBoo majin = new MajinBoo();
		
		assertTrue(majin.obtenerPuntosDeVida() == 300);
	}
	
	@Test
	public void test03ObtenerDistanciaDeAtaque(){
		MajinBoo majin = new MajinBoo();
		
		assertTrue(majin.getdistanciaDeAtaque() == 2);
	}
	
	@Test
	public void test04ObtenerVelocidadDeDesplazamiento(){
		MajinBoo majin = new MajinBoo();
		
		assertTrue(majin.getVelocidadDeDesplazamiento() == 2);
	}
	
	@Test
	public void test05PerderPuntosDeVida(){
		MajinBoo majin = new MajinBoo();
		majin.perderPuntosDeVida(140);
		
		assertTrue(majin.obtenerPuntosDeVida() == 160);
	}
	
	@Test
	public void test06GanarPuntosDeVida(){
		MajinBoo majin = new MajinBoo();
		majin.perderPuntosDeVida(140);
		majin.ganarPuntosDeVida(50);
		
		assertTrue(majin.obtenerPuntosDeVida() == 210);		
	}
	
	@Test
	public void test07PuedeEfectuarPrimeraTransformacionInicialmenteDaFalse(){
		MajinBoo majin = new MajinBoo();
		
		assertFalse(majin.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test08PuedeEfectuarAtaqueEspecialInicialmenteDaFalse(){
		MajinBoo majin = new MajinBoo();
		
		assertFalse(majin.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test09PuedeEfectuarSegundaTransformacionInicialmenteDaFalse(){
		MajinBoo majin = new MajinBoo();
		
		assertFalse(majin.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test10LuegoDeVariosTurnosEfectuarPrimeraTrasformacionEsTrue(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<5; i++)
			majin.ganarKi();
		
		assertTrue(majin.puedeEfectuarPrimeraTransformacion());
	}
	
	@Test
	public void test11SinEfectuarPrimeraTransformacionNoPuedeEfectuarSegunda(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<10; i++)
			majin.ganarKi();
		
		assertFalse(majin.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test12LuegoDeVariosTurnosPuedeEfectuarAtaqueEspecialEsTrue(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<8; i++)
			majin.ganarKi();
		
		assertTrue(majin.puedeEfectuarAtaqueEspecial());
	}
	
	@Test
	public void test13LuegoDeEfectuarPrimeraPuedeEfectuarSegundaTransformacionEsTrue(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<20; i++)
			majin.ganarKi();
		majin.efectuarPrimeraTransformacion();
		
		assertTrue(majin.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test14EfectuarPrimeraTransformacionCambioPoderDePelea(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<8; i++)
			majin.ganarKi();
		majin.efectuarPrimeraTransformacion();
		
		assertTrue(majin.getPoderDePelea() == 50);
	}
	
	@Test
	public void test15EfectuarPrimeraTransformacionCambioVelocidadDeDesplazamiento(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<8; i++)
			majin.ganarKi();
		majin.efectuarPrimeraTransformacion();
		
		assertTrue(majin.getVelocidadDeDesplazamiento() == 3);
	}
	
	@Test
	public void test16EfectuarSegundaTransformacionCambioPoderDePelea(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.efectuarPrimeraTransformacion();
		majin.efectuarSegundaTransformacion();
		
		assertTrue(majin.getPoderDePelea() == 60);
	}
	
	@Test
	public void test17EfectuarSegundaTransformacionCambioVelocidadDeDesplazamiento(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.efectuarPrimeraTransformacion();
		majin.efectuarSegundaTransformacion();
		
		assertTrue(majin.getVelocidadDeDesplazamiento() == 4);
	}
	
	@Test
	public void test18EfectuarSegundaTransformacionCambioDistanciaDeAtaque(){
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.efectuarPrimeraTransformacion();
		majin.efectuarSegundaTransformacion();
		
		assertTrue(majin.getdistanciaDeAtaque() == 3);
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test19UsarPrimeraTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		MajinBoo majin = new MajinBoo();
		majin.usarPrimeraTransformacion();
	}
	
	@Test (expected = CondicionesInsuficientes.class)
	public void test20UsarSegundaTransformacionInicialmenteLanzaCondicionesInsuficientes() throws CondicionesInsuficientes{
		MajinBoo majin = new MajinBoo();
		majin.usarSegundaTransformacion();
	}
	
	@Test 
	public void test21SePuedeUsarPrimeraTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.usarPrimeraTransformacion();
		
		assertTrue((majin.getPoderDePelea() == 50) && (majin.getVelocidadDeDesplazamiento() == 3));
	}
	
	@Test 
	public void test22SePuedeUsarSegundaTransformacionLuegoDeTurnos() throws CondicionesInsuficientes{
		MajinBoo majin = new MajinBoo();
		for (int i = 0; i<25; i++)
			majin.ganarKi();
		majin.usarPrimeraTransformacion();
		majin.usarSegundaTransformacion();
		
		assertTrue((majin.getPoderDePelea() == 60) && (majin.getVelocidadDeDesplazamiento() == 4) && (majin.getdistanciaDeAtaque() == 3));
	}



}
