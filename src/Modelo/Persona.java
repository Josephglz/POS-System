package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona
{
    private int idPersona;
    private String nombre;
    private String apellido;
    private String genero;
    private String direccion;
    private String telefono;
    private String celular;
    private String cedula;
    private Date fechaReg;
    
    public Persona() {}

    public Persona(int idPersona, String nombre, String apellido, String genero, String direccion, String telefono, String celular, String cedula, Date fechaReg) 
    {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.cedula = cedula;
        this.fechaReg = fechaReg;
    }

    public int getIdPersona() 
    {
        return idPersona;
    }

    public void setIdPersona(int idPersona) 
    {
        this.idPersona = idPersona;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public String getCelular() 
    {
        return celular;
    }

    public void setCelular(String celular) 
    {
        this.celular = celular;
    }

    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }

    public Date getFechaReg() 
    {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) 
    {
        this.fechaReg = fechaReg;
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
