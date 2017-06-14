package personaje;

public class Piccolo extends Personaje {
	
	public Piccolo(){
		this.nombre = "Piccolo";
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
		this.distanciaDeAtaqueST = 6;
		this.velocidadDeDesplazamientoST = 4;
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
		return ((ki >= 20) && (modo.getClass() == Normal.class));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		/*int puntosDeVidaDeGohan = Gohan.obtenerPuntosDeVida();*/
		int puntosDeVidaMaximosDeGohan = this.getEquipo().getIntegrantes().get("Gohan").puntosDeVidaMaximos;
		int puntosDeVidaActualDeGohan = this.getEquipo().getIntegrantes().get("Gohan").obtenerPuntosDeVida();
		return ((puntosDeVidaActualDeGohan < (20/100)*puntosDeVidaMaximosDeGohan) && (modo.getClass() == PrimeraTransformacion.class));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = new PrimeraTransformacion();
		ki = ki-20;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = new SegundaTransformacion();
	}
}
