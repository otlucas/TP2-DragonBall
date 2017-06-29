package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.ContenedorPrincipal;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {

    ContenedorPrincipal contenedor;

    public BotonFinalizarTurnoHandler(ContenedorPrincipal contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
		this.contenedor.sistema.finalizarTurno();
    }
}

