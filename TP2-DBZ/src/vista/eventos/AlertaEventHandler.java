package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertaEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText("No se pudo realizar la accion");
        String mensaje = "No se cumpple los requisitos necesarios";
        alert.setContentText(mensaje);
        alert.show();
    }
}