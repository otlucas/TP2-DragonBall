package segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import personaje.*;
import personaje.CondicionesInsuficientes;
import tablero.*;

public class SegundaEntrega {

	Tablero tablero = new Tablero(5);
	Goku goku = new Goku();
	Gohan gohan = new Gohan();
	Piccolo piccolo = new Piccolo();
	Cell cell = new Cell();
	Equipo equipo = new Equipo("Guerreros Z");

	@Test
	public void test01LlevarAGohanAPrimeraTransfYComprobarQueNoPuedeHacerLaSegunda() throws CondicionesInsuficientes {

		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(goku);

		gohan.setEquipo(equipo);
		goku.setEquipo(equipo);
		piccolo.setEquipo(equipo);

		tablero.posicionar(goku, 0, 0);
		tablero.posicionar(gohan, 0, 1);
		tablero.posicionar(piccolo, 0, 2);

		gohan.ganarKi();
		gohan.ganarKi();
		gohan.transformarse();

		assertFalse(gohan.puedeTransformarse());
	}

	@Test
	public void test02QuitarVidaGokuYPiccoloYComprobarSegundaTransformacionDeGohan() throws CondicionesInsuficientes {

		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(goku);

		gohan.setEquipo(equipo);
		goku.setEquipo(equipo);
		piccolo.setEquipo(equipo);

		tablero.posicionar(goku, 0, 0);
		tablero.posicionar(gohan, 0, 1);
		tablero.posicionar(piccolo, 0, 2);

		for(int i = 0; i < 9; i++)
			gohan.ganarKi();

		gohan.transformarse();
		goku.perderPuntosDeVida(351);
		piccolo.perderPuntosDeVida(351);
		gohan.transformarse();

		assertEquals(gohan.getPoderDePelea(), 100);
		assertEquals(gohan.getdistanciaDeAtaque(), 4);
		assertEquals(gohan.getVelocidadDeDesplazamiento(), 3);
	}

	@Test
	public void test03LlevarAPiccoloAPrimerTransfYComprobarQueNoPuedeHacerLaSegunda() throws CondicionesInsuficientes {

		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);

		gohan.setEquipo(equipo);
		piccolo.setEquipo(equipo);

		tablero.posicionar(gohan, 0, 1);
		tablero.posicionar(piccolo, 0, 2);

		for (int i = 0; i < 5; i++)
			piccolo.ganarKi();

		piccolo.transformarse();

		assertFalse(piccolo.puedeTransformarse());
	}

	@Test
	public void test04QuitarVidaAGohaYComprobarSegundaTransformacionDePiccolo() throws CondicionesInsuficientes {

		equipo.agregarPersonaje(piccolo);
		equipo.agregarPersonaje(gohan);

		gohan.setEquipo(equipo);
		piccolo.setEquipo(equipo);

		tablero.posicionar(gohan, 0, 1);
		tablero.posicionar(piccolo, 0, 2);

		for(int i = 0; i < 5; i++)
			piccolo.ganarKi();

		piccolo.transformarse();
		gohan.perderPuntosDeVida(241);
		piccolo.transformarse();

		assertEquals(piccolo.getPoderDePelea(), 60);
		assertEquals(piccolo.getdistanciaDeAtaque(), 6);
		assertEquals(piccolo.getVelocidadDeDesplazamiento(), 4);
	}

	@Test
	public void test05ComprobarQueCellInicialmenteNoPuedeTransformarse() {


		tablero.posicionar(cell, 0, 2);

		assertFalse(cell.puedeTransformarse());
	}

	@Test
	public void test06CellEfectuaPrimeraTransformacionCorrectamenteDespuesDeAbsorberVida() throws CondicionesInsuficientes {

		tablero.posicionar(cell, 0, 0);
		tablero.posicionar(gohan, 0, 1);

		for (int i = 0; i < 5; i++)
			cell.ganarKi();
		for (int i = 0; i < 5; i++)
			cell.atacarA(gohan, true);

		cell.transformarse();

		assertEquals(cell.getPoderDePelea(), 40);
		assertEquals(cell.getdistanciaDeAtaque(), 4);
		assertEquals(cell.getVelocidadDeDesplazamiento(), 3);
	}

	@Test
	public void test07CellEfectuaSegundaTransformacionCorrectamenteDespuesDeAbsorberVida() throws CondicionesInsuficientes {

		tablero.posicionar(cell, 0, 0);
		tablero.posicionar(gohan, 0, 1);

		for (int i = 0; i < 10; i++)
			cell.ganarKi();
		for (int i = 0; i < 10; i++)
			cell.atacarA(gohan, true);

		cell.transformarse();
		cell.transformarse();

		assertEquals(cell.getPoderDePelea(), 80);
		assertEquals(cell.getdistanciaDeAtaque(), 4);
		assertEquals(cell.getVelocidadDeDesplazamiento(), 4);
	}

	@Test
	public void test08ComprobarQueAbsorberAumentaLaVidaDeCellSiNoEstaAlMaximoYHaceDanioBasicoAlEnemigo() {

		tablero.posicionar(cell, 0, 0);
		tablero.posicionar(gohan, 0, 1);

		cell.perderPuntosDeVida(100);
		cell.ganarKi();
		cell.atacarA(gohan, true);

		assertEquals(cell.getPuntosDeVida(), 420);
		assertEquals(gohan.getPuntosDeVida(), 280);
	}

	@Test
	public void test09ComprobarQueAbsorberNoAumentaLaVidaDeCellSiEstaAlMaximoYHaceDanioBasicoAlEnemigo(){

		tablero.posicionar(cell, 0, 0);
		tablero.posicionar(gohan, 0, 1);

		cell.ganarKi();
		cell.atacarA(gohan, true);

		assertEquals(cell.getPuntosDeVida(), 500);
		assertEquals(gohan.getPuntosDeVida(), 280);
	}

	@Test
	public void test10VerificarQueElDaniooDeGokuAumentaCuandoTieneMuyPocaVidaConAtaqueBasico(){

		tablero.posicionar(cell, 0, 0);
		tablero.posicionar(goku, 0, 1);

		goku.perderPuntosDeVida(351);
		goku.atacarA(cell, false);

		assertEquals(cell.getPuntosDeVida(), 476);
	}

	@Test
	public void test11VerificarQueElDaniooDeGokuAumentaCuandoTieneMuyPocaVidaConAtaqueEspecial(){

		tablero.posicionar(cell, 0, 0);
		tablero.posicionar(goku, 0, 1);

		for (int i = 0; i < 10; i++)
			goku.ganarKi();
		goku.perderPuntosDeVida(351);
		goku.atacarA(cell, true);

		assertEquals(cell.getPuntosDeVida(), 464);
	}

}