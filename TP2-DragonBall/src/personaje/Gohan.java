package personaje;

public class Gohan extends Personaje {
	
	public Gohan(){
		this.nombre = "Gohan";
		this.modo = "Normal";
		this.puntosDeVidaMaximos = 300;
		this.puntosDeVida = 300;
		this.poderDePelea = 15;
		this.distanciaDeAtaque = 2;
		this.velocidadDeDesplazamiento = 2;
		this.ki = 0;
	}
	
	public int ejecutarAtaqueEspecial(int dano){
		dano = dano + (25/100)*dano;
		ki = ki-10;
		return dano;
	}
	
	public boolean puedeEfectuarAtaqueEspecial(){
		return (ki >= 10);
	}
	
	public boolean puedeEfectuarPrimeraTransformacion(){
		return ((ki >= 10) && (modo == "Normal"));
	}
	
	public boolean puedeEfectuarSegundaTransformacion(){
		/*int puntosDeVidaDeGoku = Goku.obtenerPuntosDeVida();
		int puntosDeVidaDePiccolo = Piccolo.obtenerPuntosDeVida();*/
		return ((modo == "Super Sayajin Fase 1") && (ki >= 30)) /*|| ((puntosDeVidaDeGoku < (30/100)*puntosDeVidaDeGoku) && (puntosDeVidaDePiccolo < (30/100)*puntosDeVidaDePiccolo))))*/;
	}
	
	public void efectuarPrimeraTransformacion(){
		modo = "Super Sayajin Fase 1";
		poderDePelea = 30;
		ki = ki-10;
	}
	
	public void efectuarSegundaTransformacion(){
		modo = "Super Sayajin Fase 2";
		poderDePelea = 100;
		distanciaDeAtaque = 4;
		velocidadDeDesplazamiento = 3;
		ki = ki-30;
	}
}
