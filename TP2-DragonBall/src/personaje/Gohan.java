package personaje;

public class Gohan extends Personaje {
	
	public Gohan(){
		this.nombre = "Gohan";
		this.modo = new Normal();;
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.ki = 0;
		
		this.poderDePeleaN = 15;
		this.distanciaDeAtaqueN = 2;
		this.velocidadDeDesplazamientoN = 2;
		
		this.poderDePeleaPT = 30;
		this.distanciaDeAtaquePT = 2;
		this.velocidadDeDesplazamientoPT = 2;
		
		this.poderDePeleaST = 100;
		this.distanciaDeAtaqueST = 4;
		this.velocidadDeDesplazamientoST = 3;
	}
	
	public int ejecutarAtaqueEspecial(int danio){
		danio = danio + (25/100)*danio;
		ki = ki-10;
		return danio;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 10);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 10) && (modo.getClass() == Normal.class));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		/*int puntosDeVidaDeGoku = Goku.obtenerPuntosDeVida();
		int puntosDeVidaDePiccolo = Piccolo.obtenerPuntosDeVida();*/
		return ((ki >= 30) && (modo.getClass() == PrimeraTransformacion.class)) /*|| ((puntosDeVidaDeGoku < (30/100)*puntosDeVidaDeGoku) && (puntosDeVidaDePiccolo < (30/100)*puntosDeVidaDePiccolo))))*/;
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = new PrimeraTransformacion();
		ki = ki-10;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = new SegundaTransformacion();
		ki = ki-30;
	}
}
