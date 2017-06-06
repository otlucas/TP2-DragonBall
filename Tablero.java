package tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tablero {
	
	HashMap<Integer, ArrayList<Casillero>> tablero;
	List<Personaje> personajes;
	List<Consumible> consumibles;
	List<Equipo> equipos;
	private Integer dimension;
	
	public Tablero(Integer dimension, ArrayList<Personaje> personajes, ArrayList<Consumible> consumibles, ArrayList<Equipo> equipos){
		
			/** Crea una instancia de Tablero, primero crea un HashMap con integers como clave y listas (representan las columnas) de casilleros como valor (se rellena de casilleros)
			 * luego se asigna el resto de los valores pasados por parametro
			 */
		
		HashMap<Integer, ArrayList<Casillero>> tablero = new HashMap<Integer, ArrayList<Casillero>>();
		
		for(int x = 0; x < dimension; x++){
			ArrayList<Casillero> columnadecasilleros = new ArrayList<Casillero>();
			for(int y = 0; y < dimension; y++){
				Casillero casillero = new Casillero(x, y);
				columnadecasilleros.add(casillero);
			}
			tablero.put(x, columnadecasilleros);
			
		}
		this.dimension = dimension;
		this.tablero = tablero;
		this.personajes = personajes;
		this.consumibles = consumibles;
		this.equipos = equipos;
		
	}
	
	public List<Casillero> obtenerCasillerosPosibles(int rango, Casillero casilleroActual){
		
		/** Devuelve todos los casilleros que se encuentran dentro del rango recibido por parametro respecto al casillero pasado por parametro */
		
		List<Casillero> casillerosPosibles = new ArrayList<Casillero>();
		int x = casilleroActual.getX();
		int y = casilleroActual.getY();
		int xMin = x - rango;
		if (xMin < 0)
			xMin = 0;
		int xMax = x + rango;
		if (xMax > this.dimension)
			xMax = this.dimension;
		int yMin = y - rango;
		if (yMin < 0)
			yMin = 0;
		int yMax = y + rango;
		if (xMax > this.dimension)
			xMax = this.dimension;
		
		for(int columna = 0; columna < this.dimension; columna++){
			
			ArrayList<Casillero> columnaDeCasilleros = this.tablero.get(columna);

			for (Casillero c: columnaDeCasilleros){
				int coordX = c.getX();
				int coordY = c.getY();
				if ( (xMin < coordX) && (coordX < xMax) && (yMin < coordY) && (coordY < yMax) && (!c.estaOcupado()) ){
					casillerosPosibles.add(c);
				}
			}
		}
		
		return casillerosPosibles;
		
	}
	
	public void personajeSeMueveHasta(String nombredepersonaje, Casillero casilleroDestino) throws CasilleroOcupado, MovimientoNoValido, NombreDePersonajeNoValido{
		
		Personaje personaje = null;
		
		for(Personaje e: this.personajes){
			if(e.nombre == nombredepersonaje){
				personaje = e;
			}
		}
		if(personaje == null){
			throw new NombreDePersonajeNoValido();
		}
		if(casilleroDestino.estaOcupado()){
			throw new CasilleroOcupado();
		}else{
			List<Casillero> casillerosPosibles = this.obtenerCasillerosPosibles(personaje.getVelocidadDeDesplazamiento(), personaje.casilleroActual);
			if(casillerosPosibles.contains(casilleroDestino)){
				personaje.casilleroActual.cambiarEstado();
				personaje.casilleroActual = casilleroDestino;
			}else{
				throw new MovimientoNoValido();
			}
		}	
	}
	
	public void personajeUsaAtaqueBasicoContra(String nombredelatacante, String nombredelavictima) throws NombreDePersonajeNoValido, AtaqueNoValido{
		
		Personaje atacante = null;
		Personaje victima = null;
		
		for(Personaje e: this.personajes){
			if(e.nombre == nombredelatacante){
				atacante = e;
			}else if(e.nombre == nombredelavictima){
				victima = e;
			}
		}
		
		if(atacante == null || victima == null){
			throw new NombreDePersonajeNoValido();
		}
		
		List<Casillero> casillerosPosibles = this.obtenerCasillerosPosibles(atacante.getdistanciaDeAtaque(), atacante.casilleroActual);
		if(casillerosPosibles.contains(victima.casilleroActual)){
			victima.perderPuntosDeVida(atacante.getPoderDePelea());
			if(victima.getPoderDePelea() > atacante.getPoderDePelea()){
				victima.ganarPuntosDeVida((20/atacante.getPoderDePelea()) * 100);
			}
		}else{
			
			throw new AtaqueNoValido();
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
