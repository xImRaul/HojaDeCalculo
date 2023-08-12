package v03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NavegadorTest {
    private HojaDeCalculo hoja;
    private Navegador navegador;

    @Before
    public void setUp() {
        hoja = new HojaDeCalculo(5, 5);
        navegador = new Navegador(hoja);
    }

    @Test
    public void testInicializacion() {
        assertEquals(hoja.getCelda(0, 0), navegador.getCeldaActual());
    }

    @Test
    public void testMoverArribaLimite() {
        navegador.moverArriba();
        assertEquals(hoja.getCelda(0, 0), navegador.getCeldaActual());
    }

    @Test
    public void testMoverAbajoLimite() {
        for (int i = 0; i < 5; i++) {
            navegador.moverAbajo();
        }
        assertEquals(hoja.getCelda(4, 0), navegador.getCeldaActual());
        navegador.moverAbajo();
        assertEquals(hoja.getCelda(4, 0), navegador.getCeldaActual());
    }

    @Test
    public void testMoverIzquierdaLimite() {
        navegador.moverIzquierda();
        assertEquals(hoja.getCelda(0, 0), navegador.getCeldaActual());
    }

    @Test
    public void testMoverDerechaLimite() {
        for (int i = 0; i < 5; i++) {
            navegador.moverDerecha();
        }
        assertEquals(hoja.getCelda(0, 4), navegador.getCeldaActual());
        navegador.moverDerecha();
        assertEquals(hoja.getCelda(0, 4), navegador.getCeldaActual());
    }

    @Test
    public void testMoversePorElCentro() {
        navegador.moverDerecha();
        navegador.moverAbajo();
        assertEquals(hoja.getCelda(1, 1), navegador.getCeldaActual());
    }
}