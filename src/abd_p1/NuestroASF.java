/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd_p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class NuestroASF {
    
    private ArrayList<NuestroRegistro> registros;
    private int pos_actual;
    private BufferedReader flujo;

    public NuestroASF() {
        registros = new ArrayList<NuestroRegistro>();
        pos_actual = 0;
    }
    
    public void open(String ruta) throws FileNotFoundException{
        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        flujo = new BufferedReader(fr);
    }
    
    public void parameters(){
         
    }
    
    
    public NuestroRegistro first(){
        return registros.get(0);
    }
    
    public NuestroRegistro next() {
        pos_actual++;
        return registros.get(pos_actual); 
    } 
    
    public NuestroRegistro end(){
        return registros.get(registros.size()-1);
    }
    
    public void add(NuestroRegistro reg){
        registros.add(reg);
    }
    
    public void search(int id){
        boolean salir=false;
        for(int i=0; i<registros.size() && !salir; i++){
            if(registros.get(id).getId()==id){
                pos_actual=i;
                salir=true;
            }
        }
    }
    
    public void modify(NuestroRegistro nuevo){
        registros.add(pos_actual, nuevo);
    }
    
    public void delete(){
        registros.remove(pos_actual);
    }
    
    public void list() throws IOException{
        if(flujo.ready()){
            for(int i=0; i<registros.size(); i++){
                String val = "Registro " + i + "-> " + registros.get(i).getAnotacion() + registros.get(i).isEstado() + registros.get(i).getId() + registros.get(i).getVal1() + registros.get(i).getVal2() +
            registros.get(i).getVal3() + registros.get(i).getVal4() + registros.get(i).getVal5();
                System.out.print(val);
            }
            
        }
    }
    
    public void list_raw() throws IOException{
        if(flujo.ready()){
            for(int i=0; i<registros.size(); i++){
                String val = "Registro " + i + "-> " + registros.get(i).getVal1() + registros.get(i).getVal2() +
            registros.get(i).getVal3() + registros.get(i).getVal4() + registros.get(i).getVal5();
                System.out.print(val);
            } 
        }
        }
        
    public void close() throws IOException{
       flujo.close();
    }
    
    public void reorganize(String ruta){
        
    }
    
}