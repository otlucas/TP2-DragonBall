package tablero;
import java.util.*;

public abstract class Personaje {
	
	public String nombre, modo;
	protected int puntosDeVida, puntosDeVidaMaximos, poderDePelea, distanciaDeAtaque, velocidadDeDesplazamiento, ki;
	public Casillero casilleroActual;
	
	
	public void usarPrimeraTransformacion(){
		/** Se chequea si se puede usar la primera transformacion, de ser posible se usa,
		en el caso contrario se lanza una excepcion */
		if(!this.puedeEfectuarPrimeraTransformacion())
			throw new CondicionesInsuficientes();
		this.efectuarPrimeraTransformacion();
	}
	
	public void usarSegundaTransformacion(){
		/** Se chequea si se puede usar la segunda transformacion, de ser posible se usa,
		en el caso contrario se lanza una excepcion */
		if(!this.puedeEfectuarSegundaTransformacion())
			throw new CondicionesInsuficientes();
		this.efectuarSegundaTransformacion();
	}
	
	public int obtenerPuntosDeVida(){
		/** Devuelve los puntos de vida que tiene el personaje en el momento */
		return this.puntosDeVida;
	}
	
	public abstract boolean puedeEfectuarAtaqueEspecial(); 
	public abstract boolean puedeEfectuarPrimeraTransformacion();
	public abstract boolean puedeEfectuarSegundaTransformacion();
	public abstract void efectuarPrimeraTransformacion();
	public abstract void efectuarSegundaTransformacion();
	
	public void perderPuntosDeVida(int cantidad){
		/** Pierde la cantidad de puntos de vida recibida por parametro */
		puntosDeVida = puntosDeVida - cantidad;
		if (puntosDeVida <= 0){
			this.casilleroActual.cambiarEstado();
			return;
		}
	}
	
	public void ganarPuntosDeVida(int cantidad){
		/** Gana la cantidad de puntos de vida recibida por parametro */
		if (puntosDeVida + cantidad > puntosDeVidaMaximos)
			puntosDeVida = puntosDeVidaMaximos;
		else
			puntosDeVida = puntosDeVida + cantidad;
	}
	
	
	public Casillero obtenerPosicion(){
		/** Devuelve el casillero donde se encuentra el personaje en el momento que recibe el mensaje */
		return this.casilleroActual;
	}

	public int getVelocidadDeDesplazamiento() {
		/** Devuelve la velocidad de desplazamiento del personaje */
		
		return this.velocidadDeDesplazamiento;
	}

	public int getdistanciaDeAtaque() {
		/** Devuelve la distancia de ataque del personaje */
		return this.distanciaDeAtaque;
	}

	public int getPoderDePelea() {
		/** Devuelve el poder de pelea del personaje */
		return this.poderDePelea;
	}
}
