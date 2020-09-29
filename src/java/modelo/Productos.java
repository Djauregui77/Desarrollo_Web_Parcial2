/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Djauregui
 */
public class Productos extends Articulo { 
    private int idproductos;
    
    private int idmarca;
    
    Conexion cn;
    public Productos() {}
    
    public Productos (int idproductos, int idmarca, int id, String producto, String descripcion, float precio_costo, float precio_venta, int existencia) {
        super(id, idproductos, idmarca, producto, descripcion, precio_costo, precio_venta, existencia);
        this.idproductos = idproductos;
        this.idmarca = idmarca;
    }

    public int getIdProductos() {
        return idproductos;
    }

    public void setIdProductos(int idProductos) {
        this.idproductos = idProductos;
    }

    public int getIdMarca() {
        return idmarca;
    }

    public void setIdMarca(int idmarca) {
        this.idmarca = idmarca;
    }
    public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "SELECT p.idproducto as id,p.producto,p.descripcion,p.precio_costo,p.precio_venta,p.existencia,m.id_marca,m.marca FROM productos as p inner join marcas as m on p.idproducto = m.idmarca;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"idproductos","producto","descripcion","precio_costo","precio_venta","existencia","idmarca","marca"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[8];
      while (consulta.next()){
          datos[0] = consulta.getString("idproducto");
          datos[1] = consulta.getString("producto");
          datos[2] = consulta.getString("descripcion");
          datos[3] = consulta.getString("precio_costo");
          datos[4] = consulta.getString("precio_venta");
          datos[5] = consulta.getString("existencia");
          datos[6] = consulta.getString("idmarca");
          datos[7] = consulta.getString("marca");
          
          tabla.addRow(datos);
      
      }
      
     cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    @Override
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into productosss(idproducto, producto, descripcion, precio_costo, precio_venta, existencia, idmarca) values(?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1,getIdProductos());
            parametro.setString(2,getProducto());
            parametro.setString(3,getDescripcion());
            parametro.setFloat(4,getPrecio_costo());
            parametro.setFloat(5,getPrecio_venta());
            parametro.setInt(6,getExistencia());
            parametro.setInt(7,getId_marca());
         
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    @Override
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update productos set producto= ?,descriocion= ?,precio_costo= ?,precio_vemta= ?,existencia= ?,idmarca= ? where idproductos = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1,getIdProductos());
            parametro.setString(2,getProducto());
            parametro.setString(3,getDescripcion());
            parametro.setFloat(4,getPrecio_costo());
            parametro.setFloat(5,getPrecio_venta());
            parametro.setInt(6,getExistencia());
            parametro.setInt(7,getId_marca());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    @Override
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from productos  where idproductos = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId_productos());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
}
