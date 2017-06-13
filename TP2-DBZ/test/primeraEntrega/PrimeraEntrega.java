package primeraEntrega;
/*package personajetests;*/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import personaje.Cell;
import personaje.Gohan;
import personaje.Goku;
import personaje.Personaje;
import tablero.AtaqueNoValido;
import tablero.CasilleroOcupado;
import tablero.MovimientoNoValido;
import tablero.NombreDePersonajeNoValido;
import tablero.Tablero;

public class PrimeraEntrega {
	
	@Test
    public void testUbicarMoverYVerificarNuevaPosicion() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {

        
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        
        personajes.add(testGoku);
        
        Tablero tablero = new Tablero(5, personajes, null, null);
        
        testGoku.casilleroActual = tablero.tablero.get(0).get(0);
        
        tablero.tablero.get(0).get(0).cambiarEstado();
        
        tablero.personajeSeMueveHasta("Goku", tablero.tablero.get(2).get(1));
        
        assertEquals(tablero.tablero.get(2).get(1), testGoku.casilleroActual);
		
	}
	
	@Test(expected=CasilleroOcupado.class)
    public void testDosPersonajesEnUnCasillero() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {

        
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        Cell testCell = new Cell();
        
        personajes.add(testGoku);
        personajes.add(testCell);
        
        Tablero tablero = new Tablero(5, personajes, null, null);
        
        testGoku.casilleroActual = tablero.tablero.get(0).get(0);
        testCell.casilleroActual = tablero.tablero.get(0).get(1);
        
        tablero.tablero.get(0).get(0).cambiarEstado();
        tablero.tablero.get(0).get(1).cambiarEstado();
        
        tablero.personajeSeMueveHasta("Goku", tablero.tablero.get(2).get(1));
        assertEquals(tablero.tablero.get(2).get(1), testGoku.casilleroActual);
        
        //Luego esto tira excepcion
        tablero.personajeSeMueveHasta("Cell", tablero.tablero.get(2).get(1));
	}
	
	@Test(expected=MovimientoNoValido.class)
    public void testUnPersonajeNoPasaPorEncimaDeOtro() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {
		//Para probarlo mejor agrego tres personajes, porque los costos para ir en diagonal son iguales a los de ir en linea
		//recta
        
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        Cell testCell = new Cell();
        Gohan testGohan = new Gohan();
        
        personajes.add(testGoku);
        personajes.add(testCell);
        personajes.add(testGohan);
        
        Tablero tablero = new Tablero(5, personajes, null, null);
        
        testGoku.casilleroActual = tablero.tablero.get(0).get(0);
        testCell.casilleroActual = tablero.tablero.get(0).get(1);
        testGohan.casilleroActual = tablero.tablero.get(1).get(1);
        
        tablero.tablero.get(0).get(0).cambiarEstado();
        tablero.tablero.get(0).get(1).cambiarEstado();
        tablero.tablero.get(1).get(1).cambiarEstado();
        //Si pudiese pasar por encima entonces esto no lanzaria una excepcion (los tiene que rodear)
        tablero.personajeSeMueveHasta("Goku", tablero.tablero.get(0).get(2));
	}
	
	@Test
    public void testPersonajeSeTransforma() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {
        
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        
        personajes.add(testGoku);
        
        Tablero tablero = new Tablero(5, personajes, null, null);
        
        testGoku.casilleroActual = tablero.tablero.get(0).get(0);
        
        tablero.tablero.get(0).get(0).cambiarEstado();
        
        for (int i = 0; i<5; i++){
			testGoku.ganarKi(); //Tengo que hacer que gane ki
        }
        assertTrue(testGoku.puedeEfectuarPrimeraTransformacion());
        testGoku.efectuarPrimeraTransformacion();
        for (int i = 0; i<20; i++)
			testGoku.ganarKi();//Gana ki otra vez
        
        assertTrue(testGoku.puedeEfectuarSegundaTransformacion());//Esto significa que la primera transformacion fue existosa
	}
	
	@Test
    public void testPersonajeSeTransformaYSeMueve() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {
        
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        
        personajes.add(testGoku);
        
        Tablero tablero = new Tablero(5, personajes, null, null);
        
        testGoku.casilleroActual = tablero.tablero.get(0).get(0);
        
        tablero.tablero.get(0).get(0).cambiarEstado();
        
        try{
        	tablero.personajeSeMueveHasta("Goku", tablero.tablero.get(0).get(3));
        }catch(MovimientoNoValido e){
        	System.out.println("No se puede porque Goku tiene 2 de velocidad de Desplazamiento");
        }
        for (int i = 0; i<5; i++){
			testGoku.ganarKi(); //Tengo que hacer que gane ki
        }
        assertTrue(testGoku.puedeEfectuarPrimeraTransformacion());
        testGoku.efectuarPrimeraTransformacion();
        tablero.personajeSeMueveHasta("Goku", tablero.tablero.get(0).get(3));
        assertEquals(tablero.tablero.get(0).get(3), testGoku.casilleroActual);
	}
	
	@Test
    public void testDosPersonajesSeAtacan() throws NombreDePersonajeNoValido, AtaqueNoValido {
		//Para probarlo mejor agrego tres personajes, porque los costos para ir en diagonal son iguales a los de ir en linea
		//recta
        
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        Cell testCell = new Cell();
        
        personajes.add(testGoku);
        personajes.add(testCell);
        
        Tablero tablero = new Tablero(5, personajes, null, null);
        
        testGoku.casilleroActual = tablero.tablero.get(0).get(0);
        testCell.casilleroActual = tablero.tablero.get(0).get(1);

        tablero.personajeUsaAtaqueBasicoContra("Goku", "Cell"); //Dentro del rango
        assertEquals(testCell.obtenerPuntosDeVida(), 480);
        tablero.personajeUsaAtaqueBasicoContra("Cell", "Goku"); //Dentro del rango
        assertEquals(testGoku.obtenerPuntosDeVida(), 480);
        
        testGoku.casilleroActual = tablero.tablero.get(4).get(4); // Alejo un personje, fuera del rango de los dos
        
        try{
        	tablero.personajeUsaAtaqueBasicoContra("Goku", "Cell"); //Fuera del rango
        }catch(AtaqueNoValido e){
        }
        assertEquals(testCell.obtenerPuntosDeVida(), 480); //Siguen igual, no se efectuó el ataque
        
        try{
        	tablero.personajeUsaAtaqueBasicoContra("Cell", "Goku"); //Fuera del rango
        }catch(AtaqueNoValido e){
        }
        assertEquals(testGoku.obtenerPuntosDeVida(), 480); //Siguen igual, no se efectuó el ataque
        
	}
	
	
	
		
        
        
}


