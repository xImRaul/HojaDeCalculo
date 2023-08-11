package ejemplo;

import java.util.Scanner;

public class VisiCalcUI {
    private HojaDeCalculo hoja;
    private Navegador navegador;
    private Scanner scanner;

    public VisiCalcUI(HojaDeCalculo hoja) {
        this.hoja = hoja;
        this.navegador = new Navegador(hoja);
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean estaOperativo = true;

        while (estaOperativo) {
            mostrarHoja();
            mostrarOpciones();

            char comando = scanner.next().toUpperCase().charAt(0);
            estaOperativo = procesarComando(comando);
        }

        System.out.println("Saliendo del programa.");
        scanner.close();
    }

    private void mostrarHoja() {
        System.out.print("      ");
        for (int j = 0; j < hoja.getNumeroDeColumnas(); j++) {
            char letraColumna = (char) ('A' + j);
            System.out.printf("%-8s", letraColumna);
        }
        System.out.println();

        for (int i = 0; i < hoja.getNumeroDeFilas(); i++) {
            System.out.printf("%-5d|", i + 1);

            for (int j = 0; j < hoja.getNumeroDeColumnas(); j++) {
                String contenidoCelda = hoja.getCelda(i, j).getContenido();
                contenidoCelda = contenidoCelda.length() > 5 ? contenidoCelda.substring(0, 5)
                        : String.format("%-5s", contenidoCelda);
                System.out.print(" " + contenidoCelda + " |");
            }

            System.out.println();
        }
    }

    private void mostrarOpciones() {
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione 'E' para ingresar texto en la celda actual.");
        System.out.println("Presione 'Q' para salir.");
    }

    private boolean procesarComando(char comando) {
        switch (comando) {
            case 'W':
                navegador.moverArriba();
                break;
            case 'A':
                navegador.moverIzquierda();
                break;
            case 'S':
                navegador.moverAbajo();
                break;
            case 'D':
                navegador.moverDerecha();
                break;
            case 'E':
                editarCeldaActual();
                break;
            case 'Q':
                return false;
            default:
                System.out.println("Comando inválido. Intente nuevamente.");
        }
        return true;
    }

    private void editarCeldaActual() {
        Celda celdaActual = navegador.getCeldaActual();
        System.out.println("Ingrese el texto para la celda seleccionada:");
        String texto = scanner.next();
        celdaActual.setContenido(texto);
    }
}
