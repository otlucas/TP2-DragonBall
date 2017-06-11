package personaje;

public class Goku extends Personaje {
	
	public Goku(){
		this.nombre = "Goku";
		this.modo = new Normal();
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.ki = 0;
		
		this.poderDePeleaN = 20;
		this.distanciaDeAtaqueN = 2;
		this.velocidadDeDesplazamientoN = 2;
		
		this.poderDePeleaPT = 40;
		this.distanciaDeAtaquePT = 4;
		this.velocidadDeDesplazamientoPT = 3;

		this.poderDePeleaST = 60;
		this.distanciaDeAtaqueST = 4;
		this.velocidadDeDesplazamientoST = 5;
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
