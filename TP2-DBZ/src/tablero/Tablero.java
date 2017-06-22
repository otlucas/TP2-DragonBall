package tablero;

import posicionable.Posicionable;
import consumible.*;

import java.util.Random;

public class Tablero {
	
	private Casillero[][] tablero;

	public Tablero(Integer dimension) {
		this.tablero = new Casillero[dimension][dimension];

		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				tablero[x][y] = new Casillero(x, y);
			}
		}
	}

	public boolean posicionar(Posicionable posicionable, int x, int y){
		Casillero casillero = tablero[x][y];
		if(!casillero.estaOcupado()){
			casillero.setPosicionable(posicionable);
			return true;
		}
		return false;
	}

	public Casillero getCasillero(int x, int y) {
		return this.tablero[x][y];
	}

	public Posicionable posicionarConsumible() {
		Random randomGenY = new Random(System.currentTimeMillis());
		Random randomGenX = new Random(System.currentTimeMillis());
		Random consumibleGen = new Random(System.currentTimeMillis());
		int numeroAleatorio = consumibleGen.nextInt(3) + 1;
		Posicionable consumible;
		if (numeroAleatorio == 1) {
			consumible = new Semilla();
		}
		else if (numeroAleatorio == 2) {
			consumible = new Nube();
		}
		else {
			consumible = new EsferaDelDragon();
		}
		boolean termino = false;
		while(!termino) {
			termino = posicionar(consumible, randomGenY.nextInt(tablero.length), randomGenX.nextInt(tablero.length));
		}
		return consumible;
	}

	public void mover(Casillero origen, Casillero destino) throws CasilleroOcupado, MovimientoNoValido {
		if(destino.estaOcupado()){
			throw new CasilleroOcupado();
		}
		Posicionable aux = origen.getPosicionable();
		if(aux.esMovible() && origen.estaEnRango(1,destino)){
			origen.setPosicionable(null);
			destino.setPosicionable(aux);
		}else {
			throw new MovimientoNoValido();
		}
	}
}
