import java.util.*;

public abstract class Personaje {
	
	protected String nombre, modo;
	protected int puntosDeVida, puntosDeVidaMaximos, poderDePelea, distanciaDeAtaque, velocidadDeDesplazamiento, ki;
	protected Casillero casilleroActual;
	protected Movimiento movimiento;
	
	public void usarAtaqueBasico(Personaje objetivo, List<Casillero> listaDeCasilleros){
		/*if (objetivo es del equipo aliado)
		  throw new ObjetivoInvalido();*/
		int daño = poderDePelea;
		int rango = distanciaDeAtaque;
		List<Casillero> distanciasPosibles = movimiento.obtenerCasillerosPosibles(rango, casilleroActual, listaDeCasilleros);
		if (distanciasPosibles.contains(objetivo.obtenerPosicion()))
			objetivo.perderPuntosDeVida(daño);
		else
			throw new RangoInvalido();
	}
	
	public void usarAtaqueEspecial(Personaje objetivo, List<Casillero> listaDeCasilleros){
		/*if (objetivo es del equipo aliado)
		  throw new ObjetivoInvalido();*/
		if(!this.puedeEfectuarAtaqueEspecial())
			throw new KiInsuficiente();
		int daño = poderDePelea;
		daño = this.ejecutarAtaqueEspecial(daño);
		int rango = distanciaDeAtaque;
		List<Casillero> distanciasPosibles = movimiento.obtenerCasillerosPosibles(rango, casilleroActual, listaDeCasilleros);
		if (distanciasPosibles.contains(objetivo.obtenerPosicion()))
			objetivo.perderPuntosDeVida(daño);
		else
			throw new RangoInvalido();
	}
	
	public void usarPrimeraTransformacion(){
		if(!this.puedeEfectuarPrimeraTransformacion())
			throw new CondicionesInsuficientes();
		this.efectuarPrimeraTransformacion();
	}
	
	public void usarSegundaTransformacion(){
		if(!this.puedeEfectuarSegundaTransformacion())
			throw new CondicionesInsuficientes();
		this.efectuarSegundaTransformacion();
	}
	
	public int obtenerPuntosDeVida(){
		return this.puntosDeVida;
	}
	
	public abstract int ejecutarAtaqueEspecial(int daño);
	public abstract boolean puedeEfectuarAtaqueEspecial(); 
	public abstract boolean puedeEfectuarPrimeraTransformacion();
	public abstract boolean puedeEfectuarSegundaTransformacion();
	public abstract void efectuarPrimeraTransformacion();
	public abstract void efectuarSegundaTransformacion();
	
	public void perderPuntosDeVida(int cantidad){
		if (poderDePelea > cantidad)
			cantidad = (80/100)*cantidad;
		puntosDeVida = puntosDeVida - cantidad;
		if (puntosDeVida < 0){
			casilleroActual.cambiarEstado();
			/*Matar al personaje*/
		}
	}
	
	public void ganarPuntosDeVida(int cantidad){
		if (puntosDeVida + cantidad > puntosDeVidaMaximos)
			puntosDeVida = puntosDeVidaMaximos;
		else
			puntosDeVida = puntosDeVida + cantidad;
	}
		
	public void moverseA(Casillero casillero, List<Casillero> listaDeCasilleros){
		int rango = velocidadDeDesplazamiento;
		List<Casillero> movimientosPosibles = movimiento.obtenerCasillerosPosibles(rango, casilleroActual, listaDeCasilleros);
		if (movimientosPosibles.contains(casillero)&&(!casillero.estaOcupado())){
			casilleroActual.cambiarEstado();
			casilleroActual = casillero;
			casilleroActual.cambiarEstado();
		}
		else
			throw new RangoInvalido();
	}
	
	public Casillero obtenerPosicion(){
		return casilleroActual;
	}
}
