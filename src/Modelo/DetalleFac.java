package Modelo;

public class DetalleFac extends Factura
{
    private int idDetalleFac;
    private int cantidadProdu;
    private double importe;
    private double descuento;
    private String activo;
    private int idFactura;
    private int idProducto;

    public DetalleFac(){}

    public DetalleFac(int idDetalleFac, int cantidadProdu, double importe, double descuento, String activo, int idFactura, int idProducto)
    {
        this.idDetalleFac = idDetalleFac;
        this.cantidadProdu = cantidadProdu;
        this.importe = importe;
        this.descuento = descuento;
        this.activo = activo;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    public int getIdDetalleFac()
    {
        return idDetalleFac;
    }

    public int getCantidadProdu()
    {
        return cantidadProdu;
    }

    public double getImporte()
    {
        return importe;
    }

    public double getDescuento()
    {
        return descuento;
    }

    public String getActivo()
    {
        return activo;
    }

    public int getIdFactura()
    {
        return idFactura;
    }

    public int getIdProducto()
    {
        return idProducto;
    }

    public void setIdDetalleFac(int idDetalleFac)
    {
        this.idDetalleFac = idDetalleFac;
    }

    public void setCantidadProdu(int cantidadProdu)
    {
        this.cantidadProdu = cantidadProdu;
    }

    public void setImporte(double importe)
    {
        this.importe = importe;
    }

    public void setDescuento(double descuento)
    {
        this.descuento = descuento;
    }

    public void setActivo(String activo)
    {
        this.activo = activo;
    }

    public void setIdFactura(int idFactura)
    {
        this.idFactura = idFactura;
    }

    public void setIdProducto(int idProducto)
    {
        this.idProducto = idProducto;
    }
}