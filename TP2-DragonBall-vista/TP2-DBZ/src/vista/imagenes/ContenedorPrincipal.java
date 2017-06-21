package vista.imagenes;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import personaje.Personaje;
import sistema.Sistema;
import tablero.Casillero;
import vista.eventos.BotonCasilleroHandler;

public class ContenedorPrincipal extends GridPane {

    public Sistema sistema;
    HashMap<Casillero, Button> botonesCasilleros;
    public ArrayList<Casillero> seleccion;
    public ArrayList<Text> datosPrimerPersonaje;
	public ArrayList<Text> datosSegundoPersonaje;

    public ContenedorPrincipal(Stage stage, Sistema sistema) {
        this.sistema = sistema;
        this.botonesCasilleros = new HashMap<Casillero, Button>();
        this.seleccion = new ArrayList<Casillero>();
        this.datosPrimerPersonaje = new ArrayList<Text>();
        this.datosSegundoPersonaje = new ArrayList<Text>();
        this.setGrid(sistema);
    }

	private void setGrid(Sistema sistema) {
        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(1);
        this.setVgap(1);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Dragon Ball FighterZ (Alfa)");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(scenetitle, 5, 0, 9, 1);
        Text scenetitle1 = new Text("Tablero");
        scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        this.add(scenetitle1, 0, 1, 2, 1);

        Text scenetitle2 = new Text("Seleccionados:");
        scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        this.add(scenetitle2, 25, 0, 2, 1);

        for(int x = 0; x < 20; x++){
        	for(int y = 2; y < 22; y++){
        		Button btn = new Button("");
        		btn.setPrefWidth(30);
        		HBox hbBtn = new HBox(5);
        		hbBtn.setAlignment(Pos.CENTER);
        		hbBtn.getChildren().add(btn);
        		if(this.sistema.tablero.getTablero()[x][y - 2].estaOcupado()){
        			btn.setStyle("-fx-base: #ff0000;");
        		}
        		this.add(hbBtn, x, y);
        		botonesCasilleros.put(this.sistema.tablero.getTablero()[x][y - 2], btn);
        		BotonCasilleroHandler btnCasilleroHandler = new BotonCasilleroHandler(this.sistema.tablero.getTablero()[x][y - 2], this);
        		btn.setOnAction(btnCasilleroHandler);
        	}
        }
	}
	public void imprimirInfo(Casillero casillero, Integer posY, ArrayList<Text> datosPersonaje, boolean mostrarMovimientoPosible){
		//Imprime la info del personaje seleccionado en el lado derecho
		Personaje personaje = (Personaje) casillero.getPosicionable();
		Text nombre = new Text(String.format("%s", personaje.nombre));
		nombre.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.add(nombre, 34, posY, 2, 1);
		datosPersonaje.add(nombre);
		Text puntosdevida = new Text(String.format("Puntos de vida: %d", personaje.obtenerPuntosDeVida()));
		this.add(puntosdevida, 34, posY + 1, 2, 1);
		datosPersonaje.add(puntosdevida);
		Text velocidad = new Text(String.format("Velocidad: %d", personaje.getVelocidadDeDesplazamiento()));
		this.add(velocidad, 34, posY + 2, 2, 1);
		datosPersonaje.add(velocidad);
		Text poderDePelea = new Text(String.format("Poder de pelea: %d", personaje.getPoderDePelea()));
		this.add(poderDePelea, 34, posY + 3, 2, 1);
		datosPersonaje.add(poderDePelea);
		if(mostrarMovimientoPosible){
			for(Casillero e :botonesCasilleros.keySet()){
				if(casillero.estaEnRango(1, e) && !(casillero.equals(e)) && !(e.estaOcupado())){
					botonesCasilleros.get(e).setStyle("-fx-base: #32CD32;");
				}
			}
		}
	}

	public void limpiarVentanaDelJuego(){
		//Borra la info del prsonaje seleccionado en el lado derecho
		for(Text e :datosPrimerPersonaje){
			this.getChildren().remove(e);
		}
		for(Text e :datosSegundoPersonaje){
			this.getChildren().remove(e);
		}
		for(Casillero e :this.botonesCasilleros.keySet()){
			if(botonesCasilleros.get(e).getStyle() == "-fx-base: #32CD32;"){
				botonesCasilleros.get(e).setStyle(null);
			}
		}
		this.seleccion.clear();
	}

	public void actualizarVentanaDelJuego(){
		//Actualiza que casilleros estan ocupados
		for(Casillero e :this.botonesCasilleros.keySet()){
			if(e.estaOcupado()){
				this.botonesCasilleros.get(e).setStyle("-fx-base: #ff0000;");
			}else{
				this.botonesCasilleros.get(e).setStyle(null);
			}
		}
	}


}
