package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tablero.Tablero;
import sistema.Sistema;

public class Main extends Application {

	public static void main(String[] args) {
        launch(args);
    }

	Tablero tablero = new Tablero(20);

	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dragon Ball FighterZ");

        Sistema sistema = new Sistema();

        ContenedorPrincipal contenedor = new ContenedorPrincipal(primaryStage, sistema);
        Scene gameScene = new Scene(contenedor, 3000, 2000);
        
        VentanaInicio ventanaInicio = new VentanaInicio(primaryStage, gameScene);
        Scene startScene = new Scene(ventanaInicio, 3000, 2000);
        
        
        primaryStage.setScene(startScene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}