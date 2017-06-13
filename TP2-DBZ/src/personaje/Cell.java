package personaje;

public class Cell extends Personaje {
	
	private int cantidadDeVecesQueAbsorbioVida = 0;
	
	public Cell(){
		this.nombre = "Cell";
		this.modo = new Normal();
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.ki = 0;
		
		this.poderDePeleaN = 20;
		this.distanciaDeAtaqueN = 3;
		this.velocidadDeDesplazamientoN = 2;
		
		this.poderDePeleaPT = 40;
		this.distanciaDeAtaquePT = 4;
		this.velocidadDeDesplazamientoPT = 3;
		
		this.poderDePeleaST = 80;
		this.distanciaDeAtaqueST = 4;
		this.velocidadDeDesplazamientoST = 4;
	}
	
	public int ejecutarAtaqueEspecial(int danio){
		this.ganarPuntosDeVida(danio);;
		ki = ki-5;
		cantidadDeVecesQueAbsorbioVida++;
		return danio;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 5);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((cantidadDeVecesQueAbsorbioVida >= 4) && (modo.getClass() == Normal.class));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		return ((cantidadDeVecesQueAbsorbioVida >= 8) && (modo.getClass() == PrimeraTransformacion.class));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = new PrimeraTransformacion();
	}
	
	public void efectuarSegundaTransformacion(){
		modo = new SegundaTransformacion();
	}
}
