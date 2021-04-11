/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd_p1;

/**
 *
 * @author Alberto
 */
public class NuestroRegistro {
    
    private boolean estado;
    private char id;
    
    // Dato
    private char[] anotacion;
    private int val1;
    private int val2;
    private int val3;
    private double val4;
    private double val5;

    public NuestroRegistro(boolean estado, char id, int val1, int val2, int val3, double val4, double val5) {
        this.anotacion = new char[40];
        this.estado = estado;
        this.id = id;
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
        this.val5 = val5;
    }

    public NuestroRegistro() {
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setId(char id) {
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

    public void setVal3(int val3) {
        this.val3 = val3;
    }

    public void setVal4(double val4) {
        this.val4 = val4;
    }

    public void setVal5(double val5) {
        this.val5 = val5;
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

    public int getVal3() {
        return val3;
    }

    public double getVal4() {
        return val4;
    }

    public double getVal5() {
        return val5;
    }

    
}
