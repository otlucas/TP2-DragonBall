package primeraEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import sistema.*;
import personaje.*;
import tablero.*;

public class PrimeraEntrega {
	
	Goku testGoku = new Goku();
	Cell testCell = new Cell();
    
    Tablero tablero = new Tablero(5);
	
	@Test
    public void testUbicarMoverYVerificarNuevaPosicion() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {


        assertTrue(tablero.posicionar(testGoku, 0, 0));
		
	}
	
	@Test
    public void testDosPersonajesEnUnCasillero() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {

        tablero.posicionar(testGoku, 0, 0);
        assertFalse(tablero.posicionar(testCell, 0, 0));
	}
	
	@Test(expected=CasilleroOcupado.class)
    public void testUnPersonajeNoPasaPorEncimaDeOtro() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido {
        
        tablero.posicionar(testGoku, 0, 0);
        tablero.posicionar(testCell, 0, 1);
        
        //Si pudiese pasar por encima entonces esto no lanzaria una excepcion
        tablero.mover(tablero.getCasillero(0,0),tablero.getCasillero(0,1));
	}
	
	@Test
    public void testPersonajeSeTransforma() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido, CondicionesInsuficientes {
        
        tablero.posicionar(testGoku, 0, 0);
        
        for (int i = 0; i<5; i++)
			testGoku.ganarKi();
     
        assertTrue(testGoku.puedeTransformarse());
        testGoku.transformarse();
        for (int i = 0; i<20; i++)
			testGoku.ganarKi();
        
        assertTrue(testGoku.puedeTransformarse());
	}
	
	@Test
    public void testPersonajeSeTransformaYSeMueve() throws MovimientoNoValido, CasilleroOcupado, NombreDePersonajeNoValido, CondicionesInsuficientes {
        
        tablero.posicionar(testGoku, 0, 0);
        
        for (int i = 0; i<5; i++)
			testGoku.ganarKi();

        assertTrue(testGoku.puedeTransformarse());
        testGoku.transformarse();
        tablero.mover((tablero.getCasillero(0,0)),(tablero.getCasillero(0,1)));
        assertTrue((tablero.getCasillero(0,1)).estaOcupado());
        
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
        
        tablero.posicionar(testGoku, 0, 0);
        tablero.posicionar(testCell, 0, 1);

        sistema.atacar(tablero.getCasillero(0,0), tablero.getCasillero(0,1), false); //Dentro del rango
        assertEquals(testCell.getPuntosDeVida(), 480);
        sistema.atacar(tablero.getCasillero(0,1), tablero.getCasillero(0,0), false); //Dentro del rango
        assertEquals(testGoku.getPuntosDeVida(), 480);
        
        tablero.mover(tablero.getCasillero(0,0), tablero.getCasillero(1,1)); // Alejo un personaje fuera de su rango
        tablero.mover(tablero.getCasillero(1,1), tablero.getCasillero(1,2));
        tablero.mover(tablero.getCasillero(1,2), tablero.getCasillero(1,3));
        tablero.mover(tablero.getCasillero(1,3), tablero.getCasillero(1,4));
        tablero.mover(tablero.getCasillero(1,4), tablero.getCasillero(1,5));
        tablero.mover(tablero.getCasillero(1,5), tablero.getCasillero(1,6));
        tablero.mover(tablero.getCasillero(1,6), tablero.getCasillero(1,7));
        
        try{
        	 sistema.atacar(tablero.getCasillero(1,7), tablero.getCasillero(0,1), false); //Fuera del rango
        }catch(AtaqueNoValido e){
        }
        assertEquals(testCell.getPuntosDeVida(), 480); //Siguen igual, no se efectuo el ataque
        
        try{
        	sistema.atacar(tablero.getCasillero(0,1), tablero.getCasillero(1,7), false); //Fuera del rango
        }catch(AtaqueNoValido e){
        }
        assertEquals(testGoku.getPuntosDeVida(), 480); //Siguen igual, no se efectuo el ataque
	}

}