/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dsnie
 */
public class RVenta {
Conexion cn=new Conexion();
Connection con; 
PreparedStatement ps;
ResultSet rs; 
int r=0;

public String IDVentas(){

String idv="";
String sql="select max(IDVentas) from ventas";
try{
    con = cn.Conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
        idv=rs.getString(1);
    }
} catch (Exception e){
    
}
return idv;
} 
public int GuardarVentas(Ventas v){
    Ventas ventas = new Ventas();
    String sql="insert into Ventas(Codigo de Facturas, Nombre, Ventas, Nit, Producto, Total) values(?,?,?,?,?,?)";
    try {
        con=cn.Conectar();
        ps=con.prepareStatement(sql);
        ps.setInt(1, v.getIdfactura());
        ps.setInt(4, v.getNit());
        ps.setString(2, v.getNombre());
        ps.setString(3, v.getDireccion());
        ps.setString(5, v.getProducto());
        ps.setDouble(6, v.getPrecio());
        
    }catch (Exception e){
        
    }

    return r;
}

}
