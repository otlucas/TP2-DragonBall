package tablero;

import personaje.Personaje;
import java.util.HashMap;

public class Equipo {
	
	private String nombre;
	private int cantidadDeEsferasDelDragon = 0;
	private HashMap<String, Personaje> integrantes;
	
	public Equipo(String nombre){
		this.nombre = nombre;
		this.integrantes = new HashMap<String, Personaje>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void agregarPersonaje(Personaje personaje){
		integrantes.put(personaje.nombre, personaje);
	}
	
	public void incrementarEsferasDelDragon(){
		cantidadDeEsferasDelDragon++;
	}
	
	public int contarEsferasDelDragon(){
		return cantidadDeEsferasDelDragon;
	}

	public HashMap<String, Personaje> getIntegrantes() {
		return integrantes;
	}

	public boolean perdio(){
		for(Personaje p: integrantes.values()){
			if(!p.estaMuerto()) return false;
		}
		return true;
	}
}
