package Modelo;

public class Categoria
{
    private int idCategoria;
    private String nombreCat;
    private String descripcionCat;
    private String activo;

    public Categoria(int idCategoria, String nombreCat, String descripcionCat, String activo)
    {
        this.idCategoria = idCategoria;
        this.nombreCat = nombreCat;
        this.descripcionCat = descripcionCat;
        this.activo = activo;
    }

    public Categoria(){}

    public int getIdCategoria()
    {
        return idCategoria;
    }

    public String getNombreCat()
    {
        return nombreCat;
    }

    public String getDescripcionCat()
    {
        return descripcionCat;
    }

    public String getActivo()
    {
        return activo;
    }

    public void setIdCategoria(int idCategoria)
    {
        this.idCategoria = idCategoria;
    }

    public void setNombreCat(String nombreCat)
    {
        this.nombreCat = nombreCat;
    }

    public void setDescripcionCat(String descripcionCat)
    {
        this.descripcionCat = descripcionCat;
    }

    public void setActivo(String activo)
    {
        this.activo = activo;
    }
}