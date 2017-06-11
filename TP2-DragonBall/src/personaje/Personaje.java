package personaje;

import tablero.Casillero;

public abstract class Personaje {
	
	public String nombre;
	protected int puntosDeVidaMaximos, puntosDeVida, ki;
	public Casillero casilleroActual;
	protected Estado modo;
	
	protected int poderDePeleaN, distanciaDeAtaqueN, velocidadDeDesplazamientoN;
	protected int poderDePeleaPT, distanciaDeAtaquePT, velocidadDeDesplazamientoPT;
	protected int poderDePeleaST, distanciaDeAtaqueST, velocidadDeDesplazamientoST;
	
	public abstract boolean puedeEfectuarAtaqueEspecial(); 
	public abstract boolean puedeEfectuarPrimeraTransformacion();
	public abstract boolean puedeEfectuarSegundaTransformacion();
	public abstract void efectuarPrimeraTransformacion();
	public abstract void efectuarSegundaTransformacion();
	
	public void usarPrimeraTransformacion() throws CondicionesInsuficientes{
		/*Se chequea si se puede usar la primera transformacion, de ser posible se usa,
		en el caso contrario se lanza una excepcion.*/
		if(!this.puedeEfectuarPrimeraTransformacion())
			throw new CondicionesInsuficientes();
		this.efectuarPrimeraTransformacion();
	}
	
	public void usarSegundaTransformacion() throws CondicionesInsuficientes{
		/*Se chequea si se puede usar la segunda transformacion, de ser posible se usa,
		en el caso contrario se lanza una excepcion.*/
		if(!this.puedeEfectuarSegundaTransformacion())
			throw new CondicionesInsuficientes();
		this.efectuarSegundaTransformacion();
	}
	
	public int obtenerPuntosDeVida(){
		/*Devuelve los puntos de vida que tiene el personaje en el momento.*/
		return puntosDeVida;
	}
	
	public void perderPuntosDeVida(int cantidad){
		/*Pierde la cantidad de puntos de vida recibida por parametro.*/
		puntosDeVida = puntosDeVida - cantidad;
		if (puntosDeVida <= 0){
			this.casilleroActual.cambiarEstado();
			/*Matar al personaje*/
		}
	}

	public void ganarPuntosDeVida(int cantidad){
		/*Gana la cantidad de puntos de vida recibida por parametro.*/
		if (puntosDeVida + cantidad >= puntosDeVidaMaximos)
			puntosDeVida = puntosDeVidaMaximos;
		else
			puntosDeVida = puntosDeVida + cantidad;
	}
	
	public Casillero obtenerPosicion(){
		/*Devuelve el casillero donde se encuentra el personaje en el momento que recibe el mensaje.*/
		return casilleroActual;
	}

	public int getPoderDePelea() {
		/*Devuelve el poder de pelea del personaje.*/
		return modo.getPoderDePelea(this);
	}
	
	public int getdistanciaDeAtaque() {
		/*Devuelve la distancia de ataque del personaje.*/
		return modo.getDistanciaDeAtaque(this);
	}
	
	public int getVelocidadDeDesplazamiento() {
		/*Devuelve la velocidad de desplazamiento del personaje.*/
		return modo.getVelocidadDeDesplazamiento(this);
	}

	public void ganarKi() {
		/*Al comienzo de cada turno, todos los personajes ganan 5 puntos de ki.*/
		ki = ki + 5;
	}
}
