/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Pcortez
 */
public class conexionSQL {
        
    public Connection conectar=null;
     
    public Connection conexion() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","14092017");
            JOptionPane.showMessageDialog(null,"Conexion Exitosa");
            
    } catch(Exception e){
        JOptionPane.showMessageDialog(null,"Conexion Fallida" + e.getMessage());
    }
        return conectar;
    }
}
