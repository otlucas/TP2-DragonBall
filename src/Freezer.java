
public class Freezer extends Personaje {
	
	public Freezer(){
		this.nombre = "Freezer";
		this.modo = "Normal";
		this.puntosDeVidaMaximos = 400;
		this.puntosDeVida = 400;
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 4;
		this.ki = 0;
	}
	
	public int ejecutarAtaqueEspecial(int daño){
		daño = daño + (50/100)*daño;
		ki = ki-20;
		return daño;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 20);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 20) && (modo == "Normal"));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		return ((ki >= 50) && (modo == "Segunda forma"));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = "Segunda forma";
		poderDePelea = 40;
		distanciaDeAtaque = 3;
		ki = ki-20;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = "Definitivo";
		poderDePelea = 50;
		velocidadDeDesplazamiento = 6;
		ki = ki-50;
	}
}