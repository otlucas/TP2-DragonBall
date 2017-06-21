package sistema;

import personaje.*;
import tablero.Casillero;
import tablero.Equipo;
import tablero.Tablero;
import turno.Turno;

import java.util.List;

import consumible.Consumible;

public class Sistema {
    private List<Personaje> personajes;
    private List<Consumible> consumibles;
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
    	
    	Nube nube = new Nube();
    	EsferaDelDragon esfera = new EsferaDelDragon();
    	Semilla semilla = new Semilla();
    	
    	Equipo guerreros = new Equipo("Guerreros Z");
    	Equipo enemigos = new Equipo("Enemigos de la Tierra");
    	guerreros.agregarPersonaje(goku);
    	guerreros.agregarPersonaje(gohan);
    	guerreros.agregarPersonaje(piccolo);
    	enemigos.agregarPersonaje(majin);
    	enemigos.agregarPersonaje(cell);
    	enemigos.agregarPersonaje(freezer);
    	
    	List<Consumible> consumibles = new ArrayList<Consumible>();
    	List<Personaje> personajes = new ArrayList<Personaje>();
    	List<Equipo> equipos = new ArrayList<Equipo>();
    	
    	personajes.add(goku);
    	personajes.add(gohan);
    	personajes.add(freezer);
    	personajes.add(cell);
    	personajes.add(majin);
    	personajes.add(piccolo);
    	consumibles.add(semilla);
    	consumibles.add(esfera);
    	consumibles.add(nube);
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

    public void atacar(Casillero origen, Casillero destino, boolean especial) throws Exception {
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
}
