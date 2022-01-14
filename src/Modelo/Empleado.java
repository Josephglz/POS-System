package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado extends Persona
{
    private int idEmpleado;
    private String Puesto;
    private double Sueldo;
    private String Estado;
    private String activo;
    private int numPersona;

    public Empleado(int idEmpleado, String Puesto, double Sueldo, String Estado, String activo, int numPersona)
    {
        this.idEmpleado = idEmpleado;
        this.Puesto = Puesto;
        this.Sueldo = Sueldo;
        this.Estado = Estado;
        this.activo = activo;
        this.numPersona = numPersona;
    }

    public Empleado(){}

    public int getIdEmpleado()
    {
        return idEmpleado;
    }

    public String getPuesto()
    {
        return Puesto;
    }

    public double getSueldo()
    {
        return Sueldo;
    }

    public String getEstado()
    {
        return Estado;
    }

    public String getActivo()
    {
        return activo;
    }

    public int getNumPersona()
    {
        return numPersona;
    }

    public void setIdEmpleado(int idEmpleado)
    {
        this.idEmpleado = idEmpleado;
    }

    public void setPuesto(String Puesto)
    {
        this.Puesto = Puesto;
    }

    public void setSueldo(double Sueldo)
    {
        this.Sueldo = Sueldo;
    }

    public void setEstado(String Estado)
    {
        this.Estado = Estado;
    }

    public void setActivo(String activo)
    {
        this.activo = activo;
    }

    public void setNumPersona(int numPersona)
    {
        this.numPersona = numPersona;
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