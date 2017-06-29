package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tablero.Casillero;
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
		if(this.contenedor.seleccion.isEmpty()){
			posY = 0;
			this.contenedor.limpiarVentanaDelJuego();
			if(this.casillero.estaOcupado()){
				this.contenedor.imprimirInfo(this.casillero, posY, this.contenedor.datosPrimerPersonaje, true);
				this.contenedor.seleccion.add(0, this.casillero);
				this.contenedor.crearBotonTransformar(this.casillero);
				}
		}
		else if(this.contenedor.seleccion.size() == 1){
			posY = 6;
			if(this.casillero.estaOcupado()){
				this.contenedor.imprimirInfo(this.casillero, posY, this.contenedor.datosSegundoPersonaje, false);
				if(this.casillero != this.contenedor.seleccion.get(0)){//Esto sirve para cancelar la seleccion
					this.contenedor.seleccion.add(1, this.casillero);
					this.contenedor.crearBotonAtacar();
				}else{
					this.contenedor.limpiarVentanaDelJuego();
				}
			}else{
				try{
					this.contenedor.sistema.mover(this.contenedor.seleccion.get(0), this.casillero);
				}catch(MovimientoNoValido e){

				}
				this.contenedor.actualizarVentanaDelJuego();
				this.contenedor.limpiarVentanaDelJuego();
			}
		}else{
			this.contenedor.limpiarVentanaDelJuego();
		}
    }
}