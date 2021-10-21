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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pcortez
 */
//Se utilizara el patron DAO (Data Acces Object)
public class ClienteDao {
    conexionSQL cn=new conexionSQL();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl){
    String sql = "INSERT INTO clientes (NIT, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try{
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getNIT());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
             return false;
        }finally{
        try{
            con.close();
        }catch(SQLException e){
            System.out.println( e.toString());
            }
        }
    }
    
    public List ListarCliente(){
        List<Cliente> ListaCl =new ArrayList();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
            Cliente cl = new Cliente();
            cl.setId(rs.getInt("id"));
            cl.setNIT(rs.getInt("nit"));
            cl.setNombre(rs.getString("nombre"));
            cl.setTelefono(rs.getInt("telefono"));
            cl.setDireccion(rs.getString("direccion"));
            ListaCl.add(cl);
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }
}