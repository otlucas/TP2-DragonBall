package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.eventos.BotonJugarEventHandler;
import vista.eventos.BotonSalirEventHandler;

public class VentanaInicio extends VBox {

    Stage stage;

    public VentanaInicio(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image(Main.class.getResource("/vista/imagenes/Goku/gokuNormal.png").toExternalForm(), 100, 100, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
       this.setBackground(new Background(imagenDeFondo));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");

        BotonJugarEventHandler botonEntrarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonEntrarHandler);
        
        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        
        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        this.getChildren().addAll(botonJugar,botonSalir);
    }

}
