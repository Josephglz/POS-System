package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura 
{
    private int idFactura;
    private Date fechaFac;
    private double subTotal;
    private double total;
    private double itbis;
    private double pagorecibido;
    private String estado;
    private String activo;
    private int nomCliente;
    private int nomUsuario;

    public Factura() {}

    public Factura(int idFactura, Date fechaFac, double subTotal, double total, double itbis, double pagorecibido, String estado, String activo, int nomCliente, int nomUsuario) {
        this.idFactura = idFactura;
        this.fechaFac = fechaFac;
        this.subTotal = subTotal;
        this.total = total;
        this.itbis = itbis;
        this.pagorecibido = pagorecibido;
        this.estado = estado;
        this.activo = activo;
        this.nomCliente = nomCliente;
        this.nomUsuario = nomUsuario;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFac() {
        return fechaFac;
    }

    public void setFechaFac(Date fechaFac) {
        this.fechaFac = fechaFac;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getItbis() {
        return itbis;
    }

    public void setItbis(double itbis) {
        this.itbis = itbis;
    }

    public double getPagorecibido() {
        return pagorecibido;
    }

    public void setPagorecibido(double pagorecibido) {
        this.pagorecibido = pagorecibido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public int getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(int nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(int nomUsuario) {
        this.nomUsuario = nomUsuario;
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