package formularios;

import conexionSQL.conexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sheil
 */
public class GUsuarios {
    
    conexionSQL cc=new conexionSQL();
    Connection con=cc.conexion();
    
    Statement st;
    ResultSet rs;
    String sql;
    
    public void getUsuarios(){
        try{
           sql= "select * from GUsuarios";
           st=cc.conectar.createStatement();
           rs=st.executeQuery(sql);
           while(rs.next()){
           JOptionPane.showMessageDialog(null,rs.getString("Gusuario")+" "+rs.getString("Nombre")+ " "+rs.getString("Genero")+ " "+rs.getString("Direccion")+ " "+rs.getInt("DPI")+ " "+rs.getInt("Telefono")+ " " +rs.getInt("Estado"));
           }
           rs.close();
           }catch(Exception e){
            System.out.println("Error en la operacion "+e.getMessage()); 
    }
    }
        
    public void CrearUsuario(String Gusuario, String Nombre, String Genero, String Direccion, Integer DPI, Integer Telefono, Integer Estado){
        try{
           sql="insert into usuarios values('"+Gusuario+"','"+Nombre+"','"+Genero+"','"+Direccion+"',"+DPI+"',"+Telefono+"'," +Estado+ ")";
           PreparedStatement ps = cc.conectar.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.execute();
           rs=ps.getGeneratedKeys();
           //System.out.println(rs.getString(usuario));
           rs.close();
           //System.out.println("Se creo el usuario de forma correcta");
           JOptionPane.showMessageDialog(null, "Se creo el usuario de forma correcta");
        }catch(Exception e){
            System.out.println("Error en la operacion "+e.getMessage());
        }
    }    
        
    public void getUsuario(String Gusuario){
        try{
           sql="select * from Gusuarios where Gusuario='"+Gusuario+"'";
           st=cc.conectar.createStatement();
           rs=st.executeQuery(sql);
           while(rs.next()){
               //System.out.println(rs.getString("usuario")+" "+rs.getString("nombre")+ " "+rs.getString("clave"));
               JOptionPane.showMessageDialog(null,rs.getString("Gusuario")+" "+rs.getString("Nombre")+ " "+rs.getString("Direccion") );
           } 
           rs.close();
        }catch(Exception e){
            System.out.println("Error en la operacion "+e.getMessage());
        }
    }
    
    public void ModificarUsuario(String Gusuario, String Nombre, String Genero, String Direccion, Integer DPI, Integer Telefono, Integer Estado){
        try{
            sql="update GUsuarios set ";
            
            if(Nombre!=""){
                sql+=" Nombre= '"+Nombre+"',";
            }
            if(!Gusuario.isEmpty()){
                sql+=" Gusuario='"+Gusuario +"',";
            }
            
           sql+= "Estado="+Estado +" where Gusuario='"+Gusuario+"'";
           System.out.println(sql);
           PreparedStatement ps = cc.conectar.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.execute();
           rs=ps.getGeneratedKeys();
           //System.out.println(rs.getString(usuario));
           rs.close();
           //System.out.println("Se modifico el usuario de forma correcta");
           JOptionPane.showMessageDialog(null,"Se modifico el usuario de forma correcta");
            
        }catch(Exception e){
            System.out.println("Error al modificar el usuario"+e.getMessage());
        }
    }
    
    public void EliminarUsuario(String Gusuario){
        try{
           sql="delete from GUsuarios where Gusuario='"+Gusuario+"'";
           PreparedStatement ps = cc.conectar.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.execute();
           rs=ps.getGeneratedKeys();
           rs.close();
           //System.out.println("Se Elimino el usuario con exito "+ usuario);
           JOptionPane.showMessageDialog(null,"Se Elimino el usuario con exito "+ Gusuario);
        }catch(Exception e){
            System.out.println("Error en la operacion "+e.getMessage());
        }
    }
    
    } 
