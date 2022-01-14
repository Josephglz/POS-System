package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto 
{
    private int idProducto;
    private String nombrePro;
    private String descripcionPro;
    private double precioVenta;
    private double precioCompra;
    private int cantidadProdu;
    private Date fechaCompra;
    private Date fechaVenci;
    private String activo;
    private int numCatego;
    private int numSupli;
    
    public Producto() {}

    public Producto(int idProducto, String nombrePro, String descripcionPro, double precioVenta, double precioCompra, int cantidadProdu, Date fechaCompra, Date fechaVenci, String activo, int numCatego, int numSupli) 
    {
        this.idProducto = idProducto;
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.cantidadProdu = cantidadProdu;
        this.fechaCompra = fechaCompra;
        this.fechaVenci = fechaVenci;
        this.activo = activo;
        this.numCatego = numCatego;
        this.numSupli = numSupli;
    }

    public int getIdProducto() 
    {
        return idProducto;
    }

    public void setIdProducto(int idProducto) 
    {
        this.idProducto = idProducto;
    }

    public String getNombrePro() 
    {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) 
    {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() 
    {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) 
    {
        this.descripcionPro = descripcionPro;
    }

    public double getPrecioVenta() 
    {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) 
    {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() 
    {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) 
    {
        this.precioCompra = precioCompra;
    }

    public int getCantidadProdu() 
    {
        return cantidadProdu;
    }

    public void setCantidadProdu(int cantidadProdu) 
    {
        this.cantidadProdu = cantidadProdu;
    }

    public Date getFechaCompra() 
    {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) 
    {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaVenci() 
    {
        return fechaVenci;
    }

    public void setFechaVenci(Date fechaVenci) 
    {
        this.fechaVenci = fechaVenci;
    }

    public String getActivo() 
    {
        return activo;
    }

    public void setActivo(String activo) 
    {
        this.activo = activo;
    }

    public int getNumCatego() 
    {
        return numCatego;
    }

    public void setNumCatego(int numCatego) 
    {
        this.numCatego = numCatego;
    }

    public int getNumSupli() 
    {
        return numSupli;
    }

    public void setNumSupli(int numSupli) 
    {
        this.numSupli = numSupli;
    }

    public String getFormatearFecha(Date fecha, String formato)
    {
        SimpleDateFormat sdf = null;
        if(formato == null)
        {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        else
        {
            sdf = new SimpleDateFormat(formato);
        }
        return sdf.format(fecha);
    }
}
