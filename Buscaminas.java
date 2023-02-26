import java.util.Scanner;

public class Buscaminas {

    public static void main(String [] args) {

        System.out.print("Introduce el número de filas: ");
        int filas = pedirNumeroPorTeclado();
        System.out.print("Introduce el número de columnas: ");
        int columnas = pedirNumeroPorTeclado();
        System.out.print("Introduce el número de minas: ");
        int minas = pedirNumeroPorTeclado();

        Tablero tablero = new Tablero(filas, columnas, minas);

        while(true) {

            tablero.imprimirTablero();

            System.out.print("Introduce la fila: ");
            int fila = pedirNumeroPorTecladoValidado(filas);
            System.out.print("Introduce la columna: ");
            int columna = pedirNumeroPorTecladoValidado(columnas);

            if (tablero.getCasillas(fila, columna).isMina()) {

                tablero.imprimirTableroPerdio();
                System.out.println("Has perdido");
                break;

            }

            tablero.descubrirCasillas(fila, columna);

            if(tablero.ganoPartida()) {
                    
                tablero.imprimirTablero();
                System.out.println("Has ganado");
                break;

            }

        }

    }

    public static int pedirNumeroPorTeclado() {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        while(true) {

            try {

                numero = Integer.parseInt(entrada.nextLine());

                if(numero <= 0) {
                        
                    System.out.println("Introduce un número mayor que 0");
                    continue;
                }

                break;
    
            } catch (Exception e) {
        
                    System.out.println("Introduce un número válido");
    
            }

        }

        return numero;

    }

    public static int pedirNumeroPorTecladoValidado(int filaColumna) {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        while(true) {

            try {

                numero = Integer.parseInt(entrada.nextLine());

                if(numero < 0 || numero >= filaColumna) {
                        
                    System.out.println("Introduce un número entre 0 y " + (filaColumna - 1));
                    continue;
                }

                break;
    
            } catch (Exception e) {
        
                    System.out.println("Introduce un número válido");
    
            }

        }

        return numero;

    }
    
}
