package abd_p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class NuestroASF {

    // CABECERA
    private byte tam_cabecera, tam_cab_reg, num_atrib; 
    private byte tam_bloq, tam_cab_bloq, num_reg;
    private byte [] sec_tipo_atributos;
    private byte [] sec_tam_tipo_atributos; 
    // -------------------

    // RESTO DE DATOS MIEMBRO
    private ArrayList<NuestroRegistro> registros;
    private int pos_actual;
    private BufferedReader bf;
    // --------------------

    public NuestroASF() {
        // INICIALIZACION METADATOS
        tam_cabecera=16;
        tam_cab_reg=2;
        num_atrib=5;
        registros = new ArrayList<NuestroRegistro>();
        pos_actual = 0;
        
        // SEGUN EL PDF -> 1 para logico, 2 para caracter, 3 para entero, 4 para real y 5 para cadena de caracteres
        sec_tipo_atributos = new byte[num_atrib];
        sec_tipo_atributos[0]=5;
        sec_tipo_atributos[1]=3;
        sec_tipo_atributos[2]=3;
        sec_tipo_atributos[3]=4;
        sec_tipo_atributos[4]=4;
    
        // ARRAY DE CHAR TAM 40, 2 INT, 2 DOUBLE
        sec_tam_tipo_atributos = new byte[num_atrib];
        sec_tam_tipo_atributos[0]= 40;
        sec_tam_tipo_atributos[1]= 4;
        sec_tam_tipo_atributos[2]= 4;
        sec_tam_tipo_atributos[4]= 8;
        sec_tam_tipo_atributos[5]= 8;
    }
    
    public void open(String ruta) throws FileNotFoundException{
        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        bf = new BufferedReader(fr);
    }
    
    public void parameters(){
        //SUPONIENDO QUE FICHERO = ASF, NO?
        int tam_registros=66; // 66 bytes ( CABECERA + DATOS MIEMBRO DE NUESTRO REGISTRO)
        System.out.println("NUMERO DE BLOQUES -> "+(num_reg*tam_registros)/tam_bloq);
        System.out.println("NUMERO DE CABECERAS DE BLOQUE ->"+((num_reg*tam_registros)/tam_bloq)*tam_cab_bloq);
        System.out.println("NUMERO CABECERAS REGISTROS ->"+(registros.size()));
    }
    
    public NuestroRegistro first(){
        NuestroRegistro nr = new NuestroRegistro(registros.get(0).isEstado(), registros.get(0).getId(), registros.get(0).getVal1(), 
        registros.get(0).getVal2(), registros.get(0).getVal3(), registros.get(0).getVal4());
        return nr;
    }
    
    public NuestroRegistro next() {
        NuestroRegistro nr = new NuestroRegistro(registros.get(pos_actual).isEstado(), registros.get(pos_actual).getId(), 
        registros.get(pos_actual).getVal1(), registros.get(pos_actual).getVal2(), registros.get(pos_actual).getVal3(), 
        registros.get(pos_actual).getVal4());
        pos_actual++;//se incrementa la posicion actual
        return nr;
    } 
    
    public boolean end(){
        if(pos_actual==registros.size()-1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void add(NuestroRegistro reg){
        registros.add(reg);
    }
    
    public void search(int id){
        boolean salir=false;
        for(int i=0; i<registros.size() && !salir; i++){
            if(registros.get(i).getId()==id){
                pos_actual=i;
                salir=true;
            }
        }
    }
    
    public void modify(NuestroRegistro nuevo){
        if(pos_actual<0){
            registros.remove(pos_actual);
            registros.add(pos_actual,nuevo);
            pos_actual++; // ?
        }
    }
    
    public void delete(){
        registros.remove(pos_actual);
        pos_actual--; // ?
    }
    
    public void list_raw() throws IOException{
        if(flujo.ready()){
            for(int i=0; i<registros.size(); i++){
                String val = "Registro " + i + "-> " + registros.get(i).isEstado() + registros.get(i).getId() + 
                registros.get(i).getAnotacion().toString() + registros.get(i).getVal1() + registros.get(i).getVal2() +
                registros.get(i).getVal3() + registros.get(i).getVal4();
                System.out.println (val);
            }
            
        }
    }
    
    public void list() throws IOException{
        if(flujo.ready()){
            for(int i=0; i<registros.size(); i++)
            {
                String val = "Registro " + i + "-> " + registros.get(i).getVal1() + registros.get(i).getVal2() +
                registros.get(i).getVal3() + registros.get(i).getVal4();
                System.out.println(val);
            } 
        }
    }
        
    public void close() throws IOException{
       flujo.close();
    }
    
    public void reorganize(String ruta){ //TABLE SPACE
        open(ruta);
        
    }
    
}