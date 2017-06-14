package personaje;

import posicionable.Posicionable;
import tablero.Equipo;

public abstract class Personaje implements Posicionable {
	
	public String nombre;
	protected int puntosDeVidaMaximos, puntosDeVida, ki;
	protected Estado modo;
	private Equipo equipo;
	
	protected int poderDePeleaN, distanciaDeAtaqueN, velocidadDeDesplazamientoN;
	protected int poderDePeleaPT, distanciaDeAtaquePT, velocidadDeDesplazamientoPT;
	protected int poderDePeleaST, distanciaDeAtaqueST, velocidadDeDesplazamientoST;
	
	public abstract boolean puedeEfectuarAtaqueEspecial(); 
	public abstract boolean puedeEfectuarPrimeraTransformacion();
	public abstract boolean puedeEfectuarSegundaTransformacion();
	public abstract void efectuarPrimeraTransformacion();
	public abstract void efectuarSegundaTransformacion();
	public abstract int ejecutarAtaqueEspecial(int danio);
	
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
	}
	
	public boolean estaMuerto(){
		return puntosDeVida < 0;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void ganarPuntosDeVida(int cantidad){
		/*Gana la cantidad de puntos de vida recibida por parametro.*/
		if (puntosDeVida + cantidad >= puntosDeVidaMaximos)
			puntosDeVida = puntosDeVidaMaximos;
		else
			puntosDeVida = puntosDeVida + cantidad;
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
	
	public void atacarA(Personaje victima, boolean especial){
		double multiplicador =  victima.getPoderDePelea()>getPoderDePelea() ? 0.8 : 1;
		int danio = getPoderDePelea();
		if (especial)
			danio = ejecutarAtaqueEspecial(danio);
		victima.perderPuntosDeVida((int)(danio*multiplicador));
	}

	@Override
	public boolean esMovible() {
		return true;
	}

	@Override
	public boolean ocupaEspacio() {
		return true;
	}
	public void setEquipo(Equipo equipo) {
		// Se le asigna un equipo al personaje
		this.equipo = equipo;
	}
}