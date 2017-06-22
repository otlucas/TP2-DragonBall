package personaje;

import personaje.estado.*;
import posicionable.Posicionable;
import tablero.Equipo;
import consumible.Efecto;
import java.util.HashMap;

public abstract class Personaje implements Posicionable {

	public String nombre;
	protected int puntosDeVidaMaximos, puntosDeVida, ki;
	protected Estado modo;
	protected HashMap<Integer, Efecto> efectos = new HashMap<Integer, Efecto>();
	private Equipo equipo;
	protected int numeroDeTransformacion;

	public abstract boolean puedeEfectuarAtaqueEspecial();
	public abstract int ejecutarAtaqueEspecial(int danio);

	/*Devuelve los puntos de vida maximos que tiene el personaje*/
	public int getPuntosDeVidaMaximos(){
		return puntosDeVidaMaximos;
	}

	/*Devuelve los puntos de vida que tiene el personaje en el momento*/
	public int getPuntosDeVida(){
		return puntosDeVida;
	}

	/*Devuelve el ki que tiene el personaje en el momento*/
	public int getKi(){
		return ki;
	}

	/*Devuelve el poder de pelea del personaje.*/
	public int getPoderDePelea() {
		double efecto = 1;
		if (efectos.containsKey(3)) {
			efecto = 1.25;
		}
		return (int) (modo.getPoderDePelea() * efecto);
	}

	/*Devuelve la distancia de ataque del personaje.*/
	public int getdistanciaDeAtaque() {
		return modo.getDistanciaDeAtaque();
	}

	/*Devuelve la velocidad de desplazamiento del personaje.*/
	public int getVelocidadDeDesplazamiento() {
		int efecto = 1;
		if (efectos.containsKey(2)) {
			efecto = 2;
		}
		return (modo.getVelocidadDeDesplazamiento() * efecto);
	}

	/*Se le asigna un equipo al personaje*/
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	/*Devuelve el equipo en el que se encuentra el personaje*/
	public Equipo getEquipo() {
		return equipo;
	}

	/*Pierde la cantidad de puntos de vida recibida por parametro.*/
	public void perderPuntosDeVida(int cantidad){
		puntosDeVida = puntosDeVida - cantidad;
	}

	/*Devuelve true o false segun el personaje este muerto o no*/
	public boolean estaMuerto() {
		return puntosDeVida <= 0;
	}

	/*Gana la cantidad de puntos de vida recibida por parametro.*/
	public void ganarPuntosDeVida(int cantidad) {
		if (puntosDeVida + cantidad >= puntosDeVidaMaximos)
			puntosDeVida = puntosDeVidaMaximos;
		else
			puntosDeVida = puntosDeVida + cantidad;
	}

	/*Al comienzo de cada turno, todos los personajes ganan 5 puntos de ki.*/
	public void ganarKi() {
		int efecto = 1;
		if (efectos.containsKey(4)) {
			efecto = 0;
		}
		ki = ki + (5 * efecto);
	}

	public void atacarA(Personaje victima, boolean especial) {
		double multiplicador =  victima.getPoderDePelea()>getPoderDePelea() ? 0.8 : 1;
		int danio = getPoderDePelea();
		if (especial)
			danio = ejecutarAtaqueEspecial(danio);
		victima.perderPuntosDeVida((int)(danio*multiplicador));
	}

	public boolean puedeTransformarse() {
		return modo.puedeTransformarse(ki, equipo);
	}

	public void transformarse() throws CondicionesInsuficientes, UltimaTransformacionAlcanzada {
		if (!puedeTransformarse())
			throw new CondicionesInsuficientes();
		modo = modo.transformarse(ki);
		this.numeroDeTransformacion++;
	}

	public void obtenerEfecto(Efecto efecto) {
		if (efecto.getEfecto() == 1) {
			this.ganarPuntosDeVida(100);
		}
		else {
			efectos.put(efecto.getEfecto(), efecto);
		}
		if (efecto.getEfecto() == 3) {
			equipo.incrementarEsferasDelDragon();
		}
	}

	public void desactivarEfectos(int turno) {
		for (Efecto efecto : efectos.values()) {
			if (!efecto.estaActivo(turno)) {
				efectos.remove(efecto.getEfecto());
			}
		}
	}

	public void avanzarTurno(int turno) {
		desactivarEfectos(turno);
		ganarKi();
	}

	public boolean estaParalizado() {
		if (efectos.containsKey(4)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean esMovible() {
		return true;
	}

	@Override
	public boolean ocupaEspacio() {
		return true;
	}

	public int getNumeroDeTransformacion(){
		return this.numeroDeTransformacion;
	}

	public String getNombre() {
		return nombre;
	}

}