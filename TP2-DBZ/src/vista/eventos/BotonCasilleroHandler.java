package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import personaje.Personaje;
import tablero.Casillero;
import tablero.CasilleroOcupado;
import tablero.MovimientoNoValido;
import vista.ContenedorPrincipal;

public class BotonCasilleroHandler implements EventHandler<ActionEvent> {

    private final Casillero casillero;
    ContenedorPrincipal contenedor;

    public BotonCasilleroHandler(Casillero casillero, ContenedorPrincipal contenedor) {
        this.casillero = casillero;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	int posY;
		Personaje personaje;
		if(this.contenedor.seleccion.isEmpty()){
			posY = 0;
			this.contenedor.limpiarVentanaDelJuego();
			if(this.casillero.estaOcupado()){
				this.contenedor.imprimirInfo(this.casillero, posY, this.contenedor.datosPrimerPersonaje, true);
				personaje = (Personaje) this.casillero.getPosicionable();
				if(true && !(personaje.estaParalizado())){//Si pertenece al equipo actual tambien
					this.contenedor.seleccion.add(0, this.casillero);
					this.contenedor.crearBotonTransformar(this.casillero);
				}
			}else{

			}
		}
		else if(this.contenedor.seleccion.size() == 1){
			posY = 6;
			if(this.casillero.estaOcupado()){
				this.contenedor.imprimirInfo(this.casillero, posY, this.contenedor.datosSegundoPersonaje, false);
				personaje = (Personaje) this.casillero.getPosicionable();
				if(true && personaje != this.contenedor.seleccion.get(0).getPosicionable()){//Tambien si el personaje es del equipo contrario
					this.contenedor.seleccion.add(1, this.casillero);
					this.contenedor.crearBotonAtacar();
				}else{
					this.contenedor.limpiarVentanaDelJuego();
				}
			}else if(this.casillero.estaEnRango(1, this.contenedor.seleccion.get(0))){
				try {
					this.contenedor.sistema.mover(this.contenedor.seleccion.get(0), this.casillero);
				} catch (CasilleroOcupado casilleroOcupado) {
					casilleroOcupado.printStackTrace();
				} catch (MovimientoNoValido movimientoNoValido) {
					movimientoNoValido.printStackTrace();
				}
				this.contenedor.actualizarVentanaDelJuego();
				this.contenedor.limpiarVentanaDelJuego();
			}
		}else{
			this.contenedor.limpiarVentanaDelJuego();
		}
    }
}