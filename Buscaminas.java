import java.util.Scanner;

public class Buscaminas {

    public static void main(String [] args) {

        int filas = pedirNumeroPorTeclado("Introduce el número de filas: ");
        int columnas = pedirNumeroPorTeclado("Introduce el número de columnas: ");
        int minas = pedirNumeroMinasPorTeclado(filas, columnas, "Introduce el número de minas: ");

        Tablero tablero = new Tablero(filas, columnas, minas);

        while(true) {

            tablero.imprimirTablero();

            int fila = pedirNumeroPorTecladoValidado(filas, "Introduce la fila: ");
            int columna = pedirNumeroPorTecladoValidado(columnas, "Introduce la columna: ");

            if(tablero.getCasilla(fila, columna).isDescubierta()) {

                System.out.println("\nLa casilla ya está descubierta, favor de introducir otra casilla\n");
                continue;

            }

            if (tablero.getCasilla(fila, columna).isMina()) {

                tablero.imprimirTableroPerdio();
                System.out.println("\nHas perdido\n");
                break;

            }

            tablero.descubrirCasillas(fila, columna);

            if(tablero.ganoPartida()) {
                    
                tablero.imprimirTablero();
                System.out.println("\nHas ganado\n");
                break;

            }

        }

    }

    public static int pedirNumeroPorTeclado(String mensaje) {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        while(true) {
            
            System.out.print(mensaje);

            try {

                numero = Integer.parseInt(entrada.nextLine());

                if(numero <= 0) {
                        
                    System.out.println("\nIntroduce un número mayor que 0\n");
                    continue;
                }

                break;
    
            } catch (Exception e) {
        
                    System.out.println("\nIntroduce un número válido\n");
    
            }

        }

        return numero;

    }

    public static int pedirNumeroMinasPorTeclado(int filas, int columnas, String mensaje) {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        while(true) {
            
            System.out.print(mensaje);

            try {

                numero = Integer.parseInt(entrada.nextLine());

                if(numero <= 0 || numero >= (filas * columnas)) {
                        
                    System.out.println("\nIntroduce un número mayor que 0 y menor que " + (filas * columnas) + "\n");
                    continue;
                }

                break;
    
            } catch (Exception e) {
        
                    System.out.println("\nIntroduce un número válido\n");
    
            }

        }

        return numero;

    }

    public static int pedirNumeroPorTecladoValidado(int filaColumna, String mensaje) {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        while(true) {

            System.out.print(mensaje);

            try {

                numero = Integer.parseInt(entrada.nextLine());

                if((numero - 1) < 0 || (numero - 1) >= filaColumna) {
                        
                    System.out.println("\nIntroduce un número entre 1 y " + filaColumna +"\n");
                    continue;
                }

                break;
    
            } catch (Exception e) {
        
                    System.out.println("\nIntroduce un número válidon\n");
    
            }

        }

        return numero - 1;

    }
    
}
