package abd_p1;

public class NuestroRegistro {
    
    private byte estado;
    private byte id;
    
    // Dato
    private char[] anotacion;
    private int val1;
    private int val2;
    private double val4;
    private double val5;

    public NuestroRegistro(byte estado, byte id, int val1, int val2, double val3, double val4) {
        this.anotacion = new char[40];
        this.estado = estado;
        this.id = id;
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
    }

    public NuestroRegistro() {
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public void setAnotacion(char[] anotacion) {
        this.anotacion = anotacion;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public void setVal3(double val3) {
        this.val3 = val3;
    }

    public void setVal4(double val4) {
        this.val4 = val4;
    }

    public boolean isEstado() {
        return estado;
    }

    public char getId() {
        return id;
    }

    public char[] getAnotacion() {
        return anotacion;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public double getVal3() {
        return val4;
    }

    public double getVal4() {
        return val5;
    }

    
}
