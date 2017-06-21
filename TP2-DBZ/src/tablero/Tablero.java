package tablero;

import posicionable.Posicionable;

/*import java.util.Random;*/

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

/* PARA LUEGO UBICAR CONSUMIBLES*/
/*	public void posicionarAlAzar(Posicionable posicionable){
		Random random = new Random();
		while(!posicionar(posicionable,
				tablero[random.nextInt(tablero.length)][random.nextInt(tablero.length)]));
	}*/

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
