import java.util.ArrayList;

public class Tablero {

    private Casilla[][] casillas;
    private ArrayList<Casilla> minas;
    private int filas;
    private int columnas;
    private int numeroMinas;

    public Tablero(int filas, int columnas, int numeroMinas) {

        this.filas = filas;
        this.columnas = columnas;
        this.numeroMinas = numeroMinas;
        this.casillas = new Casilla[filas][columnas];
        this.minas = new ArrayList<Casilla>();
        generarTablero();
        generarMinas();
        generarNumerosAlrededor();

    }

    private void generarTablero() {
    
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                casillas[i][j] = new Casilla(i, j, false, 0, false, 'O');

            }

        }

    }

    private void generarMinas() {

        int minasGeneradas = 0;

        while (minasGeneradas < numeroMinas) {

            int x = (int) (Math.random() * filas);
            int y = (int) (Math.random() * columnas);

            if (!casillas[x][y].isMina()) {

                minas.add(casillas[x][y]);

                casillas[x][y].setMina(true);
                casillas[x][y].setSimbolo('X');
                minasGeneradas++;

            }

        }

    }

    private void generarNumerosAlrededor() {

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (casillas[i][j].isMina()) {

                    ArrayList<Casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);

                    for (Casilla casilla : casillasAlrededor) {

                        if(casilla.isMina())
                            continue;

                        casilla.incrementarNumeroMinasAlrededor();
                        casilla.setSimbolo((char) (casilla.getNumeroMinasAlrededor() + '0'));

                    }

                }

            }

        }

    }

    private ArrayList<Casilla> obtenerCasillasAlrededor(int fila, int columna) {

        ArrayList<Casilla> casillasAlrededor = new ArrayList<Casilla>();

        for(int i = 0; i < 8; i++) {

            try {

                int tmpFila = fila;
                int tmpColumna = columna;

                switch(i) {


                    case 0:
                        tmpFila--;
                    break;
                        
                    case 1:
                        tmpFila--;
                        tmpColumna++;
                    break;

                    case 2:
                        tmpColumna++;
                    break;

                    case 3:
                        tmpFila++;
                        tmpColumna++;
                    break;

                    case 4:
                        tmpFila++;
                    break;

                    case 5:
                        tmpFila++;
                        tmpColumna--;
                    break;

                    case 6:
                        tmpColumna--;
                    break;

                    case 7:
                        tmpFila--;
                        tmpColumna--;
                    break;

                }

                casillasAlrededor.add(casillas[tmpFila][tmpColumna]);
            
            } catch (Exception e) {}

        }

        return casillasAlrededor;

    }

    public void imprimirTablero() {

        for (int i = 0; i < filas; i++) {

            // Imprimir numeros de columnas
            if(i == 0) {

                imprimirColumnas();

            }

            for (int j = 0; j < columnas; j++) {

                if(!casillas[i][j].isDescubierta())
                    System.out.print("- ");
                else
                    System.out.print(casillas[i][j].getSimbolo() + " ");

            }

            // Imprimir n??mero de filas
            System.out.print("  " + (i + 1));

            System.out.println();

        }

    }

    public void imprimirTableroPerdio() {

        for (int i = 0; i < filas; i++) {

            // Imprimir numeros de columnas
            if(i == 0) {

                imprimirColumnas();

            }

            for (int j = 0; j < columnas; j++) {

                if(!casillas[i][j].isDescubierta() && !casillas[i][j].isMina())
                    System.out.print("- ");
                else if(casillas[i][j].isMina())
                    System.out.print("X ");
                else
                    System.out.print(casillas[i][j].getSimbolo() + " ");

            }

            // Imprimir n??mero de filas
            System.out.print("  " + (i + 1));

            System.out.println();

        }

    }

    private void imprimirColumnas() {

        for (int j = 1; j < columnas + 1; j++) {

            System.out.print(j + " ");

        }

        System.out.println("\n");

    }

    public void descubrirCasillas(int fila, int columna) {

        if(casillas[fila][columna].isDescubierta()) {

            return;

        }

        casillas[fila][columna].setDescubierta(true);

        if(casillas[fila][columna].isMina()) {

            return;

        }

        if (casillas[fila][columna].getNumeroMinasAlrededor() > 0) {

            casillas[fila][columna].setDescubierta(true);
            return;

        }

        ArrayList<Casilla> casillasAlrededor = obtenerCasillasAlrededor(fila, columna);

        for (Casilla casilla : casillasAlrededor) {

            if (!casilla.isDescubierta()) {

                descubrirCasillas(casilla.getFila(), casilla.getColumna());

            }

        }

    }

    public boolean ganoPartida() {

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (!casillas[i][j].isDescubierta() && !casillas[i][j].isMina()) {

                    return false;

                }

            }

        }

        return true;

    }

    public Casilla getCasilla(int fila, int columna) {

        return casillas[fila][columna];

    }

}
