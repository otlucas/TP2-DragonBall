package personaje;

public class Goku extends Personaje {
	
	public Goku(){
		this.nombre = "Goku";
		this.modo = "Normal";
		this.puntosDeVidaMaximos = 500;
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.ki = 0;
	}
	
	public int ejecutarAtaqueEspecial(int dano){
		dano = dano + (50/100)*dano;
		ki = ki-20;
		return dano;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 20);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 20) && (modo == "Normal"));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		return ((ki >= 50) && (modo == "Kaio-Ken"));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = "Kaio-Ken";
		poderDePelea = 40;
		distanciaDeAtaque = 4;
		velocidadDeDesplazamiento = 3;
		ki = ki-20;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = "Super Sayajin";
		poderDePelea = 60;
		velocidadDeDesplazamiento = 5;
		ki = ki-50;
	}

}
