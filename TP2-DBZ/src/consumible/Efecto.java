package consumible;

public class Efecto {
	
	protected int turnoFinal;
	protected int tipoDeEfecto;
	
	public Efecto(int turno, int tipo) {
		turnoFinal = turno;
		tipoDeEfecto = tipo;
	}
	
	public boolean estaActivo(int turno) {
		if (turno < turnoFinal) {
			return true;
		}
		return false;
	}
	
	public int getEfecto() {
		return tipoDeEfecto;
	}
}
