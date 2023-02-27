public class Casilla {

    private int fila;
    private int columna;
    private boolean mina;
    private int numeroMinasAlrededor;
    private boolean descubierta;
    private char simbolo;

    public Casilla(int fila, int columna, boolean mina, int numeroMinasAlrededor, boolean descubierta, char simbolo) {

        this.fila = fila;
        this.columna = columna;
        this.mina = mina;
        this.numeroMinasAlrededor = numeroMinasAlrededor;
        this.descubierta = descubierta;
        this.simbolo = simbolo;

    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public void setNumeroMinasAlrededor(int numeroMinasAlrededor) {
        this.numeroMinasAlrededor = numeroMinasAlrededor;
    }

    public void incrementarNumeroMinasAlrededor() {
        this.numeroMinasAlrededor++;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
}
