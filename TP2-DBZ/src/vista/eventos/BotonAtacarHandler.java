package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sistema.AtaqueNoValido;
import tablero.Casillero;
import vista.ContenedorPrincipal;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

    Boolean ataqueEspecial;
    ContenedorPrincipal contenedor;

    public BotonAtacarHandler(ContenedorPrincipal contenedor, Boolean especial) {
        this.contenedor = contenedor;
        this.ataqueEspecial = especial;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
		Casillero casilleroAtacante = this.contenedor.seleccion.get(0);
		Casillero casilleroVictima = this.contenedor.seleccion.get(1);
        try {
            this.contenedor.sistema.atacar(casilleroAtacante, casilleroVictima, this.ataqueEspecial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.contenedor.limpiarVentanaDelJuego();
        this.contenedor.actualizarVentanaDelJuego();
    }
}
