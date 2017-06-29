package vista;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import personaje.Personaje;
import sistema.Sistema;
import tablero.Casillero;
import consumible.*;
import vista.eventos.BotonAtacarHandler;
import vista.eventos.BotonCasilleroHandler;
import vista.eventos.BotonFinalizarTurnoHandler;
import vista.eventos.BotonTransformarHandler;

public class ContenedorPrincipal extends GridPane {

    public Sistema sistema;
    HashMap<Casillero, Button> botonesCasilleros;
    ArrayList<HBox> botonesAccion;
    public ArrayList<Casillero> seleccion;
    public ArrayList<Text> datosPrimerPersonaje;
	public ArrayList<Text> datosSegundoPersonaje;
	private ArrayList<Image> iconos;

    public ContenedorPrincipal(Stage stage, Sistema sistema) {
        this.sistema = sistema;
        this.botonesCasilleros = new HashMap<Casillero, Button>();
        this.botonesAccion = new ArrayList<HBox>();
        this.seleccion = new ArrayList<Casillero>();
        this.datosPrimerPersonaje = new ArrayList<Text>();
        this.datosSegundoPersonaje = new ArrayList<Text>();
        this.iconos = this.cargarIconos();
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
        this.add(scenetitle2, 20, 0, 2, 1);

        for(int x = 0; x < 20; x++){
        	for(int y = 2; y < 22; y++){
        		Button btn = new Button("");
        		btn.setPrefWidth(50);
        		btn.setPrefHeight(50);
        		HBox hbBtn = new HBox(5);
        		hbBtn.setAlignment(Pos.CENTER);
        		hbBtn.getChildren().add(btn);
        		if(this.sistema.getTablero().getCasillero(x, y - 2).estaOcupado()){
        			this.setIcono(btn, this.sistema.getTablero().getCasillero(x, y - 2));
        		}
        		this.add(hbBtn, x, y);
        		botonesCasilleros.put(this.sistema.getTablero().getCasillero(x, y - 2), btn);
        		BotonCasilleroHandler btnCasilleroHandler = new BotonCasilleroHandler(this.sistema.getTablero().getCasillero(x, y - 2), this);
        		btn.setOnAction(btnCasilleroHandler);
        	}
        }
        this.crearBotonFinalizarTurno();
	}
	public void imprimirInfo(Casillero casillero, Integer posY, ArrayList<Text> datosPersonaje, boolean mostrarMovimientoPosible){
		//Imprime la info del personaje seleccionado en el lado derecho
		Personaje personaje = (Personaje) casillero.getPosicionable();
		Text nombre = new Text(String.format("%s", personaje.nombre));
		nombre.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.add(nombre, 23, posY, 2, 1);
		datosPersonaje.add(nombre);
		Text puntosdevida = new Text(String.format("Puntos de vida: %d", personaje.getPuntosDeVida()," / ", personaje.getPuntosDeVidaMaximos()));
		this.add(puntosdevida, 23, posY + 1, 2, 1);
		datosPersonaje.add(puntosdevida);
		Text ki = new Text(String.format("Ki: %d", personaje.getKi()));
		this.add(ki, 23, posY + 2, 2, 1);
		datosPersonaje.add(ki);
		Text velocidad = new Text(String.format("Velocidad: %d", personaje.getVelocidadDeDesplazamiento()));
		this.add(velocidad, 23, posY + 3, 2, 1);
		datosPersonaje.add(velocidad);
		Text poderDePelea = new Text(String.format("Poder de pelea: %d", personaje.getPoderDePelea()));
		this.add(poderDePelea, 23, posY + 4, 2, 1);
		datosPersonaje.add(poderDePelea);
		if(mostrarMovimientoPosible){
			for(Casillero e :botonesCasilleros.keySet()){
				if(casillero.estaEnRango(1, e) && !(casillero.equals(e)) && !(e.estaOcupado())){
					botonesCasilleros.get(e).setStyle("-fx-base: #32CD32;");
				}
			}
			for(Casillero e :botonesCasilleros.keySet()){
				if(casillero.estaEnRango(personaje.getdistanciaDeAtaque(), e) && !(casillero.equals(e)) && !(e.estaOcupado()) && !(casillero.estaEnRango(1, e))){
					botonesCasilleros.get(e).setStyle("-fx-base: #00FFFF;");
				}
			}
		}
	}

	public void limpiarVentanaDelJuego(){
		//Borra la info en el lado derecho y los botones de accion
		for(Text e :datosPrimerPersonaje){
			this.getChildren().remove(e);
		}
		for(Text e :datosSegundoPersonaje){
			this.getChildren().remove(e);
		}
		for(Casillero e :this.botonesCasilleros.keySet()){
			if(botonesCasilleros.get(e).getStyle() == "-fx-base: #32CD32;" || botonesCasilleros.get(e).getStyle() == "-fx-base: #00FFFF;"){
				botonesCasilleros.get(e).setStyle(null);
			}
		}
		for(HBox e :botonesAccion){
			this.getChildren().remove(e);
		}
		this.seleccion.clear();
		this.crearBotonFinalizarTurno();
	}

	public void actualizarVentanaDelJuego(){
		//Actualiza que casilleros estan ocupados
		for(Casillero e :this.botonesCasilleros.keySet()){
			if(e.getPosicionable() != null){
				if (!(e.getPosicionable().esMovible())){
					this.setIconoConsumibles(this.botonesCasilleros.get(e), e);
				}else{
					this.setIcono(this.botonesCasilleros.get(e), e);
				}
			}
			else{
				this.botonesCasilleros.get(e).setGraphic(null);
			}
		}
	}

	private ArrayList<Image> cargarIconos(){
		this.iconos = new ArrayList<Image>();
		Image image = new Image(Main.class.getResource("/vista/imagenes/Goku/gokuNormal.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image);
		Image image1 = new Image(Main.class.getResource("/vista/imagenes/Goku/Goku_Kaioken.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image1);
		Image image2 = new Image(Main.class.getResource("/vista/imagenes/Goku/Super_Saiyan_Goku.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image2);
		Image image3 = new Image(Main.class.getResource("/vista/imagenes/Gohan/Gohan_Normal.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image3);
		Image image4 = new Image(Main.class.getResource("/vista/imagenes/Gohan/Gohan_SuperS.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image4);
		Image image5 = new Image(Main.class.getResource("/vista/imagenes/Gohan/Gohan_SS2.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image5);
		Image image6 = new Image(Main.class.getResource("/vista/imagenes/piccolo/Piccolo_Normal.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image6);
		Image image7 = new Image(Main.class.getResource("/vista/imagenes/piccolo/Piccolo_primera.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image7);
		Image image8 = new Image(Main.class.getResource("/vista/imagenes/piccolo/Piccolo_Segunda.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image8);
		Image image9 = new Image(Main.class.getResource("/vista/imagenes/Cell/Cell_Primera.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image9);
		Image image10 = new Image(Main.class.getResource("/vista/imagenes/Cell/Cell_Semiperfecto.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image10);
		Image image11 = new Image(Main.class.getResource("/vista/imagenes/Cell/Cell_Perfecto.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image11);
		Image image12 = new Image(Main.class.getResource("/vista/imagenes/freezer/Freezer_primera.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image12);
		Image image13 = new Image(Main.class.getResource("/vista/imagenes/freezer/Freezer_segunda_forma.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image13);
		Image image14 = new Image(Main.class.getResource("/vista/imagenes/freezer/freezer_definitivo.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image14);
		Image image15 = new Image(Main.class.getResource("/vista/imagenes/MajinBoo/Majin_buu_Normal.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image15);
		Image image16 = new Image(Main.class.getResource("/vista/imagenes/MajinBoo/MajinBoo_Primera.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image16);
		Image image17 = new Image(Main.class.getResource("/vista/imagenes/MajinBoo/MajinBoo_Ultima.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image17);
		Image image18 = new Image(Main.class.getResource("/vista/imagenes/Consumibles/Nube.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image18);
		Image image19 = new Image(Main.class.getResource("/vista/imagenes/Consumibles/Esfera.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image19);
		Image image20 = new Image(Main.class.getResource("/vista/imagenes/Consumibles/Semilla.png").toExternalForm(), 100, 100, true, true);
		this.iconos.add(image20);
		return iconos;

	}

	private void setIcono(Button btn, Casillero casillero){
		//Selecciona la imagen del personaje correspondiente y la coloca en el boton como fondo
		 Image image = null;
		 ImageView imageView = null;
		 int posEnIconos = 0;
	     if(((Personaje)(casillero).getPosicionable()).nombre == "Goku"){
	    	 posEnIconos = 0;
	     }
	     else if(((Personaje)(casillero).getPosicionable()).nombre == "Gohan"){
	    	 posEnIconos = 3;
	     }
	     else if(((Personaje)(casillero).getPosicionable()).nombre == "Piccolo"){
	    	 posEnIconos = 6;
	     }
	     else if(((Personaje)(casillero).getPosicionable()).nombre == "Cell"){
	    	 posEnIconos = 9;
	     }
	     else if(((Personaje)(casillero).getPosicionable()).nombre == "Freezer"){
	    	 posEnIconos = 12;
	     }
	     else if(((Personaje)(casillero).getPosicionable()).nombre == "MajinBoo"){
	    	 posEnIconos = 15;
	     }
	     image = this.iconos.get(posEnIconos + ((Personaje)(casillero).getPosicionable()).getNumeroDeTransformacion());
	     imageView = new ImageView(image);
	     imageView.setFitWidth(30);
	 	 imageView.setFitHeight(30);
	     btn.setGraphic(imageView);
	}

	private void setIconoConsumibles(Button btn, Casillero casillero){
		//Selecciona la imagen del consumible correspondiente y la coloca en el boton como fondo
		 Image image = null;
		 ImageView imageView = null;
		 int posEnIconos = 0;
	     if(((Consumible)casillero.getPosicionable()).getTipo() == 2){
	    	 posEnIconos = 18;
	     }
	     else if(((Consumible)casillero.getPosicionable()).getTipo() == 1){
	    	 posEnIconos = 19;
	     }
	     else if(((Consumible)casillero.getPosicionable()).getTipo() == 3){
	    	 posEnIconos = 20;
	     }
	     image = this.iconos.get(posEnIconos);
	     imageView = new ImageView(image);
	     imageView.setFitWidth(30);
	 	 imageView.setFitHeight(30);
	     btn.setGraphic(imageView);
	}

	public void crearBotonTransformar(Casillero casillero){
		Button btn = new Button("Transformar");
		btn.setPrefWidth(100);
		HBox hbBtn = new HBox(5);
		hbBtn.setAlignment(Pos.CENTER_LEFT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 23, 14, 1, 1);
		BotonTransformarHandler btnTransformarHandler = new BotonTransformarHandler(casillero, this);
		btn.setOnAction(btnTransformarHandler);
		botonesAccion.add(hbBtn);
	}

	public void crearBotonAtacar(){
		Button btn = new Button("Atacar con basico");
		btn.setPrefWidth(200);
		HBox hbBtn = new HBox(100);
		hbBtn.setAlignment(Pos.CENTER_LEFT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 23, 17, 3, 1);
		Button btn1 = new Button("Atacar con ataque especial");
		btn1.setPrefWidth(200);
		HBox hbBtn1 = new HBox(100);
		hbBtn1.setAlignment(Pos.CENTER_LEFT);
		hbBtn1.getChildren().add(btn1);
		this.add(hbBtn1, 23, 19, 3, 1);
		BotonAtacarHandler btnAtacarEspecialHandler = new BotonAtacarHandler(this, true);
		BotonAtacarHandler btnAtacarBasicoHandler = new BotonAtacarHandler(this, false);
		btn1.setOnAction(btnAtacarEspecialHandler);
		btn.setOnAction(btnAtacarBasicoHandler);
		botonesAccion.add(hbBtn1);
		botonesAccion.add(hbBtn);
	}

	public void crearBotonFinalizarTurno(){
		Button btn = new Button("Finalizar Turno");
		btn.setPrefWidth(200);
		HBox hbBtn = new HBox(5);
		hbBtn.setAlignment(Pos.CENTER);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 21, 21, 2, 1);
		BotonFinalizarTurnoHandler btnFinalizarTurnoHandler = new BotonFinalizarTurnoHandler(this);
		btn.setOnAction(btnFinalizarTurnoHandler);
		botonesAccion.add(hbBtn);
	}

}
