/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Djauregui
 */
abstract class Articulo {
     private int idproductos, idmarca, existencia;
     private String producto, descripcion;
     private float precio_costo, precio_venta;
    
  public Articulo(){}
    public Articulo( int id, int idproductos, int idmarca, String producto,  String descripcion, float precio_costo, float precio_venta, int existencia) {
        this.idproductos = idproductos;
        this.producto = producto;
        this.idmarca = idmarca;
        this.descripcion = descripcion;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
    }

    public int getId_productos() {
        return idproductos;
    }

    public void setId_productos(int idproductos) {
        this.idproductos = idproductos;
    }

    public int getId_marca() {
        return idmarca;
    }

    public void setId_marca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
 public int agregar(){return 0;}
  public int modificar (){return 0;}
  public int eliminar (){return 0;}
    
    
}
  


