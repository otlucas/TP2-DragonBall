package tablero;

import java.util.Random;

public class Turno {
	
	private int numeroDeTurno;
	
	private int equipo;
	
	private int equipoInicial;
	
	public void turnoInicial() {
		 equipo = 1;
		 numeroDeTurno = 1;
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(100);
		 if (randomInt % 2 == 0) {
			 equipo = 2;
		 }
		 equipoInicial = equipo;
	}
	
	public void finalizarTurno() {
		if (equipo == 1) {
			equipo = 2;
		}
		else {
			equipo = 1;
		}
		if (equipo == equipoInicial) {
			numeroDeTurno ++;
		}
	}
	
	public int devolverEquipo() {
		return equipo;
	}
	
	public int devolverNumeroDeTurno() {
		return numeroDeTurno;
	}
	
	public int devolverEquipoInicial() {
		return equipoInicial;
	}
}
