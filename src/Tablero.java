package tablero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
	
	public List<ArrayList<Casillero>> tablero;
	List<Personaje> personajes;
	List<Consumible> consumibles;
	List<Equipo> equipos;
	private Integer dimension;
	
	public Tablero(Integer dimension, ArrayList<Personaje> personajes, ArrayList<Consumible> consumibles, ArrayList<Equipo> equipos){
		
			/** Crea una instancia de Tablero, primero crea un HashMap con integers como clave y listas (representan las columnas) de casilleros como valor (se rellena de casilleros)
			 * luego se asigna el resto de los valores pasados por parametro
			 */
		
		ArrayList<ArrayList<Casillero>> tablero = new ArrayList<ArrayList<Casillero>>();
		
		for(int x = 0; x < dimension; x++){
			ArrayList<Casillero> columnadecasilleros = new ArrayList<Casillero>();
			for(int y = 0; y < dimension; y++){
				Casillero casillero = new Casillero(x, y);
				columnadecasilleros.add(casillero);
			}
			tablero.add(columnadecasilleros);
			
		}
		this.dimension = dimension;
		this.tablero = tablero;
		this.personajes = personajes;
		this.consumibles = consumibles;
		this.equipos = equipos;
		
	}
	
	public List<Casillero> obtenerCasillerosPosibles(int rango, Casillero casilleroActual){
		
		/** Devuelve todos los casilleros que se encuentran dentro del rango recibido por parametro
		 *  respecto al casillero pasado por parametro */
		
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
	
	public ArrayList<Casillero> casillerosAdyacentes (Casillero casillerocentral, List<ArrayList<Casillero>> tablero){
		/** Devuelve un ArrayList con los casilleros adyacentes(no ocupados) al casillero central, tuve que hardcodear
		 * las tuplas (1, 1), (1, 0), (-1, 0)...etc. porque no se me ocurrió una manera de iterar, es tipo el reversi*/
		
		ArrayList<Casillero> casillerosAdyacentes = new ArrayList<Casillero>();
		
		int coordX = casillerocentral.getX();
		int coordY = casillerocentral.getY();
		if(coordX + 1 < this.dimension && coordY + 1 < this.dimension){
			if(!tablero.get(coordX + 1).get(coordY + 1).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX + 1).get(coordY + 1));
			}
		}
		if(coordX - 1 >= 0 && coordY + 1 < this.dimension){
			if(!tablero.get(coordX - 1).get(coordY + 1).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX - 1).get(coordY + 1));
			}
		}
		if(coordY + 1 < this.dimension){
			if(!tablero.get(coordX).get(coordY + 1).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX).get(coordY + 1));
			}
		}
		if(coordX - 1 >= 0 && coordY - 1 >= 0){
			if(!tablero.get(coordX - 1).get(coordY - 1).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX - 1).get(coordY - 1));
			}
		}
		if(coordX - 1 >= 0){
			if(!tablero.get(coordX - 1).get(coordY).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX - 1).get(coordY));
			}
		}
		if(coordX + 1 < this.dimension && coordY - 1 >= 0){
			if(!tablero.get(coordX + 1).get(coordY - 1).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX + 1).get(coordY - 1));
			}
		}
		if(coordX + 1 < this.dimension){
			if(!tablero.get(coordX + 1).get(coordY).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX + 1).get(coordY));
			}
		}
		if(coordY - 1 >= 0){
			if(!tablero.get(coordX).get(coordY - 1).estaOcupado()){
				casillerosAdyacentes.add(tablero.get(coordX).get(coordY - 1));
			}
		}
		
		return casillerosAdyacentes;
		
		
	}
	
	public Double distanciaACasillero (Casillero casilleroactual, Casillero objetivo){
		/** Devuelve la distancia entre dos casilleros calculando el modulo de la resta entre las coordenadas de ambos */
		double coordXf = objetivo.getX();
		double coordYf = objetivo.getY();
		double coordXi = casilleroactual.getX();
		double coordYi = casilleroactual.getY();
		
		return Math.sqrt(Math.pow(coordXf - coordXi, 2) + Math.pow(coordYf - coordYi, 2));
		
		
	}
	
	public ArrayList<Casillero> AStar (Casillero partida, Casillero llegada) throws MovimientoNoValido {
		/** Usa A* para encontrar el camino de menor costo desde el casillero partida hasta el casillero llegada, lo leí de una página
		 * cuyo link voy a poner en un archivo de texto que se llama LinkAStar, es muy complicado el código y no sé como escribirlo mejor */
		ArrayList<Casillero> caminoEncontrado = new ArrayList<Casillero>();
		//Se crea una lista "abierta" que sirve para almacenar los nodos que son candidatos para ser evaluados
		ArrayList<Nodo> openList = new ArrayList<Nodo>();
		//Se crea una lista "cerrada" que sirve para almacenar los nodos que ya fueron evaluados y no pueden usarse otra vez
		ArrayList<Nodo> closedList = new ArrayList<Nodo>();
		//Uso este booleano para comprobar si se encontro el camino al casillero llegada o no (la comprobación esta abajo de el desarrollo)
		boolean encontrado = false;
		//Se crea un nodo para cada casillero, de este modo se lo puede relacionar con un nodo padre que servira mas adelante
		Nodo nodoPartida = new Nodo(null, partida, 0, this.distanciaACasillero(partida, llegada));
		//Se agrega el primer nodo a la lista de candidatos
		openList.add(nodoPartida);
		//Si este nodo es el de llegada entonces el movimiento no es válido (no queremos que se realizen movimientos hacia el mismo casillero)
		for(Nodo a :closedList){
			if(a.devolverActual().equals(llegada)){
				throw new MovimientoNoValido();
			}
		}
		//Se fija el primer nodo como el nodo que se evalua actualmente
		Nodo nodoActual = nodoPartida;
		outerloop:
		while(!openList.isEmpty()){
			//Busco los adyacentes
			ArrayList<Casillero> casillerosAdyacentes = this.casillerosAdyacentes(nodoActual.devolverActual(), this.tablero);
			//Agrego el nodo a la lista cerrada ya que ya fue evaluado y lo saco de la lista abierta
			closedList.add(nodoActual);
			openList.remove(nodoActual);
			//Si el nodo agregado a la lista cerrada es el destino entonces termino
			for(Nodo o :closedList){
				if(o.devolverActual().equals(llegada)){
					encontrado = true;
					break outerloop;
				}
			}
			//Para cada casillero adyacente creo un nodo
			for(Casillero e :casillerosAdyacentes){
				//Aca
				Nodo nuevoNodo = new Nodo(nodoActual, e, 1 + nodoActual.devolverValorG(), this.distanciaACasillero(e, llegada));
				boolean yaRevisado = false;
				//Si lo encuentro en la lista cerrada entonces no lo evaluo
				for(Nodo i :closedList){
					if(i.devolverActual().equals(nuevoNodo.devolverActual())){
						yaRevisado = true;
					}
				}
				//Si este un nodo adyacente ya se encuentra en la lista abierta pero se llego a el desde un camino mas largo que el actual entonces
				//cambio el padre de este nodo por el actual nodo
				for(Nodo j :openList){
					if(!yaRevisado && j.devolverActual().equals(nuevoNodo.devolverActual())){
						if(j.devolverValorG() > nuevoNodo.devolverValorG()){
							openList.remove(j);
							break;
						}
					}
				}
				if(!yaRevisado){
					openList.add(nuevoNodo);
				}
			}
			//Al terminar busco el nodo en la lista abierta que mas me conviene(refiriendome a costos) para seguir avanzando
			Nodo nodoAux = null;
			if(openList.size() > 0){
				nodoAux = openList.get(0);
				for(Nodo u :openList){
					if((u.devolverValorG() + u.devolverValorH() <= nodoAux.devolverValorG() + nodoAux.devolverValorH())){
						nodoAux = u;
					}
				}	
			}
			//Y lo actualizo
			nodoActual = nodoAux;	
		}
		//Si me quede sin candidatos para avanzar y no encontre el camino entonces el movimiento no es valido
		if(openList.isEmpty() && !encontrado){
			throw new MovimientoNoValido();
		}
		//Luego de haber llegado al nodo destino puedo "volver hacia atras" accediendo sucesivamente a los padres de cada nodo
		Nodo nodoActualaux = closedList.get(closedList.size() - 1);
		while(!nodoActualaux.devolverActual().equals(partida)){
			caminoEncontrado.add(nodoActualaux.devolverActual());
			nodoActualaux = nodoActualaux.devolverPadre();
		}
		caminoEncontrado.add(nodoActualaux.devolverActual());
		Collections.reverse(caminoEncontrado);
		for(Casillero c :caminoEncontrado){
			System.out.println(String.format("(%d, %d)", c.getX(), c.getY()));
		}
		//Devuelvo un ArrayList con los casilleros que se recorrieron
		System.out.println("Fin");
		return caminoEncontrado;
	}
		
	
	public void personajeSeMueveHasta(String nombredepersonaje, Casillero casilleroDestino) throws CasilleroOcupado, MovimientoNoValido, NombreDePersonajeNoValido{
		/** Se chequean las condiciones para que el movimiento sea valido y luego, si es valido,
		se remueve el personaje de su casillero actual y se lo coloca en el casilleroDestino,
		si no es valido, se lanza una excepcion */
		
		Personaje personaje = null;
		
		for(Personaje e: this.personajes){
			if(e.nombre == nombredepersonaje){
				personaje = e;
			}
		}
		if(personaje == null){
			throw new NombreDePersonajeNoValido();
		}
		ArrayList<Casillero> caminoMinimo = this.AStar(personaje.casilleroActual, casilleroDestino);
		if(caminoMinimo.size() - 1 <= personaje.getVelocidadDeDesplazamiento()){
			personaje.casilleroActual.cambiarEstado();
			personaje.casilleroActual = casilleroDestino;
			personaje.casilleroActual.cambiarEstado();
		}
	}
	
	public void personajeUsaAtaqueBasicoContra(String nombredelatacante, String nombredelavictima) throws NombreDePersonajeNoValido, AtaqueNoValido{
		/** Se chequean las condiciones para que el ataque sea válido y luego, si es valido, se le resta
		la cantidad de puntos de vida correspondiente al personaje que es victima, si no es valido, se lanza una
		excepcion */
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
