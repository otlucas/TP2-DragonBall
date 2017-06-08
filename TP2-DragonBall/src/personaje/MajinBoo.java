package personaje;

public class MajinBoo extends Personaje {
	
	public MajinBoo(){
		this.nombre = "MajinBoo";
		this.modo = "Normal";
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.poderDePelea = 30;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.ki = 0;
	}
	
	public int ejecutarAtaqueEspecial(int dano){
		dano = 0;
		ki = ki-30;
		/*INUTILIZAR ENEMIGO*/
		return dano;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 30);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 20) && (modo == "Normal"));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		return ((ki >= 50) && (modo == "Boo Malo"));
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = "Boo Malo";
		poderDePelea = 50;
		velocidadDeDesplazamiento = 3;
		ki = ki-20;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = "Boo Original";
		poderDePelea = 60;
		distanciaDeAtaque = 3;
		velocidadDeDesplazamiento = 4;
		ki = ki-50;
	}
}
