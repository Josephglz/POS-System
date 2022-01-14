package Modelo;

public class Almacen extends Producto
{
    private int idAlmacen;
    private int cantidadTotal;

    public Almacen(int idAlmacen, int cantidadTotal)
    {
        this.idAlmacen = idAlmacen;
        this.cantidadTotal = cantidadTotal;
    }

    public Almacen(){}

    public int getIdAlmacen()
    {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen)
    {
        this.idAlmacen = idAlmacen;
    }

    public int getCantidadTotal()
    {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal)
    {
        this.cantidadTotal = cantidadTotal;
    }
}