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
    	List<Equipo> equipos = new ArrayList<Equipo>();

    	equipos.add(enemigos);
    	equipos.add(guerreros);

        this.consumibles = consumibles;
        this.equipos = equipos;
        this.tablero = new Tablero(20);
        this.turno = new Turno();
        this.equipoActual = this.setEquipoInicial(this.turno,this.equipos);

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

    public Equipo setEquipoInicial(Turno turno, List<Equipo> equipos){
    	int a = turno.turnoInicial();
    	return equipos.get(a-1);
    }

    public void atacar(Casillero origen, Casillero destino, boolean especial) throws AtaqueNoValido {
        if(!origen.estaOcupado() || ! destino.estaOcupado()) throw new AtaqueNoValido();
        Personaje atacante = (Personaje) origen.getPosicionable();
        Personaje victima = (Personaje) destino.getPosicionable();
        if ((atacante.getEquipo()!=equipoActual) || (victima.getEquipo()==atacante.getEquipo()) || (atacante.getCantidadDeAtaques() <= 0))
			throw new AtaqueNoValido();
        if(origen.estaEnRango(atacante.getdistanciaDeAtaque(),destino)){
        	try{
        		 atacante.atacarA(victima,especial);
        	}
           catch (KiInsuficiente k){
        	   //No hay suficiente ki
           }

            if ((atacante.getNombre() == "MajinBoo") && especial) {
            	Consumible consumible = new Chocolate();
            	victima.obtenerEfecto(consumible.getEfecto(turno.devolverNumeroDeTurno()));
            }
            atacante.disminuirCantidadDeAtaques();
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
		if ((personaje.getEquipo()!=equipoActual) || (personaje.getCantidadDeMovimientos() <= 0))
			throw new MovimientoNoValido();
		Consumible consumible = (Consumible) destino.getPosicionable();
		if(consumible !=  null) {
			personaje.obtenerEfecto(consumible.getEfecto(turno.devolverNumeroDeTurno()));
			if(consumibles.size() > 0)
				consumibles.remove(0);
		}
    	//if (equipoActual.contarEsferasDelDragon() == 7) {
    		/*Terminar el juego*/
    	//}
		personaje.disminuirCantidadDeMovimientos();
		tablero.mover(origen, destino);
	}

    public void transformar(Casillero casillero) throws TransformacionNoValida {
    	Personaje personaje = (Personaje) casillero.getPosicionable();
    	if (personaje.getEquipo()!=equipoActual)
			throw new TransformacionNoValida();
    	personaje.transformarse();
    }

    public void finalizarTurno() {
    	int turnoSiguiente = turno.finalizarTurno();
    	equipoActual = equipos.get(turnoSiguiente-1);
    	int turnoActual = turno.devolverNumeroDeTurno();
    	equipoActual.avanzarTurno(turnoActual);
    	Random randomGen = new Random(System.currentTimeMillis());
    	int random = randomGen.nextInt();
    	if (turnoActual%3 == 0 && consumibles.size() < 5 && random%2 == 0) {
    		Posicionable consumible = tablero.posicionarConsumible();
    		consumibles.add(consumible);
    	}
    	equipoActual.renovarMovimientos();
    	equipoActual.renovarAtaques();
    }
}

