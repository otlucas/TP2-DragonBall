package sistema;

import personaje.*;
import tablero.Casillero;
import tablero.CasilleroOcupado;
import tablero.Equipo;
import tablero.MovimientoNoValido;
import tablero.Tablero;
import turno.Turno;

import java.util.List;

import consumible.Consumible;

public class Sistema {
    private List<Personaje> personajes;
    private List<Consumible> consumibles;
    private List<Equipo> equipos;
    private Tablero tablero;
    private Turno turno;
    private Equipo equipoActual;


    public Sistema(List<Personaje> personajes, List<Consumible> consumibles, List<Equipo> equipos, Tablero tablero) {
        this.personajes = personajes;
        this.consumibles = consumibles;
        this.equipos = equipos;
        this.tablero = tablero;
        this.turno = new Turno();
    }

    public void atacar(Casillero origen, Casillero destino, boolean especial) throws AtaqueNoValido {
        if(!origen.estaOcupado() || ! destino.estaOcupado()) throw new AtaqueNoValido();
        Personaje atacante = (Personaje) origen.getPosicionable();
        Personaje victima = (Personaje) destino.getPosicionable();
        if(origen.estaEnRango(atacante.getdistanciaDeAtaque(),destino)){
            atacante.atacarA(victima,especial);
            if(victima.estaMuerto()){
                destino.setPosicionable(null);
                if(victima.getEquipo().perdio()){
                    /*Terminar el juego*/
                }
            }
        }
    }

    public void mover(Casillero origen, Casillero destino) throws CasilleroOcupado, MovimientoNoValido {
		Personaje personaje = (Personaje) origen.getPosicionable();
		Consumible consumible = (Consumible) destino.getPosicionable();
		if(consumible !=  null)
			personaje.obtenerEfecto(consumible.getEfecto(turno.devolverNumeroDeTurno()));
		tablero.mover(origen, destino);
	}

    public void finalizarTurno() {
    	int equipo = turno.finalizarTurno();
    	int turnoActual = turno.devolverNumeroDeTurno();
    	equipoActual = equipos.get(equipo);
    	equipoActual.avanzarTurno(turnoActual);
    }

    public Casillero[][] getTablero(){
    	return this.tablero.tablero;
    }
}