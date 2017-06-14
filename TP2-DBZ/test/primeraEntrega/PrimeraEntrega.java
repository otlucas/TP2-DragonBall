

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import sistema.AtaqueNoValido;
import sistema.Sistema;
import personaje.Cell;
import personaje.Gohan;
import personaje.Goku;
import personaje.Personaje;
import tablero.CasilleroOcupado;
import tablero.MovimientoNoValido;
import tablero.NombreDePersonajeNoValido;
import tablero.Tablero;

public class PrimeraEntrega {
	
	@Test
    public void testUbicarMoverYVerificarNuevaPosicion() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {

        
        Goku testGoku = new Goku();
        
        Tablero tablero = new Tablero(5);
        
        assertTrue(tablero.posicionar(testGoku, tablero.getTablero()[0][0]));
		
	}
	
	@Test
    public void testDosPersonajesEnUnCasillero() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {

        
        Goku testGoku = new Goku();
        Cell testCell = new Cell();
        
        Tablero tablero = new Tablero(5);
        
        tablero.posicionar(testGoku, tablero.getTablero()[0][0]);
        assertFalse(tablero.posicionar(testCell, tablero.getTablero()[0][0]));
	}
	
	@Test(expected=CasilleroOcupado.class)
    public void testUnPersonajeNoPasaPorEncimaDeOtro() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {
        
        Goku testGoku = new Goku();
        Cell testCell = new Cell();
        
        Tablero tablero = new Tablero(5);
        
        tablero.posicionar(testGoku, tablero.getTablero()[0][0]);
        tablero.posicionar(testCell, tablero.getTablero()[0][1]);
        
        
        //Si pudiese pasar por encima entonces esto no lanzaria una excepcion
        tablero.mover(tablero.getTablero()[0][0], tablero.getTablero()[0][1]);
	}
	
	@Test
    public void testPersonajeSeTransforma() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {
        
        Goku testGoku = new Goku();
        
        Tablero tablero = new Tablero(5);
        
        tablero.posicionar(testGoku, tablero.getTablero()[0][0]);
        
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
        
        Goku testGoku = new Goku();
        
        Tablero tablero = new Tablero(5);
        
        tablero.posicionar(testGoku, tablero.getTablero()[0][0]);
        
        for (int i = 0; i<5; i++){
			testGoku.ganarKi(); //Tengo que hacer que gane ki
        }
        assertTrue(testGoku.puedeEfectuarPrimeraTransformacion());
        testGoku.efectuarPrimeraTransformacion();
        tablero.mover(tablero.getTablero()[0][0], tablero.getTablero()[0][1]);
        assertTrue(tablero.getTablero()[0][1].estaOcupado());
        
	}
	
	@Test
    public void testDosPersonajesSeAtacan() throws Exception {

        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        Goku testGoku = new Goku();
        Cell testCell = new Cell();
        
        personajes.add(testCell);
        personajes.add(testGoku);
                
        Tablero tablero = new Tablero(8);
        
        Sistema sistema = new Sistema(personajes, null, null, tablero);
        
        tablero.posicionar(testGoku, tablero.getTablero()[0][0]);
        tablero.posicionar(testCell, tablero.getTablero()[0][1]);

        sistema.atacar(tablero.getTablero()[0][0], tablero.getTablero()[0][1], false); //Dentro del rango
        assertEquals(testCell.obtenerPuntosDeVida(), 480);
        sistema.atacar(tablero.getTablero()[0][1], tablero.getTablero()[0][0], false); //Dentro del rango
        assertEquals(testGoku.obtenerPuntosDeVida(), 480);
        
        tablero.mover(tablero.getTablero()[0][0], tablero.getTablero()[1][1]); // Alejo un personaje fuera de su rango
        tablero.mover(tablero.getTablero()[1][1], tablero.getTablero()[1][2]);
        tablero.mover(tablero.getTablero()[1][2], tablero.getTablero()[1][3]);
        tablero.mover(tablero.getTablero()[1][3], tablero.getTablero()[1][4]);
        tablero.mover(tablero.getTablero()[1][4], tablero.getTablero()[1][5]);
        tablero.mover(tablero.getTablero()[1][5], tablero.getTablero()[1][6]);
        tablero.mover(tablero.getTablero()[1][6], tablero.getTablero()[1][7]);
        
        try{
        	 sistema.atacar(tablero.getTablero()[1][7], tablero.getTablero()[0][1], false); //Fuera del rango
        }catch(AtaqueNoValido e){
        }
        assertEquals(testCell.obtenerPuntosDeVida(), 480); //Siguen igual, no se efectuó el ataque
        
        try{
        	sistema.atacar(tablero.getTablero()[0][1], tablero.getTablero()[1][7], false); //Fuera del rango
        }catch(AtaqueNoValido e){
        }
        assertEquals(testGoku.obtenerPuntosDeVida(), 480); //Siguen igual, no se efectuó el ataque
        
	}
	
	
	
		
        
        
}


