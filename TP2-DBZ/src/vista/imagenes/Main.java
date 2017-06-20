package vista.imagenes;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personaje.Cell;
import personaje.Goku;
import tablero.Tablero;
import personaje.Personaje;
import sistema.Sistema;
import vista.imagenes.ContenedorPrincipal;

public class Main extends Application {

	public static void main(String[] args) {
        launch(args);
    }

	Tablero tablero = new Tablero(20);
	ArrayList<Personaje> personajes = new ArrayList<Personaje>();//Esto lo tuve que crear porque sistema no lo hace solo
    Goku testGoku = new Goku();//Lo mismo con esto
    Cell testCell = new Cell();//Y esto

	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dragon Ball FighterZ");

        personajes.add(testCell);//Y esto
        personajes.add(testGoku);//Y esto

        tablero.posicionar(testGoku, tablero.getTablero()[5][5]);//Y esto
        tablero.posicionar(testCell, tablero.getTablero()[5][6]);//Y esto

        Sistema sistema = new Sistema(personajes, null, null, tablero);

        ContenedorPrincipal contenedor = new ContenedorPrincipal(primaryStage, sistema);

        Scene scene = new Scene(contenedor, 1080, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}