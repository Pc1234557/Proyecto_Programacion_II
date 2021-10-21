/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Pcortez
 */
public class loginDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionSQL cn = new conexionSQL();
    
    
    
    public login log(String usuario, String pass){
        login l = new login ();
        String sql ="Select * FROM usuarios WHERE usuario = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs= ps.executeQuery();
                if (rs.next()){
                    l.setId(rs.getInt("id"));
                    l.setUsuario(rs.getString("Usuario"));
                    l.setPass(rs.getString("pass"));
        }
        } catch(SQLException e){
            
        }
    }
    
}
