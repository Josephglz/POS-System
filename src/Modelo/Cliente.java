package Modelo;

import java.util.Date;

public class Cliente extends Persona
{
    private int idCliente;
    private double creditos;
    private int numPersona;

    public Cliente(int idCliente, double creditos, String activo, int numPersona)
    {
        this.idCliente = idCliente;
        this.creditos = creditos;
        this.numPersona = numPersona;
    }

    public Cliente(){}

    public Cliente(int id, String nombre, String apellido, String genero, String direccion, String telefono, String celular, String cedula, Date fechaActual, double credito)
    {
        super(id, nombre, apellido, genero, direccion, telefono, celular, cedula, fechaActual);
        this.creditos = credito;
    }

    public int getIdCliente()
    {
        return idCliente;
    }

    public double getCreditos()
    {
        return creditos;
    }

    public int getNumPersona()
    {
        return numPersona;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public void setCreditos(double creditos)
    {
        this.creditos = creditos;
    }

    public void setNumPersona(int numPersona)
    {
        this.numPersona = numPersona;
    }
}