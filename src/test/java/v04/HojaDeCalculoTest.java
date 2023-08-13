package v04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HojaDeCalculoTest {

    private HojaDeCalculo hoja;

    @Before
    public void setUp() {
        hoja = new HojaDeCalculo(10, 10);
    }

    @Test
    public void testInicializacion() {
        for (int i = 0; i < hoja.getNumeroDeFilas(); i++) {
            for (int j = 0; j < hoja.getNumeroDeColumnas(); j++) {
                assertEquals("", hoja.getCelda(i, j).getContenido());
            }
        }
    }

    @Test
    public void testSetYGetContenidoCelda() {
        hoja.getCelda(5, 5).setContenido("Prueba");
        assertEquals("Prueba", hoja.getCelda(5, 5).getContenido());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAccesoFueraDeLimites() {
        hoja.getCelda(11, 11);
    }

    @Test
    public void testGetNumeroDeFilas() {
        assertEquals(10, hoja.getNumeroDeFilas());
    }

    @Test
    public void testGetNumeroDeColumnas() {
        assertEquals(10, hoja.getNumeroDeColumnas());
    }
}
