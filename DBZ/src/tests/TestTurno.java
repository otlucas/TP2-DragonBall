package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import turno.Turno;

public class TestTurno {

	protected Turno testTurno = new Turno();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDevolverEquipo() {
		
		int equipo = testTurno.devolverEquipo();
		
		Assert.assertEquals(0, equipo);
	}
	
	@Test
	public void testDevolverEquipoInicial() {
		
		testTurno.turnoInicial();
		
		int equipo = testTurno.devolverEquipo();
		
		int equipoInicial = testTurno.devolverEquipoInicial();
		
		Assert.assertTrue(equipo == equipoInicial);
	}
	
	@Test
	public void testDevolverNumeroDeTurno() {
		
		testTurno.turnoInicial();
		
		int numeroDeTurno = testTurno.devolverNumeroDeTurno();
		
		Assert.assertTrue(1 == numeroDeTurno);
	}
	
	@Test
	public void testFinalizarTurno() {
		
		testTurno.turnoInicial();
		
		int equipo = testTurno.devolverEquipo();
		
		int equipoInicial = testTurno.devolverEquipoInicial();
		
		Assert.assertTrue(equipo == equipoInicial);
		
		testTurno.finalizarTurno();
		
		equipo = testTurno.devolverEquipo();
		
		Assert.assertFalse(equipo != equipoInicial);
	}
	
	@Test
	public void testCambioDeEquipoSinCambioDeTurno() {
		
		testTurno.turnoInicial();
		
		int numeroDeTurno = testTurno.devolverNumeroDeTurno();
		
		int equipo = testTurno.devolverEquipo();
		
		int equipoInicial = testTurno.devolverEquipoInicial();
		
		Assert.assertTrue(((equipo == equipoInicial) && (1 == numeroDeTurno)));
		
		testTurno.finalizarTurno();
		
		numeroDeTurno = testTurno.devolverNumeroDeTurno();
		
		equipo = testTurno.devolverEquipo();
		
		Assert.assertTrue(((equipo != equipoInicial) && (1 == numeroDeTurno)));
	}
	
	@Test
	public void testFinalizarTurnoVarios() {
		
		testTurno.turnoInicial();
		
		int equipo = testTurno.devolverEquipo();
		
		int equipoInicial = testTurno.devolverEquipoInicial();
		
		Assert.assertTrue(equipo == equipoInicial);
		
		testTurno.finalizarTurno();
		
		equipo = testTurno.devolverEquipo();
		
		Assert.assertFalse(equipo != equipoInicial);
		
		int numeroDeTurno = testTurno.devolverNumeroDeTurno();
		
		Assert.assertTrue(1 == numeroDeTurno);
		
		testTurno.finalizarTurno();
		
		equipo = testTurno.devolverEquipo();
		
		Assert.assertFalse(equipo == equipoInicial);
		
		numeroDeTurno = testTurno.devolverNumeroDeTurno();
		
		Assert.assertTrue(2 == numeroDeTurno);
	}
}