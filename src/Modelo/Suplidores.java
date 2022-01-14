package Modelo;

public class Suplidores extends Persona
{
    private int idSupli;
    private String empresa;
    private String prestablecimiento;
    private String activo;
    private int numPersona;
    
    public Suplidores() {}

    public Suplidores(int idSupli, String empresa, String prestablecimiento, String activo, int numPersona) 
    {
        this.idSupli = idSupli;
        this.empresa = empresa;
        this.prestablecimiento = prestablecimiento;
        this.activo = activo;
        this.numPersona = numPersona;
    }

    public int getIdSupli() 
    {
        return idSupli;
    }

    public void setIdSupli(int idSupli) 
    {
        this.idSupli = idSupli;
    }

    public String getEmpresa() 
    {
        return empresa;
    }

    public void setEmpresa(String empresa) 
    {
        this.empresa = empresa;
    }

    public String getPrestablecimiento() 
    {
        return prestablecimiento;
    }

    public void setPrestablecimiento(String prestablecimiento) 
    {
        this.prestablecimiento = prestablecimiento;
    }

    public String getActivo() 
    {
        return activo;
    }

    public void setActivo(String activo) 
    {
        this.activo = activo;
    }

    public int getNumPersona() 
    {
        return numPersona;
    }

    public void setNumPersona(int numPersona) 
    {
        this.numPersona = numPersona;
    }
}
