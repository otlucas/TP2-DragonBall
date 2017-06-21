package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import personaje.CondicionesInsuficientes;
import personaje.Personaje;
import personaje.estado.UltimaTransformacionAlcanzada;
import tablero.Casillero;
import vista.ContenedorPrincipal;

public class BotonTransformarHandler implements EventHandler<ActionEvent> {

    private final Casillero casillero;
    ContenedorPrincipal contenedor;

    public BotonTransformarHandler(Casillero casillero, ContenedorPrincipal contenedor) {
        this.casillero = casillero;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
		Personaje personaje = (Personaje) this.casillero.getPosicionable();
		try{
			personaje.transformarse();
			this.contenedor.actualizarVentanaDelJuego();
			this.contenedor.limpiarVentanaDelJuego();
		}catch(CondicionesInsuficientes e){
			//this.contenedor.mostrarMensaje("Condiciones insuficientes");
		}catch(UltimaTransformacionAlcanzada i){
			//this.contenedor.mostrarMensaje("Ultima transformacion alcanzada");
		}
    }
}