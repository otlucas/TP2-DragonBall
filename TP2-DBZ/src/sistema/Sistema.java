package sistema;

import personaje.*;
import tablero.Casillero;
import tablero.Consumible;
import tablero.Equipo;
import tablero.Tablero;

import java.util.List;

public class Sistema {
    private List<Personaje> personajes;
    private List<Consumible> consumibles;
    private List<Equipo> equipos;
    private Tablero tablero;


    public Sistema(List<Personaje> personajes, List<Consumible> consumibles, List<Equipo> equipos, Tablero tablero) {
        this.personajes = personajes;
        this.consumibles = consumibles;
        this.equipos = equipos;
        this.tablero = tablero;
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
}
