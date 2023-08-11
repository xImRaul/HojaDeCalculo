package ejemplo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VisiCalcUITest {

    private VisiCalcUI ui;
    private HojaDeCalculo hoja;
    private Navegador navegador;

    @Before
    public void setUp() {
        hoja = new HojaDeCalculo(10, 10);
        ui = new VisiCalcUI(hoja);
        navegador = new Navegador(hoja);
    }

}
