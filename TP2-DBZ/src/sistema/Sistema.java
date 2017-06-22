package sistema;

import java.util.Random;
import personaje.*;
import tablero.*;
import turno.Turno;
import posicionable.*;

import java.util.ArrayList;
import java.util.List;

import consumible.*;
import consumible.Consumible;

public class Sistema {
    private List<Personaje> personajes;
    private List<Posicionable> consumibles;
    private List<Equipo> equipos;
    public Tablero tablero;
    private Turno turno;
    private Equipo equipoActual;

    public Sistema() {
    	Goku goku = new Goku();
    	Gohan gohan = new Gohan();
    	Freezer freezer = new Freezer();
    	Piccolo piccolo = new Piccolo();
    	Cell cell = new Cell();
    	MajinBoo majin = new MajinBoo();

    	Equipo guerreros = new Equipo("Guerreros Z");
    	Equipo enemigos = new Equipo("Enemigos de la Tierra");
    	guerreros.agregarPersonaje(goku);
    	guerreros.agregarPersonaje(gohan);
    	guerreros.agregarPersonaje(piccolo);
    	enemigos.agregarPersonaje(majin);
    	enemigos.agregarPersonaje(cell);
    	enemigos.agregarPersonaje(freezer);

    	List<Posicionable> consumibles = new ArrayList<Posicionable>();
    	List<Personaje> personajes = new ArrayList<Personaje>();
    	List<Equipo> equipos = new ArrayList<Equipo>();

    	personajes.add(goku);
    	personajes.add(gohan);
    	personajes.add(freezer);
    	personajes.add(cell);
    	personajes.add(majin);
    	personajes.add(piccolo);
    	equipos.add(enemigos);
    	equipos.add(guerreros);

        this.personajes = personajes;
        this.consumibles = consumibles;
        this.equipos = equipos;
        this.tablero = new Tablero(20);
        this.turno = new Turno();

        tablero.posicionar(goku, 0, 0);
        tablero.posicionar(gohan, 0, 1);
        tablero.posicionar(piccolo, 1, 0);
        tablero.posicionar(cell, 19, 19);
        tablero.posicionar(freezer, 19, 18);
        tablero.posicionar(majin, 18, 19);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void atacar(Casillero origen, Casillero destino, boolean especial) throws AtaqueNoValido {
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
    	//if (equipoActual.contarEsferasDelDragon() == 7) {
    		/*Terminar el juego*/
    	//}
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
    		Posicionable consumible = tablero.posicionarConsumible();
    		consumibles.add(consumible);
    	}
    }
}

