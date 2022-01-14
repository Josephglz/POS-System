package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pago 
{
    private double montoPagar;
    private Date fechaDelPago;
    private int numCliente;
    private int numFactura;
    
    public Pago() {}

    public Pago(double montoPagar, Date fechaDelPago, int numCliente, int numFactura) 
    {
        this.montoPagar = montoPagar;
        this.fechaDelPago = fechaDelPago;
        this.numCliente = numCliente;
        this.numFactura = numFactura;
    }

    public double getMontoPagar() 
    {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) 
    {
        this.montoPagar = montoPagar;
    }

    public Date getFechaDelPago() 
    {
        return fechaDelPago;
    }

    public void setFechaDelPago(Date fechaDelPago) 
    {
        this.fechaDelPago = fechaDelPago;
    }

    public int getNumCliente() 
    {
        return numCliente;
    }

    public void setNumCliente(int numCliente) 
    {
        this.numCliente = numCliente;
    }

    public int getNumFactura() 
    {
        return numFactura;
    }   

    public void setNumFactura(int numFactura) 
    {
        this.numFactura = numFactura;
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
