package formularios;
/**
 *
 * @author dsnie
 */
public class Historial_Ventas {

    int idfactura; 
    String nombre; 
    String direccion; 
    int nit; 
    String producto;
    double precio;
    


public Historial_Ventas(){

    }

public Historial_Ventas(int idfactura, String nombre, String direccion, int nit, String producto, double precio){
    
        this.direccion = direccion; 
        this.idfactura = idfactura;
        this.nit = nit; 
        this.nombre = nombre;
        this.precio = precio;
        this.producto = producto;
    
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}

