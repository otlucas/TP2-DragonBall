package tablero;

import personaje.Personaje;
import java.util.List;
import java.util.ArrayList;

public class Equipo {
	
	private String nombre;
	private int cantidadDeEsferasDelDragon = 0;
	private List<Personaje> integrantes;
	
	public Equipo(String nombre){
		this.nombre = nombre;
		this.integrantes = new ArrayList<Personaje>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void agregarPersonaje(Personaje personaje){
		integrantes.add(personaje);
	}
	
	public void incrementarEsferasDelDragon(){
		cantidadDeEsferasDelDragon++;
	}
	
	public int contarEsferasDelDragon(){
		return cantidadDeEsferasDelDragon;
	}

	public List<Personaje> getIntegrantes() {
		return integrantes;
	}

	public boolean perdio(){
		for(Personaje p: integrantes){
			if(!p.estaMuerto()) return false;
		}
		return true;
	}
}
