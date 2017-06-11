package personaje;

public class MajinBoo extends Personaje {
	
	public MajinBoo(){
		this.nombre = "MajinBoo";
		this.modo = new Normal();
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.ki = 0;
		
		this.poderDePeleaN = 30;
		this.distanciaDeAtaqueN = 2;
		this.velocidadDeDesplazamientoN = 2;
		
		this.poderDePeleaPT = 50;
		this.distanciaDeAtaquePT = 2;
		this.velocidadDeDesplazamientoPT = 3;
		
		this.poderDePeleaST = 60;
		this.distanciaDeAtaqueST = 3;
		this.velocidadDeDesplazamientoST = 4;
	}
	
	public int ejecutarAtaqueEspecial(int danio){
		danio = 0;
		ki = ki-30;
		/*INUTILIZAR ENEMIGO*/
		return danio;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 30);
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
