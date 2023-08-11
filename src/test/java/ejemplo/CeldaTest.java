package ejemplo;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

import org.junit.Test;

public class CeldaTest {

    private Celda celda;

    @Before
    public void setUp() {
        celda = new Celda();
    }

    @Test
    public void testInicializacionCelda() {
        assertEquals("", celda.getContenido());
    }

    @Test
    public void testSetContenido() {
        celda.setContenido("Hola");
        assertEquals("Hola", celda.getContenido());
    }

    @Test
    public void testReemplazarContenido() {
        celda.setContenido("Hola");
        celda.setContenido("Adiós");
        assertEquals("Adiós", celda.getContenido());
    }

    @Test
    public void testBorrarContenido() {
        celda.setContenido("Hola");
        celda.setContenido("");
        assertEquals("", celda.getContenido());
    }

}
