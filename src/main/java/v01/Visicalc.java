package v01;
import java.util.Scanner;

public class Visicalc {

    private static final int FILAS = 15;
    private static final int COLUMNAS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] hojaCalculo = new String[FILAS][COLUMNAS];
        inicializarHojaCalculo(hojaCalculo);

        int[] posicion = { 0, 0 };
        boolean estaOperativo = true;

        while (estaOperativo) {
            imprimirCabecerasColumnas();
            imprimirRegla();
            imprimirContenido(hojaCalculo, posicion);
            imprimirRegla();
            imprimirOpciones(posicion);

            char comando = scanner.next().toUpperCase().charAt(0);

            estaOperativo = procesarComando(comando, hojaCalculo, posicion);
        }

        scanner.close();
    }

    private static void inicializarHojaCalculo(String[][] hojaCalculo) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                hojaCalculo[i][j] = "";
            }
        }
    }

    private static void imprimirCabecerasColumnas() {
        System.out.print("      ");
        for (int j = 0; j < COLUMNAS; j++) {
            char letraColumna = (char) ('A' + j);
            System.out.printf("%-8s", letraColumna);
        }
        System.out.println();
    }

    private static void imprimirRegla() {
        System.out.print("     +");
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print("-------+");
        }
        System.out.println();
    }

    private static void imprimirContenido(String[][] hojaCalculo, int[] posicion) {
        int filaActual = posicion[0];
        int columnaActual = posicion[1];

        for (int i = 0; i < FILAS; i++) {
            System.out.printf("%-5d|", i + 1);

            for (int j = 0; j < COLUMNAS; j++) {
                String celda = hojaCalculo[i][j];
                celda = celda.length() > 5 ? celda.substring(0, 5) : String.format("%-5s", celda);

                if (i == filaActual && j == columnaActual) {
                    celda = "[" + celda + "]";
                } else {
                    celda = " " + celda + " ";
                }

                System.out.print(celda + "|");
            }
            System.out.println();
        }
    }

    private static void imprimirOpciones(int[] posicion) {
        int filaActual = posicion[0];
        int columnaActual = posicion[1];

        System.out.println("Ayuda visual: Celda actual -> [" + (char) ('A' + columnaActual) + (filaActual + 1) + "]");
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione 'E' para ingresar texto en la celda actual.");
        System.out.println("Presione 'Q' para salir.");
    }

    private static boolean procesarComando(char comando, String[][] hojaCalculo, int[] posicion) {
        int filaActual = posicion[0];
        int columnaActual = posicion[1];

        switch (comando) {
            case 'W':
                filaActual = Math.max(filaActual - 1, 0);
                break;
            case 'A':
                columnaActual = Math.max(columnaActual - 1, 0);
                break;
            case 'S':
                filaActual = Math.min(filaActual + 1, FILAS - 1);
                break;
            case 'D':
                columnaActual = Math.min(columnaActual + 1, COLUMNAS - 1);
                break;
            case 'E':
                ingresarTextoEnCelda(hojaCalculo, filaActual, columnaActual);
                break;
            case 'Q':
                System.out.println("Saliendo del programa.");
                return false;
            default:
                System.out.println("Comando inválido. Intente nuevamente.");
        }

        posicion[0] = filaActual;
        posicion[1] = columnaActual;

        return true;
    }

    private static void ingresarTextoEnCelda(String[][] hoja, int filaActual, int columnaActual) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el texto para la celda [" + (char) ('A' + columnaActual) + (filaActual + 1) + "]:");
        String texto = scanner.next();
        hoja[filaActual][columnaActual] = texto;
        scanner.close();
    }
}
