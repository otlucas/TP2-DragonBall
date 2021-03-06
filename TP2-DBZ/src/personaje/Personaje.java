package personaje;

import java.util.ArrayList;
import efecto.Efecto;
import personaje.estado.Estado;
import personaje.estado.UltimaTransformacionAlcanzada;
import posicionable.Posicionable;
import tablero.Equipo;

public abstract class Personaje implements Posicionable {

	public String nombre;
	protected int puntosDeVidaMaximos, puntosDeVida, ki;
	protected int multiplicadorKi = 1, multiplicadorVelocidad = 1;
	protected double multiplicadorPoder = 1;
	protected boolean estaParalizado;
	protected int kiParaAtaqueEspecial;
	protected Estado modo;
	protected ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	private Equipo equipo;
	protected int numeroDeTransformacion;
	protected int cantidadDeMovimientos;
	protected int cantidadDeAtaques;

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
		return (int) (modo.getPoderDePelea() * multiplicadorPoder);
	}

	/*Devuelve la distancia de ataque del personaje.*/
	public int getdistanciaDeAtaque() {
		return modo.getDistanciaDeAtaque();
	}

	/*Devuelve la velocidad de desplazamiento del personaje.*/
	public int getVelocidadDeDesplazamiento() {
		return (modo.getVelocidadDeDesplazamiento() * multiplicadorVelocidad);
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
		ki = ki + (5 * multiplicadorKi);
	}

	public void atacarA(Personaje victima, boolean especial) throws KiInsuficiente {
		double multiplicador =  victima.getPoderDePelea()>getPoderDePelea() ? 0.8 : 1;
		int danio = getPoderDePelea();
		if (especial){
			if(!this.puedeEfectuarAtaqueEspecial())
				throw new KiInsuficiente();
			danio = ejecutarAtaqueEspecial(danio);
		}
		victima.perderPuntosDeVida((int)(danio*multiplicador));
	}

	public void actualizarKi(int cantidad){
		ki = ki - cantidad;
	}

	public boolean puedeTransformarse() {
		return modo.puedeTransformarse(ki, equipo);
	}

	public void transformarse() throws CondicionesInsuficientes, UltimaTransformacionAlcanzada {
		if (!puedeTransformarse())
			throw new CondicionesInsuficientes();
		actualizarKi(modo.getKiParaTransformarse());
		modo = modo.transformarse();
		this.numeroDeTransformacion++;
	}

	public void obtenerEfecto(Efecto efecto) {
		efecto.activarEfecto(this);
	}

	public void desactivarEfectos(int turno) {
		int indice = 0;
		for (Efecto efecto : efectos) {
			indice++;
			efecto.desactivarEfecto(turno, this, indice);
		}
	}

	public void activarEfectoNube(Efecto efecto) {
		multiplicadorVelocidad = 2;
		efectos.add(efecto);
	}

	public void activarEfectoEsfera(Efecto efecto) {
		multiplicadorPoder = 1.25;
		equipo.incrementarEsferasDelDragon();
		efectos.add(efecto);
	}

	public void activarEfectoChocolate(Efecto efecto) {
		multiplicadorKi = 0;
		estaParalizado = true;
		efectos.add(efecto);
	}

	public void activarEfectoSemilla(Efecto efecto) {
		this.ganarPuntosDeVida(100);
		efectos.add(efecto);
	}

	public void desactivarEfectoNube(int indice) {
		multiplicadorVelocidad = 1;
		efectos.remove(indice);
	}

	public void desactivarEfectoEsfera(int indice) {
		multiplicadorPoder = 1;
		efectos.remove(indice);
	}

	public void desactivarEfectoChocolate(int indice) {
		multiplicadorKi = 1;
		estaParalizado = false;
		efectos.remove(indice);
	}

	public void desactivarEfectoSemilla(int indice) {
		efectos.remove(indice);
	}

	public void avanzarTurno(int turno) {
		desactivarEfectos(turno);
		ganarKi();
	}

	public boolean estaParalizado() {
		return estaParalizado;
	}

	public void renovarMovimientosMaximos(){
		this.cantidadDeMovimientos = modo.getVelocidadDeDesplazamiento();
	}

	public int getCantidadDeMovimientos() {
		return cantidadDeMovimientos;
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

	public void disminuirCantidadDeMovimientos() {
		cantidadDeMovimientos--;
	}

	public void renovarAtaques() {
		this.cantidadDeAtaques = 1;
	}

	public void disminuirCantidadDeAtaques() {
		cantidadDeAtaques--;
	}

	public int getCantidadDeAtaques() {
		return cantidadDeAtaques;
	}

}