package personaje;

public class Freezer extends Personaje {
	
	public Freezer(){
		this.nombre = "Freezer";
		this.modo = new Normal();
		this.puntosDeVidaMaximos = 400;
		this.puntosDeVida = 400;
		this.ki = 0;
		
		this.poderDePeleaN = 20;
		this.distanciaDeAtaqueN = 2;
		this.velocidadDeDesplazamientoN = 4;
		
		this.poderDePeleaPT = 40;
		this.distanciaDeAtaquePT = 3;
		this.velocidadDeDesplazamientoPT = 4;
		
		this.poderDePeleaST = 50;
		this.distanciaDeAtaqueST = 3;
		this.velocidadDeDesplazamientoST = 6;
	}
	
	public int ejecutarAtaqueEspecial(int danio){
		danio = danio + (50/100)*danio;
		ki = ki-20;
		return danio;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 20);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 20) && (modo.getClass() == Normal.class));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		return ((ki >= 50) && (modo.getClass() == PrimeraTransformacion.class));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = new PrimeraTransformacion();
		ki = ki-20;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = new SegundaTransformacion();
		ki = ki-50;
	}
}