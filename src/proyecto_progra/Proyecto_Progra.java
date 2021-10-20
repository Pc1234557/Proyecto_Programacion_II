/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_progra;

import conexionSQL.conexionSQL;

/**
 *
 * @author Pcortez
 */
public class Proyecto_Progra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        conexionSQL c = new conexionSQL();
        if(c.conectar!=null){
            System.out.println("Conexion Exitosa");
        }
    }
    
}
