package tp2Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import tp2.Cell;
import tp2.CondicionesInsuficientes;
import tp2.Equipo;
import tp2.Gohan;
import tp2.Goku;
import tp2.Piccolo;
import tp2.Tablero;

public class SegundaEntregaTests {
	
	@Test
	public void test01LlevarAGohanAPrimeraTransfYComprobarQueNoPuedeHacerLaSegunda(){
		
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Equipo equipo = new Equipo("Guerreros Z");
		
		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(goku);
		
		gohan.setEquipo(equipo);
		goku.setEquipo(equipo);
		piccolo.setEquipo(equipo);
	
		tablero.posicionar(goku, tablero.getTablero()[0][0]);
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		tablero.posicionar(piccolo, tablero.getTablero()[0][2]);
		
		gohan.ganarKi();
		gohan.ganarKi();
		gohan.efectuarPrimeraTransformacion();
		
		assertFalse(gohan.puedeEfectuarSegundaTransformacion());		
	}
	
	@Test
	public void test02QuitarVidaGokuYPiccoloYComprobarSegundaTransformacionDeGohan() throws CondicionesInsuficientes{
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Equipo equipo = new Equipo("Guerreros Z");
		
		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(goku);
		
		gohan.setEquipo(equipo);
		goku.setEquipo(equipo);
		piccolo.setEquipo(equipo);
	
		tablero.posicionar(goku, tablero.getTablero()[0][0]);
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		tablero.posicionar(piccolo, tablero.getTablero()[0][2]);
		
		for(int i = 0; i < 9; i++)
			gohan.ganarKi();
		
		gohan.usarPrimeraTransformacion();
		goku.perderPuntosDeVida(351);
		piccolo.perderPuntosDeVida(351);
		gohan.usarSegundaTransformacion();
		
		assertEquals(gohan.getPoderDePelea(), 100);
		assertEquals(gohan.getdistanciaDeAtaque(), 4);
		assertEquals(gohan.getVelocidadDeDesplazamiento(), 3);		
	}
	
	@Test
	public void test03LlevarAPiccoloAPrimerTransfYComprobarQueNoPuedeHacerLaSegunda() throws CondicionesInsuficientes{
		Tablero tablero = new Tablero(5);
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Equipo equipo = new Equipo("Guerreros Z");
		
		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);
		
		gohan.setEquipo(equipo);
		piccolo.setEquipo(equipo);
	
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		tablero.posicionar(piccolo, tablero.getTablero()[0][2]);
		
		for (int i = 0; i < 5; i++)
			piccolo.ganarKi();
		
		piccolo.usarPrimeraTransformacion();
		
		assertFalse(piccolo.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test04QuitarVidaAGohaYComprobarSegundaTransformacionDePiccolo() throws CondicionesInsuficientes{
		Tablero tablero = new Tablero(5);
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Equipo equipo = new Equipo("Guerreros Z");
		
		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);
		
		gohan.setEquipo(equipo);
		piccolo.setEquipo(equipo);
	
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		tablero.posicionar(piccolo, tablero.getTablero()[0][2]);
		
		for(int i = 0; i < 5; i++)
			piccolo.ganarKi();
		
		piccolo.usarPrimeraTransformacion();
		gohan.perderPuntosDeVida(241);
		piccolo.usarSegundaTransformacion();
		
		assertEquals(piccolo.getPoderDePelea(), 60);
		assertEquals(piccolo.getdistanciaDeAtaque(), 6);
		assertEquals(piccolo.getVelocidadDeDesplazamiento(), 4);		
	}
	
	@Test
	public void test05ComprobarQueCellInicialmenteNoPuedeTransformarse(){
		Tablero tablero = new Tablero(5);
		Cell cell = new Cell();
		
		tablero.posicionar(cell, tablero.getTablero()[0][2]);
		
		assertFalse(cell.puedeEfectuarPrimeraTransformacion());
		assertFalse(cell.puedeEfectuarSegundaTransformacion());
	}
	
	@Test
	public void test06CellEfectuaPrimeraTransformacionCorrectamenteDespuesDeAbsorberVida() throws CondicionesInsuficientes{
		Tablero tablero = new Tablero(5);
		Cell cell = new Cell();
		Gohan gohan = new Gohan();
		
		tablero.posicionar(cell, tablero.getTablero()[0][0]);
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		
		for (int i = 0; i < 5; i++)
			cell.ganarKi();
		for (int i = 0; i < 5; i++)
			cell.atacarA(gohan, true);
		
		cell.usarPrimeraTransformacion();
		
		assertEquals(cell.getPoderDePelea(), 40);
		assertEquals(cell.getdistanciaDeAtaque(), 4);
		assertEquals(cell.getVelocidadDeDesplazamiento(), 3);
	}
	
	@Test
	public void test07CellEfectuaSegundaTransformacionCorrectamenteDespuesDeAbsorberVida() throws CondicionesInsuficientes{
		Tablero tablero = new Tablero(5);
		Cell cell = new Cell();
		Gohan gohan = new Gohan();
		
		tablero.posicionar(cell, tablero.getTablero()[0][0]);
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		
		for (int i = 0; i < 10; i++)
			cell.ganarKi();
		for (int i = 0; i < 10; i++)
			cell.atacarA(gohan, true);
		
		cell.usarPrimeraTransformacion();
		cell.usarSegundaTransformacion();
		
		assertEquals(cell.getPoderDePelea(), 80);
		assertEquals(cell.getdistanciaDeAtaque(), 4);
		assertEquals(cell.getVelocidadDeDesplazamiento(), 4);
	}
	
	@Test
	public void test08ComprobarQueAbsorberAumentaLaVidaDeCellSiNoEstaAlMaximoYHaceDanioBasicoAlEnemigo(){
		Tablero tablero = new Tablero(5);
		Cell cell = new Cell();
		Gohan gohan = new Gohan();
		
		tablero.posicionar(cell, tablero.getTablero()[0][0]);
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		
		cell.perderPuntosDeVida(100);
		cell.ganarKi();
		cell.atacarA(gohan, true);
		
		assertEquals(cell.obtenerPuntosDeVida(), 420);
		assertEquals(gohan.obtenerPuntosDeVida(), 280);
	}
	
	@Test
	public void test09ComprobarQueAbsorberNoAumentaLaVidaDeCellSiEstaAlMaximoYHaceDanioBasicoAlEnemigo(){
		Tablero tablero = new Tablero(5);
		Cell cell = new Cell();
		Gohan gohan = new Gohan();
		
		tablero.posicionar(cell, tablero.getTablero()[0][0]);
		tablero.posicionar(gohan, tablero.getTablero()[0][1]);
		
		cell.ganarKi();
		cell.atacarA(gohan, true);
		
		assertEquals(cell.obtenerPuntosDeVida(), 500);
		assertEquals(gohan.obtenerPuntosDeVida(), 280);
	}
	
	@Test
	public void test10VerificarQueElDañoDeGokuAumentaCuandoTieneMuyPocaVidaConAtaqueBasico(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku();
		Cell cell = new Cell();
		
		tablero.posicionar(cell, tablero.getTablero()[0][0]);
		tablero.posicionar(goku, tablero.getTablero()[0][1]);
		
		goku.perderPuntosDeVida(351);
		goku.atacarA(cell, false);
		
		assertEquals(cell.obtenerPuntosDeVida(), 476);
	}
	
	@Test
	public void test11VerificarQueElDañoDeGokuAumentaCuandoTieneMuyPocaVidaConAtaqueEspecial(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku();
		Cell cell = new Cell();
		
		tablero.posicionar(cell, tablero.getTablero()[0][0]);
		tablero.posicionar(goku, tablero.getTablero()[0][1]);
		
		goku.perderPuntosDeVida(351);
		goku.atacarA(cell, true);
		
		assertEquals(cell.obtenerPuntosDeVida(), 464);
	}

}
