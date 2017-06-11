
public class Piccolo extends Personaje {
	
	public Piccolo(){
		this.nombre = "Piccolo";
		this.modo = "Normal";
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.ki = 0;
	}
	
	public int ejecutarAtaqueEspecial(int daño){
		daño = daño + (25/100)*daño;
		ki = ki-10;
		return daño;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 10);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 20) && (modo == "Normal"));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		/*int puntosDeVidaDeGohan = Gohan.obtenerPuntosDeVida();*/
		return /*((puntosDeVidaDeGohan < (20/100)*puntosDeVidaDeGohan) &&*/ (modo == "Fortalecido");
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = "Fortalecido";
		poderDePelea = 40;
		distanciaDeAtaque = 4;
		velocidadDeDesplazamiento = 3;
		ki = ki-20;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = "Super Sayajin";
		poderDePelea = 60;
		distanciaDeAtaque = 6;
		velocidadDeDesplazamiento = 4;
	}
}
