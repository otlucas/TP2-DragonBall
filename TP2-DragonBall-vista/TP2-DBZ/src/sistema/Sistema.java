package sistema;

import personaje.*;

import tablero.*;
import turno.Turno;
import java.util.Random;
import java.util.List;

import consumible.*;

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

    public void atacar(Casillero origen, Casillero destino, boolean especial) throws Exception {
        if(!origen.estaOcupado() || ! destino.estaOcupado()) throw new AtaqueNoValido();
        Personaje atacante = (Personaje) origen.getPosicionable();
        Personaje victima = (Personaje) destino.getPosicionable();
        if(origen.estaEnRango(atacante.getdistanciaDeAtaque(),destino)){
            atacante.atacarA(victima,especial);
            if ((atacante.getNombre() == "MajinBoo") && especial) {
            	Consumible consumible = new Chocolate();
            	victima.obtenerEfecto(consumible.getEfecto(turno.devolverNumeroDeTurno()));
            }
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
		if(consumible !=  null) {
			personaje.obtenerEfecto(consumible.getEfecto(turno.devolverNumeroDeTurno()));
			consumibles.remove(0);
		}
    	if (equipoActual.contarEsferasDelDragon() == 7) {
    		/*Terminar el juego*/
    	}
		tablero.mover(origen, destino);
	}
    
    public void finalizarTurno() {
    	int equipo = turno.finalizarTurno();
    	int turnoActual = turno.devolverNumeroDeTurno();
    	equipoActual = equipos.get(equipo);
    	equipoActual.avanzarTurno(turnoActual);
    	Random randomGen = new Random(System.currentTimeMillis());
    	int random = randomGen.nextInt();
    	if (turnoActual%3 == 0 && consumibles.size() < 5 && random%2 == 0) {
    		Consumible consumible = tablero.posicionarConsumible();
    		consumibles.add(consumible);
    	}
    }
}
