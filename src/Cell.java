
public class Cell extends Personaje {
	
	private int cantidadDeVecesQueAbsorbioVida = 0;
	
	public Cell(){
		this.nombre = "Cell";
		this.modo = "Normal";
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 3;
		this.velocidadDeDesplazamiento = 2;
		this.ki = 0;
	}
	
	public int ejecutarAtaqueEspecial(int daño){
		this.ganarPuntosDeVida(daño);;
		ki = ki-5;
		cantidadDeVecesQueAbsorbioVida++;
		return daño;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 5);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((cantidadDeVecesQueAbsorbioVida > 4) && (modo == "Normal"));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		return ((cantidadDeVecesQueAbsorbioVida > 8) && (modo == "Semi-perfecto"));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = "Semi-perfecto";
		poderDePelea = 40;
		distanciaDeAtaque = 4;
		velocidadDeDesplazamiento = 3;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = "Perfecto";
		poderDePelea = 80;
		velocidadDeDesplazamiento = 4;
	}
}
