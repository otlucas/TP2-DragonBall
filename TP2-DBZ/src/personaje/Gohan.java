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
		int pDeVidaMaximosDeGoku = this.getEquipo().getIntegrantes().get("Goku").puntosDeVidaMaximos;
		int pDeVidaActualDeGoku = this.getEquipo().getIntegrantes().get("Goku").obtenerPuntosDeVida();
		int pDeVidaMaximosDePiccolo = this.getEquipo().getIntegrantes().get("Piccolo").puntosDeVidaMaximos;
		int pDeVidaActualDePiccolo = this.getEquipo().getIntegrantes().get("Piccolo").obtenerPuntosDeVida();
		return ((ki >= 30) && (modo.getClass() == PrimeraTransformacion.class)) && ((pDeVidaActualDeGoku < (30/100)*pDeVidaMaximosDeGoku) && (pDeVidaActualDePiccolo < (30/100) * pDeVidaMaximosDePiccolo));
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
